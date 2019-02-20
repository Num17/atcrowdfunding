package com.jiuhe.atcrowdfunding.dao;

import com.jiuhe.atcrowdfunding.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {


    User queryById(int id);

    int querByUserNameAndPassword(String username, String password);

    List<User> queryPage(Integer offset, Integer limit, String query);

    int queryCount();

    int deleteUser(Collection<String> accounts);

}