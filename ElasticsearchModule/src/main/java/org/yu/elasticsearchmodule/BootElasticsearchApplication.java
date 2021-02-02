package org.yu.elasticsearchmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yu.wenhua
 * @desc 支持两种交互方式
 * jest 默认不生效 需要导入包
 * 和 SpringData Elasticsearch
 *
 *
 * @date 2021/2/2 17:39
 */
@SpringBootApplication
public class BootElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootElasticsearchApplication.class,args);
    }
}
