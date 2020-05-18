package com.bingo.dianping.service.impl;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.dal.ShopModelMapper;
import com.bingo.dianping.model.CategoryModel;
import com.bingo.dianping.model.SellerModel;
import com.bingo.dianping.model.ShopModel;
import com.bingo.dianping.service.CategoryService;
import com.bingo.dianping.service.SellerService;
import com.bingo.dianping.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:39 2020/5/17
 * @Description:
 */
@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private CategoryService categoryService;
    @Resource
    private SellerService sellerService;
    @Resource
    private ShopModelMapper shopModelMapper;

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
}
