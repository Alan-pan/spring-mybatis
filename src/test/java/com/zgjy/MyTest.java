package com.zgjy;

import com.zgjy.config.SpringConfig;
import com.zgjy.entity.Emp;
import com.zgjy.mapper.EmpMapper;
import com.zgjy.service.EmpService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class MyTest {
    @Test
    public void t1() throws SQLException {
        AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        //方法一通过@Bean注解注入spring代理对象

        //方法三使用YuPanImportBean 和 ClassFactoryBean 和YuPanScan实现mabatis的动态代理
        EmpMapper mapper = (EmpMapper) ioc.getBean("empMapper");
        mapper.selectList();
        System.out.println(mapper);




    }
    @Test
    public void t2() throws SQLException {
        //方法二通过实现FactoryBean接口实现方法注入spring容器中
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Object empMapper = ioc.getBean("empMapper");
        System.out.println(empMapper);
    }
}
