package com.ygl.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @ClassName: RequestListener
 * @Description: 请求监听
 * @Author:tangmw
 * @Date 2025-07-02
 * @Version 1.0
 */
@Component
public class RequestListener implements ServletRequestListener {
    /**
     * The request is about to come into scope of the web application.
     * The default implementation is a NO-OP.
     *
     * @param sre Information about the request
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求ip:【"+sre.getServletRequest().getRemoteAddr()+ "】;请求路径: 【"+sre.getServletRequest().toString()+ "】");
    }
}
