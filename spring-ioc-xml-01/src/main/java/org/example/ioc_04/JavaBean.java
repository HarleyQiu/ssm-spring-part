package org.example.ioc_04;

public class JavaBean {


    /**
     * 初始化方法
     * 必须是public的无参构造函数
     */
    public void init() {
        System.out.println("JavaBean.init");
    }

    /**
     * 销毁方法
     */
    public void destroy() {
        System.out.println("JavaBean.destroy");
    }
}
