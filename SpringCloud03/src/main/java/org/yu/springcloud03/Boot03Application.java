package org.yu.springcloud03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Boot03Application.java
 * @Description TODO
 * @createTime 2021年02月10日 17:14:00
 */
@SpringBootApplication
public class Boot03Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot03Application.class,args);
    }
    @LoadBalanced //使用负载均衡机制
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
