package org.yu.restfulcrud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
//        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
