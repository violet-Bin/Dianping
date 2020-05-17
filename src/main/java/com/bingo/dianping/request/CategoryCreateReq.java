package com.bingo.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @Author: jiangjiabin
 * @Date: Create in 22:22 2020/5/17
 * @Description:
 */
@Data
public class CategoryCreateReq {

    @NotBlank(message = "名字不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4E00-\\u9FA5]{1,16}$", message = "昵称只能包含数字、字母、汉字且长度在1-16之间")
    private String name;

    @NotBlank(message = "iconUrl不能为空")
    private String iconUrl;

    @NotNull(message = "权重不能为空")
    private Integer sort;

}
