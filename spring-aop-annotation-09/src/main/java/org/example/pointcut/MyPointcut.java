package org.example.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcut {
    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    public void pc() {

    }

    @Pointcut("execution(* org..impl.*.*(..))")
    public void myPc() {

    }
}
