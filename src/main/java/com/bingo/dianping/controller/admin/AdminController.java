package com.bingo.dianping.controller.admin;

import com.bingo.dianping.common.BusinessException;
import com.bingo.dianping.common.CommonError;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.Result;
import com.bingo.dianping.common.interceptor.AdminPermission;
import com.bingo.dianping.common.utils.MD5Utils;
import com.bingo.dianping.service.CategoryService;
import com.bingo.dianping.service.SellerService;
import com.bingo.dianping.service.ShopService;
import com.bingo.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: jiangjiabin
 * @Date: Create in 23:24 2020/5/16
 * @Description:
 */
@Controller
@RequestMapping("/admin/admin")
public class AdminController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";

    @Value("${admin.email}")
    private String email;

    @Value("${admin.encryptPassword}")
    private String encryptPassword;

    @Resource
    private HttpServletRequest httpServletRequest;

    @Resource
    private UserService userService;

    @Resource
    private SellerService sellerService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ShopService shopService;


    @RequestMapping("/index")
    @AdminPermission
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/index.html");
        modelAndView.addObject("userCount", userService.getCountUser());
        modelAndView.addObject("categoryCount", categoryService.countAllCategory());
        modelAndView.addObject("shopCount", shopService.countAllShop());
        modelAndView.addObject("sellerCount", sellerService.countAllSeller());
        modelAndView.addObject("CONTROLLER_NAME", "admin");
        modelAndView.addObject("ACTION_NAME", "index");
        return modelAndView;
    }

    @RequestMapping("/loginPage")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("/admin/admin/login.html");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(name = "email") String email,
                              @RequestParam(name = "password") String password) throws BusinessException, NoSuchAlgorithmException {
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, "用户名密码不能为空！");
        }
        if (email.equals(this.email) && MD5Utils.encodeByMD5(password).equals(this.encryptPassword)) {
            //登录成功
            httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, email);
            return "redirect:/admin/admin/index";
        } else {
            throw new BusinessException(ErrorCodeEnum.PARAMETER_VALIDATE_ERROR, "用户名密码错误！");
        }
    }

}
