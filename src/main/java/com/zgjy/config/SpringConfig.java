package com.zgjy.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zgjy.mapper.EmpMapper;
import com.zgjy.proxy.MapperSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.zgjy")
//@MapperScan("com.zgjy.mapper")//mapper扫描

//@Import(YuPanImportBean.class)

//使用了@interface注解可以直接使用YuPanScan
@YuPanScan
public class SpringConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        String url = "jdbc:mysql:///jdbc";
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl(url);
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean;
    }

    //方法一 使用Bean将接口代理注入spring容器中
//    @Bean
//    public EmpMapper getEmpMapper(){
//        return (EmpMapper) MapperSession.getInstance(EmpMapper.class);
//    }

}
