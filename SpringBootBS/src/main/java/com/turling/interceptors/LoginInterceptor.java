package com.turling.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    //Alt+insert

    //如果登录了便放行   true   false:拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute("user")!=null){
                //已经登录了
            return true;
        }else {
            response.sendRedirect("/");
            return false;
        }
    }
}
