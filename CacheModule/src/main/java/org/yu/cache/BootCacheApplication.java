package org.yu.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/30 16:57
 */
@SpringBootApplication
//@MapperScan("org.yu.cache.mapper")
@EnableCaching //开启缓存
public class BootCacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootCacheApplication.class, args);
    }
}
