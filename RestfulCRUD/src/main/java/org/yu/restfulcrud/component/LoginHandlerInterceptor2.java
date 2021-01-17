package org.yu.restfulcrud.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName LoginHandlerInterceptor2.java
 * @Description TODO
 * @createTime 2021年01月17日 15:16:00
 */
public class LoginHandlerInterceptor2 implements WebRequestInterceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        logger.info("执行LoginHandlerInterceptor2。preHandle。。。。。");
        String contextPath = webRequest.getContextPath();
        logger.info("contextPath---"+contextPath);
        Object loginUser = webRequest.getAttribute("loginUser", 0);
        logger.info("loginUser---"+loginUser);
        logger.info("执行LoginHandlerInterceptor2。preHandle。。。。end。");

    }

    @Override
    public void postHandle(WebRequest webRequest, ModelMap modelMap) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest webRequest, Exception e) throws Exception {

    }
}
