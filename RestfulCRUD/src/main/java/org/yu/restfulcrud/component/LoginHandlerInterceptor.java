package org.yu.restfulcrud.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginHandlerInterceptor.java
 * @Description 登陆拦截器，判断登陆状态
 * @createTime 2021年01月17日 13:44:00
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("执行LoginHandlerInterceptor。preHandle。。。。。" + request.getRequestURI());
        HttpSession session = request.getSession(false);
        if (session == null){
            //为登陆返回登陆页面
            request.setAttribute("msg","没有权限，请登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        Object user = session.getAttribute("loginUser");
        if (user == null){
            //为登陆返回登陆页面
            request.setAttribute("msg","没有权限，请登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
