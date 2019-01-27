package com.jiuhe.atcrowdfunding.service;

import com.jiuhe.atcrowdfunding.domain.User;

public interface UserService {

    User getUserById(int id);

    int login(String username, String password);

//    String getUserInfo(String username);
}
