package com.zgjy.service.impl;

import com.zgjy.entity.Emp;
import com.zgjy.mapper.EmpMapper;
import com.zgjy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    public List<Emp> selectList(){
       return empMapper.selectList();
    }
}
