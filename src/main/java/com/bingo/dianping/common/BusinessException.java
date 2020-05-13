package com.bingo.dianping.common;

import lombok.Data;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:49 2020/5/13
 * @Description: 业务异常类
 */
public class BusinessException extends Exception {

    private CommonError commonError;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super();
        this.commonError = new CommonError(errorCodeEnum);
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum, String errMsg) {
        super();
        this.commonError = new CommonError(errorCodeEnum);
        this.commonError.setErrorMsg(errMsg);
    }

    public CommonError getCommonError() {
        return commonError;
    }

    public void setCommonError(CommonError commonError) {
        this.commonError = commonError;
    }
}
