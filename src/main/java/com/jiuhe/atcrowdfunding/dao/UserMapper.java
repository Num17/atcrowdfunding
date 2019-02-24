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

    int deleteUser(@Param("accounts") Collection<String> accounts);

    User queryCountByAccount(String account);

    int insertUser(User user);

    User queryUserByAccount(String account);

    int updateUser(String account, String name, String email);
}