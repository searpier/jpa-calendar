package com.spring.jpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Aspect
public class LogAdvice {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Around(" execution(* com.spring.jpa.controller..*Controller.*(..))" +
            "|| execution(* com.spring.jpa.service..*Service*.*(..))" +
            "|| execution(* com.spring.jpa.repository..*Repository.*(..))")
    public Object logAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className=proceedingJoinPoint.getSignature().getDeclaringTypeName(); //클래스명
        String methodName=proceedingJoinPoint.getSignature().getName(); //메서드명
        String parameters= Arrays.toString(proceedingJoinPoint.getArgs()); //파라미터

        logger.info("=========================[[START]]==============================");
        logger.info(""+className+"."+methodName+"() CALLED");
        logger.info("PARAMETERS : "+parameters);
        logger.info("==========================[[END]]===============================");

        return proceedingJoinPoint.proceed();
    }




}




