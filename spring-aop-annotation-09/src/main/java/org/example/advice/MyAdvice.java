package org.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * TODO: 增强方法中获取目标方法信息
 *  1. 获取目标方法的信息（方法名 参数 访问修饰符 所属类的信息）
 *      JoinPoint包含目标方法 信息
 *  2. 返回的结果 @AfterReturning
 *      Object result 接受返回结果
 *      returning = "result（形参名）"
 *  3. 异常的信息 @AfterThrowing
 *      Throwable throwing 异常信息
 *      throwing = "throwing（形参名）"
 */
@Component
@Aspect
public class MyAdvice {

    @Before("execution(* org..impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // 获取类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();

        // 获取方法名
        String name = joinPoint.getSignature().getName();

        // 获取方法参数
        Object[] args = joinPoint.getArgs();

    }

    @AfterReturning(value = "execution(* org..impl.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @AfterThrowing(value = "execution(* org..impl.*.*(..))", throwing = "throwing")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwing) {

    }

    @After("execution(* org..impl.*.*(..))")
    public void after() {

    }


}
