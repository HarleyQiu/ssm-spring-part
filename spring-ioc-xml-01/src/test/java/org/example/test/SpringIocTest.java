package org.example.test;

import org.example.ioc_03.HappyComponent;
import org.example.ioc_04.JavaBean2;
import org.junit.jupiter.api.Test;
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
    @Test
    public void getBeanFromIoc() {
        // 方式一
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        // 1. 通过getBean方法获取组件Bean 根据Bean 返回值为Object 不推荐
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");

        // 2. 通过getBean方法获取组件Bean 根据Bean和类型
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent", HappyComponent.class);

        // 3. 通过getBean方法获取组件Bean 根据类型 但是要求容器中只能有一个该类型的Bean
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent.doWork();
        happyComponent1.doWork();
        happyComponent2.doWork();
        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent1 == happyComponent2);
    }

    @Test
    public void test_04() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");

        JavaBean2 bean = context.getBean("javaBean2", JavaBean2.class);
        JavaBean2 bean2 = context.getBean("javaBean2", JavaBean2.class);
        System.out.println(bean == bean2);  // true 说明是单例的

        JavaBean2 bean3 = context.getBean("javaBean3", JavaBean2.class);
        JavaBean2 bean4 = context.getBean("javaBean3", JavaBean2.class);
        System.out.println(bean3 == bean4);  // false 说明是多例的

        context.close();  // 关闭容器 调用JavaBean的destroy方法
    }
}
