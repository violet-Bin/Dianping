package com.bingo.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @Author: jiangjiabin
 * @Date: Create in 17:51 2020/5/17
 * @Description:
 */
@Data
public class SellerCreateReq {

    @NotBlank(message = "商户名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4E00-\\u9FA5]{6,16}$", message = "商户名只能包含数字、字母、汉字且长度在6-16之间")
    private String name;

}
