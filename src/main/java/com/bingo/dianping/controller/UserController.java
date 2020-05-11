package com.bingo.dianping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 1:06 2020/5/12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }
}
