package org.yu.restfulcrud.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yu.restfulcrud.filter.MyFilter;
import org.yu.restfulcrud.servlet.MyServlet;
import rg.yu.restfulcrud.listener.MyListener;

import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyServerConfig.java
 * @Description TODO
 * @createTime 2021年01月19日 21:21:00
 */
@Configuration
public class MyServerConfig {

//    注册Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),
                "/myServlet");
        return registrationBean;
    }
//    注册filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return filterRegistrationBean;
    }
//    注册监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean registrationBean = new ServletListenerRegistrationBean();
        registrationBean.setListener(new MyListener());
        return registrationBean;
    }
}
