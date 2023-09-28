package org.example.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 前置 @Before
 * 后置 @AfterReturning
 * 异常 @AfterThrowing
 * 最后 @After
 * 环绕 @Around
 * </h>
 * try{
 * 前置
 * code
 * 后置
 * } catch{
 * 异常
 * } finally{
 * 最后
 * }
 */
@Component
@Aspect
public class LogAdvice {

    @Before("execution(* org.example.service.impl.*.*(..))")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("execution(* org.example.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* org.example.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错了");
    }
}
