package com.bingo.dianping.common.convert;

import com.bingo.dianping.model.UserModel;
import com.bingo.dianping.request.RegisterReq;

/**
 * @Author: jiangjiabin
 * @Date: Create in 1:09 2020/5/14
 * @Description:
 */
public class UserModelConvertUtils {

    public static UserModel register2UserModel(RegisterReq registerReq) {
        UserModel userModel = new UserModel();
        userModel.setTelphone(registerReq.getTelphone());
        userModel.setPassword(registerReq.getPassword());
        userModel.setNickName(registerReq.getNickName());
        userModel.setGender(registerReq.getGender());
        return userModel;
    }

}
