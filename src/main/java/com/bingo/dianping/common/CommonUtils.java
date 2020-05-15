package com.bingo.dianping.common;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * @Author: jiangjiabin
 * @Date: Create in 1:23 2020/5/14
 * @Description:
 */
public class CommonUtils {

    public static String processErrorString(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getDefaultMessage() + ", ");
        }
        sb.substring(0, sb.length() - 1);
        return sb.toString();
    }

}
