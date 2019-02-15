package com.jiuhe.atcrowdfunding.service;

import com.jiuhe.atcrowdfunding.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    int login(String username, String password);

    List<User> getPage(Integer pageNumber, Integer pageSize);

    int getCount(int pageSize);

//    String getUserInfo(String username);
}
