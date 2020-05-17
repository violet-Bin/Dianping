package com.bingo.dianping.service;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.model.ShopModel;

import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:38 2020/5/17
 * @Description:
 */
public interface ShopService {

    ShopModel create(ShopModel shopModel) throws BusinessException;
    ShopModel get(Integer id);
    List<ShopModel> selectAll();

}
