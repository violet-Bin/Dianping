package com.bingo.dianping.service;

import com.bingo.dianping.model.SellerModel;

import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 17:27 2020/5/17
 * @Description:
 */
public interface SellerService {

    SellerModel create(SellerModel sellerModel);
    SellerModel get(Integer id);
    List<SellerModel> selectAll();
    SellerModel changeStatus();

    Integer countAllSeller();
}
