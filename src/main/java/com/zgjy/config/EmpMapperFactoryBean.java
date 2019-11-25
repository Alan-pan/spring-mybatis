package com.zgjy.config;

import com.zgjy.mapper.EmpMapper;
import com.zgjy.proxy.MapperSession;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
//将自己也要注入spring容器管理
//@Component
public class EmpMapperFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return (EmpMapper) MapperSession.getInstance(EmpMapper.class);
    }

    @Override
    public Class<?> getObjectType() {
        return EmpMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
