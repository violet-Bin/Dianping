package com.bingo.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: jiangjiabin
 * @Date: Create in 20:44 2020/5/16
 * @Description:
 */
@Data
public class LoginReq {

    @NotBlank(message = "手机号不能为空")
    private String telphone;

    @NotBlank(message = "密码不能为空")
    private String password;

}
