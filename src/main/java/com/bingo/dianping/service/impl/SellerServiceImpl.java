package com.bingo.dianping.service.impl;

import com.bingo.dianping.dal.SellerModelMapper;
import com.bingo.dianping.model.SellerModel;
import com.bingo.dianping.service.SellerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author: jiangjiabin
 * @Date: Create in 17:29 2020/5/17
 * @Description:
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerModelMapper sellerModelMapper;

    @Override
    @Transactional
    public SellerModel create(SellerModel sellerModel) {
        sellerModel.setCreated(new Date());
        sellerModel.setModified(new Date());
        sellerModel.setRemarkScore(BigDecimal.ZERO);
        sellerModel.setDisabledFlag(0);
        sellerModelMapper.insertSelective(sellerModel);
        return get(sellerModel.getId());
    }

    @Override
    public SellerModel get(Integer id) {
        return sellerModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SellerModel> selectAll() {
        return sellerModelMapper.selectAll();
    }

    @Override
    public SellerModel changeStatus() {
        return null;
    }

    @Override
    public Integer countAllSeller() {
        return sellerModelMapper.countAllSeller();
    }
}
