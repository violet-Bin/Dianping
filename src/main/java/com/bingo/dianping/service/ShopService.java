package com.bingo.dianping.service;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.model.ShopModel;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:38 2020/5/17
 * @Description:
 */
public interface ShopService {

    ShopModel create(ShopModel shopModel) throws BusinessException;
    ShopModel get(Integer id);
    List<ShopModel> selectAll();

    Integer countAllShop();

    List<ShopModel> recommend(BigDecimal longitude, BigDecimal latitude);

    List<ShopModel> search(BigDecimal longitude, BigDecimal latitude,
                           String keyword, Integer orderby, Integer categoryId, String tags);

    List<Map<String, Object>> searchGroupByTags(String keyword, Integer categoryId, String tags);

    /**
     * v2.0
     */
    Map<String, Object> searchES(BigDecimal longitude, BigDecimal latitude,
                               String keyword, Integer orderby, Integer categoryId, String tags) throws IOException;
}
