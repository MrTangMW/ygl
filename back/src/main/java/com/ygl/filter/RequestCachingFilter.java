package com.ygl.filter;

import org.springframework.web.util.ContentCachingRequestWrapper;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class RequestCachingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // 创建包装器并替换原始请求
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpRequest);

        // 触发缓存填充（必须执行）
        wrappedRequest.getParameterMap();

        chain.doFilter(wrappedRequest, response);
    }
}
