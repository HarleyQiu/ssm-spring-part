package org.example.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxAdvice {

    @Before("org.example.pointcut.MyPointcut.myPc()")
    public void begin() {
        System.out.println("开启事务1");
    }

    @AfterReturning("org.example.pointcut.MyPointcut.myPc()")
    public void commit() {
        System.out.println("提交事务1");
    }

    @AfterThrowing("org.example.pointcut.MyPointcut.myPc()")
    public void rollback() {
        System.out.println("事务回滚1");
    }
}
