package com.zhiyixingnan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiyixingnan.domain.Administrator;
import com.zhiyixingnan.domain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdministratorDao extends BaseMapper<Administrator> {}
