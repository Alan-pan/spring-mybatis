package com.zgjy.proxy;

import com.zgjy.entity.Emp;
import com.zgjy.mapper.EmpMapper;

import java.lang.reflect.Proxy;
import java.util.List;

public class MapperSession {
    public static Object getInstance(Class clazz){
        //对应的接口
        Class[] cs=new Class[]{clazz};
                                        //此类的类加载器                    对应代理接口      实现代理
        return Proxy.newProxyInstance(MapperSession.class.getClassLoader(),cs,new MapperProxy());
    }

    public static void main(String[] args) {
        EmpMapper proxy = (EmpMapper) MapperSession.getInstance(EmpMapper.class);
        proxy.selectList();
    }
    public List<Emp> selectList(){
        System.out.println(123);
        return  null;
    };
}
