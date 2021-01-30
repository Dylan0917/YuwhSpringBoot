package org.yu.monitor.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/30 10:47
 */
//META-INF/spring.factories中配置
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer...initialize..." + configurableApplicationContext);
    }
}
