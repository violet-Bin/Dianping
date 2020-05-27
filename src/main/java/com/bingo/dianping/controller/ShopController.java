package com.bingo.dianping.controller;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.Result;
import com.bingo.dianping.model.CategoryModel;
import com.bingo.dianping.model.ShopModel;
import com.bingo.dianping.service.CategoryService;
import com.bingo.dianping.service.ShopService;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiangjiabin
 * @Date: Create in 0:24 2020/5/19
 * @Description:
 */
@Controller("/shop")
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @Resource
    private CategoryService categoryService;

    //推荐服务
    @RequestMapping("/recommend")
    @ResponseBody
    public Result recommend(@RequestParam(name = "longitude") BigDecimal longitude,
                            @RequestParam(name = "latitude") BigDecimal latitude) throws BusinessException {

        if (longitude == null || latitude == null) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR);
        }

        List<ShopModel> shopModels = shopService.recommend(longitude, latitude);
        return Result.create(shopModels);
    }

    //搜索服务
    @RequestMapping("/search")
    @ResponseBody
    public Result search(@RequestParam(name = "longitude") BigDecimal longitude,
                         @RequestParam(name = "latitude") BigDecimal latitude,
                         @RequestParam(name = "keyword") String keyword,
                         @RequestParam(name = "orderby", required = false) Integer orderby,
                         @RequestParam(name = "categoryId", required = false) Integer categoryId,
                         @RequestParam(name = "tags", required = false) String tags) throws BusinessException, IOException {

        if (longitude == null || latitude == null || StringUtils.isEmpty(keyword)) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR);
        }

        List<ShopModel> shopModels = (List<ShopModel>) shopService.searchES(longitude, latitude, keyword, orderby, categoryId, tags).get("shop");
        //List<ShopModel> shopModels = shopService.search(longitude, latitude, keyword, orderby, categoryId, tags);

        List<CategoryModel> categoryModels = categoryService.selectAll();
        List<Map<String, Object>> tagsAggregation = shopService.searchGroupByTags(keyword, categoryId, tags);
        Map<String, Object> resMap = Maps.newHashMap();
        resMap.put("shop", shopModels);
        resMap.put("category", categoryModels);
        resMap.put("tags", tagsAggregation);

        return Result.create(resMap);
    }


}
