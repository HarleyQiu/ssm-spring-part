package org.example.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxAdvice {

    @Before("org.example.pointcut.MyPointcut.myPc()")
    public void begin() {
        System.out.println("开启事务");
    }

    @AfterReturning("org.example.pointcut.MyPointcut.myPc()")
    public void commit() {
        System.out.println("事务提交");
    }

    @AfterThrowing("org.example.pointcut.MyPointcut.myPc()")
    public void rollback() {
        System.out.println("事务回滚");
    }
}
