package com.bingo.dianping.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:16 2020/5/18
 * @Description:
 */
@Data
public class ShopCreateReq {

    @NotBlank(message = "服务名不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9\\u4E00-\\u9FA5]{1,16}$", message = "昵称只能包含数字、字母、汉字且长度在1-16之间")
    private String name;

    @NotNull(message = "人均价不能为空")
    private Integer pricePerMan;

    @NotNull(message = "纬度不能为空")
    private BigDecimal latitude;

    @NotNull(message = "经度不能为空")
    private BigDecimal longitude;

    @NotNull(message = "服务类目不能为空")
    private Integer categoryId;

    private String tags;

    @NotBlank(message = "营业开始时间不能为空")
    private String startTime;

    @NotBlank(message = "营业结束时间不能为空")
    private String endTime;

    @NotBlank(message = "地址不能为空")
    private String address;

    @NotNull(message = "商家ID不能为空")
    private Integer sellerId;

    @NotBlank(message = "图标不能为空")
    private String iconUrl;


}
