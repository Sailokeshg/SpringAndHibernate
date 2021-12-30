package com.zemoso.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.zemoso.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.zemoso.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.zemoso.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        //display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("===>> in @Before :  calling method: "+theMethod);

        //get arguments and display them
        Object[] args = theJoinPoint.getArgs();

        for(Object tempArg:args){
            myLogger.info("===> argument: "+ tempArg);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult"
    )
    public void afterReturning(JoinPoint theJoinPoint,Object theResult){

        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("===>> in @AfterReturning :  calling method: "+theMethod);

        myLogger.info("===> result: "+theResult);

    }




}
