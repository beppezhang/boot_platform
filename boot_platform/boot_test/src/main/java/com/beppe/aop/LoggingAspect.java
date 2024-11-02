package com.beppe.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(com.beppe.annotation.LogExecutionTime)") // 切点  匹配 LogExecutionTime注解
    public Object logExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis(); // 记录开始时间
        System.out.println("Executing method before advice");
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start; // 计算执行时间
        System.out.println("Method " + joinPoint.getSignature().getName() + " executed in " + executionTime + "ms");
        return proceed;
    }
}
