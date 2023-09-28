package org.example.advice;

import org.aspectj.lang.annotation.*;
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

    /**
     * TODO:切面表达式的提取和复用
     *  1. 当前类中提取
     *      定义一个空方法
     *      注解配置 @Pointcut
     *      增强注解中引用切点表达式的方法即可 直接diao'yong
     *  2. 创建一个存储切点的类 单独维护切点表达式
     *      其他类的切点方法 类的全限定符号.方法名()
     */
    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    public void pc() {

    }

    @Before("pc()")
    public void start() {
        System.out.println("方法开始了");
    }

    @After("pc()")
    public void after() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("pc()")
    public void error() {
        System.out.println("方法报错了");
    }
}
