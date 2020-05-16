package com.bingo.dianping.controller;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.CommonUtils;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.Result;
import com.bingo.dianping.common.convert.UserModelConvertUtils;
import com.bingo.dianping.model.UserModel;
import com.bingo.dianping.request.LoginReq;
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
import javax.servlet.http.HttpServletRequest;
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

    private static final String CURRENT_USER_SESSION = "currentUserSession";

    @Resource
    private UserService userService;

    @Resource
    private HttpServletRequest httpServletRequest;

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

    @RequestMapping("/login")
    @ResponseBody
    public Result login(@Valid @RequestBody LoginReq loginReq, BindingResult bindingResult) throws BusinessException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, CommonUtils.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginReq.getTelphone(), loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userModel);

        return Result.create(userModel);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public Result logout() throws BusinessException, NoSuchAlgorithmException {
        httpServletRequest.getSession().invalidate();
        return Result.create(null);
    }

    /**
     * 获取当前用户信息
     * @return
     */
    @RequestMapping("/getCurrentUser")
    @ResponseBody
    public Result getCurrentUser() {
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return Result.create(userModel);
    }




}
