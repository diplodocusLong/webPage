package com.bohui.wf.gps.website.webpage.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author lianglong
 * @date 2019/10/21
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class CrosFilter implements Filter {

    @Autowired
    private Environment env;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
        final HttpServletRequest request = (HttpServletRequest) req;
        response.setHeader("Access-Control-Allow-Credentials", "true");
        if (env.getProperty("spring.profiles.active") != null
                && env.getProperty("spring.profiles.active").equals("prod")) {
            // System.err.println("正式地址...");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost:9001");
        } else {
            // 动态获取前端接口
            // System.err.println("测试地址...");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        }
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers",
                "Authorization, Content-Type, X_Requested_With");
        response.setHeader("Access-Control-Max-Age", "3600");
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }


}