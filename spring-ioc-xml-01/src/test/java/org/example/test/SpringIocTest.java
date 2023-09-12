package org.example.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    /**
     * 如何创建Ioc容器 并读取配置文件
     */
    public void createIoc() {
        // 方式一
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 方式二
        // 通过setConfigLocation方法设置配置文件路径
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocation("spring-03.xml");  // 设置配置文件路径
        applicationContext1.refresh();  // 刷新容器
    }

    /**
     * 讲解如何在Ioc容器中获取组件Bean
     */
    public void getBeanFromIoc() {

    }
}
