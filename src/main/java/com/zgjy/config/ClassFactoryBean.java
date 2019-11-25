package com.zgjy.config;

import com.zgjy.proxy.MapperSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//不能加@Component 通过xml

public class ClassFactoryBean implements FactoryBean {
    Class clazz;//接口

    public ClassFactoryBean(Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object getObject() throws Exception {
        return MapperSession.getInstance(clazz);
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
