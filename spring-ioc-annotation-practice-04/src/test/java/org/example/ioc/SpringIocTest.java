package org.example.ioc;

import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
        applicationContext.close();
    }
}
