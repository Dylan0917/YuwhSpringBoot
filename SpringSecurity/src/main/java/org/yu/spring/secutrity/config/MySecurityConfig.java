package org.yu.spring.secutrity.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

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
        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/level1/**")
                .hasRole("VIP1").antMatchers("/level2/**").hasRole("VIP2")
        .antMatchers("/level3").hasRole("VIP3");

        //开启自动配置的登陆功能
        http.formLogin()
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginPage("/userlogin");
        //开启自动配置的注销功能
//        <form th:action="@{/logout}" method="post">
//		<input type="submit" value="注销">
//	</form>
        http.logout()
                .logoutSuccessUrl("/");//注销成功后返回url
        http.rememberMe(); //开启自动配置的记住我cookie
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new SCryptPasswordEncoder()).withUser("admin").password(new SCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and().passwordEncoder(new SCryptPasswordEncoder()).withUser("user").password(new SCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3")
                .and().passwordEncoder(new SCryptPasswordEncoder()).withUser("wangwu").password(new SCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP3");
    }
}
