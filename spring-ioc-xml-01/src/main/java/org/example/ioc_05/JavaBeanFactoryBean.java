package org.example.ioc_05;

import org.springframework.beans.factory.FactoryBean;

public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public JavaBean getObject() throws Exception {
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
