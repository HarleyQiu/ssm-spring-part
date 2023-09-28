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
 *     </h>
 * 实战:
 * 1.查询某包某类下，访问修饰符是公有，返回值是int的全部方法 - execution(public int org..impl.*.*(..))
 * 2.查询某包下类中第一个参数是String的方法 - execution(* org..impl.*.*(String..))
 * 3.查询全部包下，无参数的方法！- execution(* *..*.*())
 * 4.查询com包下，以int参数类型结尾的方法 - execution(* com..*.*(..int))
 * 5.查询指定包下，Service开头类的私有返回值int的无参数方法 execution(private int org..Service*.*())
 */
@Component
@Aspect
public class MyAdvice {

    @Before("org.example.pointcut.MyPointcut.myPc()")
    public void before(JoinPoint joinPoint) {
        // 获取类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();

        // 获取方法名
        String name = joinPoint.getSignature().getName();

        // 获取方法参数
        Object[] args = joinPoint.getArgs();

    }

    @AfterReturning(value = "org.example.pointcut.MyPointcut.myPc()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @AfterThrowing(value = "org.example.pointcut.MyPointcut.myPc()", throwing = "throwing")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwing) {

    }

    @After("org.example.pointcut.MyPointcut.myPc()")
    public void after() {

    }


}
