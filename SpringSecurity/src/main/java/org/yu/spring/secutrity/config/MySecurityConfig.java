package org.yu.spring.secutrity.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/2/5 16:49
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制授权规则
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/level1/**");




    }
}
