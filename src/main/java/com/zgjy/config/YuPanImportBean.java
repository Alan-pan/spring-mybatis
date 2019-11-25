package com.zgjy.config;

import com.zgjy.mapper.EmpMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class YuPanImportBean implements ImportBeanDefinitionRegistrar {
    /*for循环扫描对应包下所有的mapper并注册*/

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinitionBuilder builder=BeanDefinitionBuilder.genericBeanDefinition(ClassFactoryBean.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        //在ClassFactoryBean中添加对应的接口
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.zgjy.mapper.EmpMapper");
        //注册对应的别名
        beanDefinitionRegistry.registerBeanDefinition("empMapper",beanDefinition);
    }
}
