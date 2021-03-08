package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
@Aspect
public class LogAspect {

    private final Logger logger = LogManager.getLogger(LogAspect.class);

    @Around("services()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object proceed;
        long executionTime=0;
        try {
             proceed = joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        } finally {
            executionTime = System.currentTimeMillis() - start;
            MDC.put("duration", String.valueOf(executionTime));
            MDC.put("method",joinPoint.getSignature().toShortString());
            logger.info("duration recorder "+joinPoint.getSignature().toShortString());
        }
        return proceed;
    }

    @Pointcut("execution(* com.example.demo..*.*(..))")
    public void services() {

    }

}
