package org.example.test;

import org.example.components.A;
import org.example.components.B;
import org.example.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value = JavaConfig.class)
public class SpringIocTest {

    @Autowired
    private A a;

    @Autowired
    private B b;

    @Test
    public void test() {
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
