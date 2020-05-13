package com.bingo.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: jiangjiabin
 * @Date: Create in 1:06 2020/5/14
 * @Description:
 */
@Data
public class RegisterReq {

    @NotBlank(message = "手机号不能为空")
    private String telphone;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "昵称不能为空")
    private String nickName;

    @NotBlank(message = "性别不能为空")
    private Integer gender;

}
