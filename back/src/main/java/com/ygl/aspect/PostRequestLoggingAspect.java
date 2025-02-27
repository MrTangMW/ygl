package com.ygl.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygl.entity.ReqLogPo;
import com.ygl.service.write.ReqLogWriteService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: PostRequestLoggingAspect
 * @Description: 切面处理类
 * @Author:tangmw
 * @Date 2024-07-19
 * @Version 1.0
 */
@Aspect
@Component
@Order(1) // 可以指定切面的执行顺序
public class PostRequestLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(PostRequestLoggingAspect.class);
    private final   RequestMappingHandlerMapping requestMappingHandlerMapping;

    public  PostRequestLoggingAspect(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @Resource
    private ReqLogWriteService reqLogWriteService;

    @Around("execution(* com.ygl.rest.*.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public Object logPostRequests(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        long reqTime=System.currentTimeMillis();
        // 获取原始请求对象
        HttpServletRequest rawRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // 安全转换为包装器（关键修改）
        ContentCachingRequestWrapper request;
        if (rawRequest instanceof ContentCachingRequestWrapper) {
            request = (ContentCachingRequestWrapper) rawRequest;
        } else {
            // 若过滤器未生效，在此处兜底包装
            request = new ContentCachingRequestWrapper(rawRequest);
            request.getParameterMap(); // 触发缓存填充
        }

        // 读取请求体
        String requestBody = new String(request.getContentAsByteArray(), request.getCharacterEncoding());

        // 获取方法信息（保持原逻辑）
        HandlerMethod handlerMethod = (HandlerMethod) requestMappingHandlerMapping.getHandler(request).getHandler();
        String methodName = handlerMethod.getMethod().getName();

        logger.info("处理请求中,请求路径: {} 方法名: {}. 请求参数: {}",
                request.getRequestURL(), methodName, requestBody);

        try {
            Object result = joinPoint.proceed();
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);

            ReqLogPo reqLogPo = new ReqLogPo();
            reqLogPo.setReqTime(String.valueOf(elapsedTime));
            reqLogPo.setInput(requestBody); // 直接使用已读取的请求体
            reqLogPo.setOutput(String.valueOf(result));
            System.out.println("出参："+String.valueOf(result));
            reqLogPo.setReqStas("success");
            reqLogPo.setCreateTime(new Date(reqTime));
            reqLogPo.setReqLogId((int) startTime);
            reqLogWriteService.insert(reqLogPo);
            return result;
        } catch (Throwable e) {
            logger.error("请求出错: {}", e.getMessage());
            // 计算请求处理时间
            long elapsedTime = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);
            // 记录请求结束时间戳和出参
            ReqLogPo reqLogPo=new ReqLogPo();
            reqLogPo.setReqTime(String.valueOf(elapsedTime));
            reqLogPo.setInput(requestBody);
            reqLogPo.setOutput(String.valueOf(e.getMessage()));
            reqLogPo.setReqStas("false");
            reqLogPo.setCreateTime(new Date(reqTime));
            reqLogPo.setReqLogId((int) startTime);
            reqLogWriteService.insert(reqLogPo);
            throw e;
        }
    }

}
