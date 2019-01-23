package com.jiuhe.atcrowdfunding.service.impl;

import com.jiuhe.atcrowdfunding.dao.UserMapper;
import com.jiuhe.atcrowdfunding.domain.User;
import com.jiuhe.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.queryById(id);
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
