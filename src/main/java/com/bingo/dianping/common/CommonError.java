package com.bingo.dianping.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:35 2020/5/13
 * @Description: error对象
 */
@Data
@AllArgsConstructor
public class CommonError {

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    public CommonError(ErrorCodeEnum errorCodeEnum) {
        this.errorCode = errorCodeEnum.getErrorCode();
        this.errorMsg = errorCodeEnum.getErrorMsg();
    }

}
