package com.bingo.dianping.common;

import lombok.Data;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:26 2020/5/13
 * @Description: 统一返回结果
 */
@Data
public class Result {

    private static final String SUCCESS = "success";

    /**
     * 处理结果：success / fail
     */
    private String status;

    /**
     * 当status为success时，表明对应的json类数据
     * 当status为fail时，为错误码
     */
    private Object data;

    public static Result create(Object result) {
        return Result.create(result, SUCCESS);
    }

    public static Result create(Object objResult, String status) {
        Result result = new Result();
        result.setData(objResult);
        result.setStatus(status);
        return result;
    }

}
