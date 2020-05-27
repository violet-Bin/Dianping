package com.bingo.dianping.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.dal.ShopModelMapper;
import com.bingo.dianping.model.CategoryModel;
import com.bingo.dianping.model.SellerModel;
import com.bingo.dianping.model.ShopModel;
import com.bingo.dianping.service.CategoryService;
import com.bingo.dianping.service.SellerService;
import com.bingo.dianping.service.ShopService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:39 2020/5/17
 * @Description:
 */
@Service
@Slf4j
public class ShopServiceImpl implements ShopService {

    private static final String SHOP_INDEX = "shop";
    private static final String NAME = "name";

    @Resource
    private CategoryService categoryService;
    @Resource
    private SellerService sellerService;
    @Resource
    private ShopModelMapper shopModelMapper;
    @Resource
    private RestHighLevelClient highLevelClient;

    @Override
    @Transactional
    public ShopModel create(ShopModel shopModel) throws BusinessException {

        SellerModel sellerModel = sellerService.get(shopModel.getSellerId());
        if (sellerModel == null) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, "商户不存在");
        }
        if (sellerModel.getDisabledFlag() == 1) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, "商户已禁用");
        }
        CategoryModel categoryModel = categoryService.get(shopModel.getCategoryId());
        if (categoryModel == null) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, "类目不存在");
        }
        shopModelMapper.insertSelective(shopModel);

        return get(shopModel.getId());
    }

    @Override
    public ShopModel get(Integer id) {
        ShopModel shopModel = shopModelMapper.selectByPrimaryKey(id);
        if (shopModel == null) {
            return null;
        }
        shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
        shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        return shopModel;
    }

    @Override
    public List<ShopModel> selectAll() {
        List<ShopModel> shopModels = shopModelMapper.selectAll();
        shopModels.forEach(shopModel -> {
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        });
        return shopModels;
    }

    @Override
    public Integer countAllShop() {
        return shopModelMapper.countAllShop();
    }

    @Override
    public List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude) {
        List<ShopModel> shopModels = shopModelMapper.recommend(longitude, latitude);
        shopModels.forEach(shopModel -> {
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        });
        return shopModels;
    }

    @Override
    public List<ShopModel> search(BigDecimal longitude, BigDecimal latitude,
                                  String keyword, Integer orderby, Integer categoryId, String tags) {

        List<ShopModel> shopModelList = shopModelMapper.search(longitude, latitude, keyword, orderby, categoryId, tags);
        shopModelList.forEach(shopModel -> {
            shopModel.setCategoryModel(categoryService.get(shopModel.getCategoryId()));
            shopModel.setSellerModel(sellerService.get(shopModel.getSellerId()));
        });

        return shopModelList;
    }

    @Override
    public List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags) {
        return shopModelMapper.searchGroupByTags(keyword,categoryId, tags);
    }

    @Override
    public Map<String, Object> searchES(BigDecimal longitude, BigDecimal latitude, String keyword, Integer orderby, Integer categoryId, String tags) throws IOException {
        Map<String, Object> result = Maps.newHashMap();

//        SearchRequest searchRequest = new SearchRequest(SHOP_INDEX);
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.matchQuery(NAME, keyword));
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//
//        searchRequest.source(sourceBuilder);
//        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHit[] hits = searchResponse.getHits().getHits();
//
//        List<Integer> shopIdList = Lists.newArrayList();
//        List<SearchHit> searchHits = Arrays.asList(hits);
//        searchHits.forEach(hit -> shopIdList.add(new Integer(hit.getSourceAsMap().get("id").toString())));
//        List<ShopModel> shopModelList = shopIdList.stream().map(this::get).collect(Collectors.toList());

        Request request = new Request("GET", "/shop/_search");
        String reqJson = "{\n" +
                "  \"_source\":\"*\",\n" +
                "  \"script_fields\": {\n" +
                "    \"distance\": {\n" +
                "      \"script\": {\n" +
                "        \"source\": \"haversin(lat, lon, doc['location'].lat,doc['location'].lon)\",\n" +
                "        \"lang\": \"expression\",\n" +
                "        \"params\":{\"lat\":"+ latitude.toString() + ", \"lon\":"+ longitude.toString() +"}\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"query\": {\n" +
                "    \"function_score\": {\n" +
                "      \"query\": {\n" +
                "        \"bool\": {\n" +
                "          \"must\": [\n" +
                "            {\"match\": {\"name\":{\"query\": \"" + keyword + "\", \"boost\": 0.1}}},\n" +
                "            {\"term\": {\"seller_disabled_flag\": 0}}\n" +
                "          ]\n" +
                "        }\n" +
                "      },\n" +
                "      \"functions\": [\n" +
                "        {\n" +
                "          \"gauss\": {\n" +
                "            \"location\": {\n" +
                "              \"origin\": \"" + latitude.toString() + ", "+ longitude.toString() + "\",\n" +
                "              \"scale\": \"100km\",\n" +
                "              \"offset\": \"0km\",\n" +
                "              \"decay\": 0.5\n" +
                "            }\n" +
                "          },\n" +
                "          \"weight\": 9\n" +
                "        },\n" +
                "        {\n" +
                "          \"field_value_factor\": {\n" +
                "            \"field\": \"remark_score\"\n" +
                "          },\n" +
                "          \"weight\": 0.2\n" +
                "        },\n" +
                "        {\n" +
                "          \"field_value_factor\": {\n" +
                "            \"field\": \"seller_remark_score\"\n" +
                "          },\n" +
                "          \"weight\": 0.1\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score_mode\": \"sum\",\n" +
                "      \"boost_mode\": \"sum\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"sort\": [\n" +
                "    {\n" +
                "      \"_score\": {\n" +
                "        \"order\": \"desc\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        log.error("reqJson: {}", reqJson);
        request.setJsonEntity(reqJson);
        Response response = highLevelClient.getLowLevelClient().performRequest(request);
        String responseStr = EntityUtils.toString(response.getEntity());
        log.error("responseStr：{}", responseStr);
        JSONObject jsonObject = JSONObject.parseObject(responseStr);
        JSONArray jsonArray = jsonObject.getJSONObject("hits").getJSONArray("hits");

        List<ShopModel> shopModelList = Lists.newArrayList();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObj = jsonArray.getJSONObject(i);
            Integer id = Integer.valueOf(jsonObj.get("_id").toString());
            BigDecimal distance = new BigDecimal(jsonObj.getJSONObject("fields").getJSONArray("distance").get(0).toString());
            ShopModel shopModel = get(id);
            shopModel.setDistance(distance.multiply(new BigDecimal(1000)).setScale(0, BigDecimal.ROUND_CEILING).intValue());
            shopModelList.add(shopModel);
        }


        result.put("shop", shopModelList);
        return result;
    }
}
