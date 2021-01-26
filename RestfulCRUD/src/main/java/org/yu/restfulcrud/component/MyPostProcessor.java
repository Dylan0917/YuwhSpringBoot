package org.yu.restfulcrud.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yu.wenhua
 * @desc 自定义前置后置处理器
 * @date 2021/1/26 10:36
 */
@Component
public class MyPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization - " + bean.getClass().getName() + " - " + beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization  - " + bean.getClass().getName() + " - " + beanName);
        return null;
    }
}
