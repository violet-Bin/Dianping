package com.bingo.dianping.request;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @Author: jiangjiabin
 * @Date: Create in 1:06 2020/5/14
 * @Description:
 */
@Data
public class RegisterReq {

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^1([35784])\\d{9}", message = "手机号格式不正确")
    private String telphone;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "昵称不能为空")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,17}$", message = "昵称只能以字母开头，长度在6-18之间，只能包含字符、数字和下划线。")
    private String nickName;

    @NotNull(message = "性别不能为空")
    @Max(value = 2, message = "性别只能是1或2")
    @Min(value = 1, message = "性别只能是1或2")
    private Integer gender;

}
