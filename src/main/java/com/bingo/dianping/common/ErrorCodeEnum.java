package com.bingo.dianping.common;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:38 2020/5/13
 * @Description: 错误码枚举
 */
public enum ErrorCodeEnum {

    //通用的错误类型
    NO_OBJECT_FOUND(10001, "请求对象不存在"),
    UNKNOWN_ERROR(10002, "未知错误"),
    NO_HANDLER_FOUND(10003, "找不到执行的路径操作"),
    BIND_EXCEPTION_ERROR(10004, "请求参数错误"),
    PARAMETER_VALIDATE_ERROR(10005, "请求参数校验失败"),

    //用户服务相关的错误类型
    REGISTER_DUP_FAIL(20001, "用户已存在"),
    LOGIN_FAIL(20002, "手机号或密码错误"),

    //管理员相关
    ADMIN_SHOULD_LOGIN(30001, "管理员应该先登录"),

    //品类相关
    CATEGORY_NAME_DUPLICATED(40001, "品类名已经存在"),

    ;


    private Integer errorCode;
    private String errorMsg;

    ErrorCodeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
