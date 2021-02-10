package org.yu.springcloud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Boot01Application.java
 * @Description TODO
 * @createTime 2021年02月10日 16:31:00
 */
@EnableEurekaServer //启用注册中心
@SpringBootApplication
public class Boot01Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot01Application.class,args);
    }
}
