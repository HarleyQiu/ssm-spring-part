package org.example;

import org.example.dynamic.ProxyFactory;
import org.example.statics.StaticProxyCalculator;

public class UseAop {
    public static void main(String[] args) {
        CalculatorPureImpl calculatorPure = new CalculatorPureImpl();
        StaticProxyCalculator staticProxyCalculator = new StaticProxyCalculator(calculatorPure);

        int add = staticProxyCalculator.add(1, 1);
        System.out.println("add = " + add);

        // jdk代理
        ProxyFactory proxyFactory = new ProxyFactory(calculatorPure);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 1);
    }
}
