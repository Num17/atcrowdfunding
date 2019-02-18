package com.jiuhe.atcrowdfunding.service;

import com.jiuhe.atcrowdfunding.bean.Page;
import com.jiuhe.atcrowdfunding.domain.User;

import java.util.List;

public interface UserService {

    User getUserById(int id);

    int login(String username, String password);

    Page<User> getPage(Integer offset, Integer limit, String query);

    int getCount(int pageSize);

    int removeUser(String account);

//    String getUserInfo(String username);
}
