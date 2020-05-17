package com.bingo.dianping.common.interceptor;

import com.bingo.dianping.common.CommonError;
import com.bingo.dianping.common.ErrorCodeEnum;
import com.bingo.dianping.common.Result;
import com.bingo.dianping.controller.admin.AdminController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: jiangjiabin
 * @Date: Create in 2:34 2020/5/17
 * @Description:
 */
@Aspect
@Configuration
public class ControllerAspect {

    @Resource
    private HttpServletRequest httpServletRequest;
    @Resource
    private HttpServletResponse httpServletResponse;


    @Around("execution(* com.bingo.dianping.controller.admin.*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object adminControllerBeforeValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        AdminPermission adminPermission = method.getAnnotation(AdminPermission.class);
        if (adminPermission == null) {
            //公共方法
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
        //判断当前管理员是否登录
        String email= (String) httpServletRequest.getSession().getAttribute(AdminController.CURRENT_USER_SESSION);
        if (email == null) {
            if (adminPermission.produceType().equals("text/html")) {
                httpServletResponse.sendRedirect("/admin/admin/loginPage");
                return null;
            } else {
                CommonError commonError = new CommonError(ErrorCodeEnum.ADMIN_SHOULD_LOGIN);
                return Result.create(commonError, "fail");
            }
        } else {
            Object resultObject = joinPoint.proceed();
            return resultObject;
        }
    }


}
