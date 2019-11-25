package com.zgjy.proxy;

import com.zgjy.mapper.EmpMapper;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//假设创建mapper接口代理实现类
public class MapperProxy implements InvocationHandler {
    //代理对象
    Class clazz;

    public MapperProxy(Class clazz) {
        this.clazz = clazz;
    }

    public MapperProxy() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        if(!method.getName().equals("toString")){
            Select annotation = method.getAnnotation(Select.class);
            String sql = annotation.value()[0];
            System.out.println("sql--->"+sql);
        }


        return null;
    }

    public Object getInstance(){
       return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public static void main(String[] args) {
        EmpMapper e= (EmpMapper) new MapperProxy(EmpMapper.class).getInstance();
        System.out.println(e.selectList());
    }
}
