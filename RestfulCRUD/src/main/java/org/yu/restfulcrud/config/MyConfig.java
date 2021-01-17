package org.yu.restfulcrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yu.restfulcrud.component.LoginHandlerInterceptor;
import org.yu.restfulcrud.component.MyLocaleResolver;
//该类已经弃用
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyConfig.java
 * @Description TODO
 * @createTime 2021年01月14日 22:28:00
 */
@Configuration
//@EnableWebMvc 该注解会放弃Springboot的所有默认配置
public class MyConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //主页跳转
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
//        WebMvcConfigurer.super.addViewControllers(registry);
    }

    //新增自定义对区域解析器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //添加自定义拦截器 用户登陆判断
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login.html","/","/user/login","/error",
                      //  "/**/*.html",            //html静态资源
                        "/**/*.js",              //js静态资源
                        "/**/*.css",             //css静态资源);
                        "/**/*.svg",
                        "/**/*.map",
                        "/**/*.ico","/webjars/**");
//        registry.addWebRequestInterceptor(new LoginHandlerInterceptor2()).addPathPatterns("/**");
    }
}
