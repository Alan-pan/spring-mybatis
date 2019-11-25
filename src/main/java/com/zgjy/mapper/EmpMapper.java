package com.zgjy.mapper;

import com.zgjy.entity.Emp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface EmpMapper {

    @Select("select * from emp")
    public List<Emp> selectList();
}
