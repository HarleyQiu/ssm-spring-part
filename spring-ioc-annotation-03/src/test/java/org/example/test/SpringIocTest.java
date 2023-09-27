package org.example.test;

import org.example.ioc_01.XxxDao;
import org.example.ioc_02.JavaBean;
import org.example.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {

    @Test
    public void testIoc_01() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean);
        // 默认名为类的首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService = " + xxxService);
    }

    @Test
    public void testIoc_02() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        JavaBean bean2 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean1 == bean2);

        applicationContext.close();
    }


    @Test
    public void testIoc_03() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");
        UserController bean = applicationContext.getBean(UserController.class);

        bean.show();

        applicationContext.close();
    }


    @Test
    public void testIoc_04() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");
        org.example.ioc_04.JavaBean bean = applicationContext.getBean(org.example.ioc_04.JavaBean.class);

        System.out.println("bean = " + bean);

        applicationContext.close();
    }


}
