package rg.yu.restfulcrud.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyListener.java
 * @Description TODO
 * @createTime 2021年01月19日 21:38:00
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("----容器初始化----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("----容器销毁----");
    }
}
