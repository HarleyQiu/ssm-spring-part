package org.example.text;

import org.example.config.JavaConfig;
import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(JavaConfig.class)
public class SpringAopTest {

    @Autowired
    private Calculator calculator;


    @Test
    public void test() {
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }
}
