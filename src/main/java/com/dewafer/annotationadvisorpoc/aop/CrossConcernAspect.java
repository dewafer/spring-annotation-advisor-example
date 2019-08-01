package com.dewafer.annotationadvisorpoc.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Aspect
public class CrossConcernAspect {

    @Pointcut("@annotation(com.dewafer.annotationadvisorpoc.annotation.CrossConcern)")
    public void crossConcernAnnotation() {

    }

    @Before("crossConcernAnnotation()")
    public void before() {
        log.info("Before aspect.");
    }

    @After("crossConcernAnnotation()")
    public void after() {
        log.info("After aspect.");
    }

    @AfterReturning(pointcut = "crossConcernAnnotation()", returning = "retVal")
    public void afterReturning(Object retVal) {
        log.info("After Returning aspect, retVal={}", retVal);
    }

    @AfterThrowing(pointcut = "crossConcernAnnotation()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        log.info("After throwing, exception={}", ex.toString(), ex);
    }

    @Around("crossConcernAnnotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            log.info("around before proceed");
            Object result = proceedingJoinPoint.proceed();
            log.info("around after proceed, result={}", result);
            return result;
        } catch (Throwable t) {
            log.info("around thrown t={}", t.toString(), t);
            throw t;
        } finally {
            log.info("around finally");
        }
    }

}
