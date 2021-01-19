package org.yu.restfulcrud.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName MyFilter.java
 * @Description TODO
 * @createTime 2021年01月19日 21:27:00
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter.........");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
