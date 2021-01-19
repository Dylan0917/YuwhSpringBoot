package org.yu.restfulcrud.org.yu.restfulcrud.interf.Impl;

import org.springframework.stereotype.Component;
import org.yu.restfulcrud.org.yu.restfulcrud.interf.AutoWireInterface;

/**
 * @author yu.wenhua
 * @desc
 * @date 2021/1/19 14:07
 */
public class AutoWireInterfaceImpl02 implements AutoWireInterface {
    @Override
    public void method01() {
        System.out.println("------------------AutoWireInterfaceImpl02------------------");
    }
}
