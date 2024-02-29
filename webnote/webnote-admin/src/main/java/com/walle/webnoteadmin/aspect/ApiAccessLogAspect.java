package com.walle.webnoteadmin.aspect;

import com.walle.webnoteadmin.entity.ApiAccessLog;
import com.walle.webnoteadmin.mapper.ApiAccessLogMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ApiAccessLogAspect {

    @Autowired
    private ApiAccessLogMapper apiAccessLogMapper;

    @Pointcut("execution(* com.walle.webnoteadmin.controller.*.*(..))")
    public void controllerMethod() {}

    @Before("controllerMethod()")
    public void beforeControllerMethod(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        ApiAccessLog log = new ApiAccessLog();
        log.setMethod(request.getMethod());
        log.setPath(request.getRequestURI());
        log.setParams(request.getQueryString());
        log.setIp(request.getRemoteAddr());

        apiAccessLogMapper.insertApiAccessLog(log);
    }
}