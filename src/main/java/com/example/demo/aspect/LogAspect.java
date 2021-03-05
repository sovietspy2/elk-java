package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
@Aspect
public class LogAspect {

    private final Logger logger = LogManager.getLogger(LogAspect.class);

    @Around("@annotation(LogDuration)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        MDC.put("duration", String.valueOf(executionTime));
        MDC.put("method",joinPoint.getSignature().toShortString());
        logger.info("duration recorder");
        return proceed;
    }

}
