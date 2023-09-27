package org.example.test;

import org.example.config.JavaConfiguration;
import org.example.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController bean = applicationContext.getBean(StudentController.class);
        applicationContext.close();
    }
}
