package org.example.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {

    /**
     * 环绕通知需要定义目标方法的执行
     *
     * @param proceedingJoinPoint 目标方法信息
     * @return 目标方法返回值
     */
    @Around("org.example.advice.LogAdvice.pc()")
    public Object transaction(ProceedingJoinPoint proceedingJoinPoint) {
        // 保证目标方法执行
        Object[] args = proceedingJoinPoint.getArgs();
        Object proceed = null;
        try {
            System.out.println("开启事务");
            proceed = proceedingJoinPoint.proceed(args);
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        } finally {

        }
        return proceed;
    }
}
