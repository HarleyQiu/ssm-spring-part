package org.example.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component // id = javaBean class = JavaBean
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)  // 单例默认值
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // 多例
public class JavaBean {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy  // 多例不管理销毁方法
    public void destroy() {
        System.out.println("destroy");
    }


}
