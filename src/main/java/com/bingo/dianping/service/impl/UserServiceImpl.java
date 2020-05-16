package com.bingo.dianping.service.impl;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.utils.MD5Utils;
import com.bingo.dianping.dal.UserModelMapper;
import com.bingo.dianping.model.UserModel;
import com.bingo.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 1:33 2020/5/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public UserModel register(UserModel registerUser) throws BusinessException, NoSuchAlgorithmException {
        registerUser.setCreated(new Date());
        registerUser.setModified(new Date());
        registerUser.setPassword(MD5Utils.encodeByMD5(registerUser.getPassword()));
        try {
            userModelMapper.insertSelective(registerUser);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(ErrorCodeEnum.REGISTER_DUP_FAIL);
        }

        return getUser(registerUser.getId());
    }

    @Override
    public UserModel login(String telphone, String password) throws NoSuchAlgorithmException, BusinessException {
        UserModel userModel = userModelMapper.selectByTelphoneAndPassword(telphone, MD5Utils.encodeByMD5(password));
        if (userModel == null) {
            throw new BusinessException(ErrorCodeEnum.LOGIN_FAIL);
        }
        return userModel;
    }


}
