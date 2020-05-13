package com.bingo.dianping.common.utils;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: jiangjiabin
 * @Date: Create in 1:00 2020/5/14
 * @Description:
 */
public class MD5Utils {


    public static String encodeByMD5(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes(StandardCharsets.UTF_8)));
    }

}
