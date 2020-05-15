package com.bingo.dianping.controller;

import com.bingo.dianping.common.*;
import com.bingo.dianping.common.convert.UserModelConvertUtils;
import com.bingo.dianping.model.UserModel;
import com.bingo.dianping.request.RegisterReq;
import com.bingo.dianping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: jiangjiabin
 * @Description:
 * @Date: Create in 1:06 2020/5/12
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        String userName = "bingo";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name", userName);
        return modelAndView;
    }

    @RequestMapping("/get")
    @ResponseBody
    public Result getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null) {
            throw new BusinessException(ErrorCodeEnum.NO_OBJECT_FOUND);
        } else {
            return Result.create(userModel);
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public Result register(@Valid @RequestBody RegisterReq registerReq, BindingResult bindingResult) throws BusinessException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, CommonUtils.processErrorString(bindingResult));
        }
        UserModel userModel = UserModelConvertUtils.register2UserModel(registerReq);
        UserModel resUserModel = userService.register(userModel);
        return Result.create(resUserModel);
    }




}
