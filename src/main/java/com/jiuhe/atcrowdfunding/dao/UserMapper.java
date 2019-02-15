package com.jiuhe.atcrowdfunding.dao;

import com.jiuhe.atcrowdfunding.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {


    User queryById(int id);

    int querByUserNameAndPassword(String username, String password);

    List<User> queryPage(Integer start, Integer pageSize);

    int queryCount();

}