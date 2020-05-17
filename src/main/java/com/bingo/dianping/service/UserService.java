package com.bingo.dianping.service;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.model.UserModel;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 1:17 2020/5/12
 */
public interface UserService {

    UserModel getUser(Integer id);

    UserModel register(UserModel registerUser) throws BusinessException, NoSuchAlgorithmException;

    UserModel login(String telphone, String password) throws NoSuchAlgorithmException, BusinessException;

    Integer getCountUser();
}
