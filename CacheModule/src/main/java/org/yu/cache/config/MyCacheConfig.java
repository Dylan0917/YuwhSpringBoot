package org.yu.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyCacheConfig.java
 * @Description TODO
 * @createTime 2021年01月31日 16:50:00
 */
@Configuration
public class MyCacheConfig {

    /**
     * 自定义keygenerator
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + Arrays.asList(objects).toString();
            }
        };
    }
}
