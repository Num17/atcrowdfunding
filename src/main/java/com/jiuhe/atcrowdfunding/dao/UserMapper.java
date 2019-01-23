package com.jiuhe.atcrowdfunding.dao;

import com.jiuhe.atcrowdfunding.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    User queryById(int id);

}