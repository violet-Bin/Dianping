package com.bingo.dianping.service.impl;

import com.bingo.dianping.dal.UserModelMapper;
import com.bingo.dianping.model.UserModel;
import com.bingo.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 1:33 2020/5/12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }
}
