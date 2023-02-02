package com.Customer.Aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.constant.Constable;
import java.util.Locale;
import java.util.Map;

/**
 * PROJECT_NAME AspectJWare
 *
 * @author Alliance github_https://github.com/AllianceTing
 * DATE 2023/1/17~20:02
 */
@Component
@Aspect
public class AspectJWareLog {
    Logger log = LoggerFactory.getLogger("Log");

    @Pointcut("@annotation(com.Customer.Aop.Log)")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object doLogPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        // do start compute Time
        stopWatch.start();
        // do get method Name
        var methodName = proceedingJoinPoint.getSignature().getName();
        ServletRequestAttributes ra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert ra != null;
        HttpServletRequest request = ra.getRequest();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Constable remoteUser = request.getRemoteUser();
        var requestMethod = request.getMethod().toUpperCase(Locale.ROOT);
        Constable ToCqueryParms = request.getQueryString().trim();
        int serverPort = request.getServerPort();
        Map<String, String[]> requestParameterMap = request.getParameterMap();
        Constable contextPath = request.getContextPath();
        var requestProtocol = request.getProtocol();
        String[] ToBparameterNames = signature.getParameterNames();
        stopWatch.stop();
        long watchTotalTimeNanos = stopWatch.getTotalTimeNanos();
        log.debug(remoteUser + ":" + serverPort + contextPath + ToBparameterNames + requestMethod + ToCqueryParms + "::" + watchTotalTimeNanos);
        return proceedingJoinPoint.proceed();
    }
}


