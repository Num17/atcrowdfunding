package com.jiuhe.atcrowdfunding.service.impl;

import com.jiuhe.atcrowdfunding.dao.UserMapper;
import com.jiuhe.atcrowdfunding.domain.User;
import com.jiuhe.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public int login(String username, String password) {
        return userMapper.querByUserNameAndPassword(username, password);
    }

//    @Override
//    public String getUserInfo(String username) {
//        return userMapper;
//    }


    @Override
    public List<User> getPage(Integer pageNumber, Integer pageSize) {
        Integer start = (pageNumber - 1) * pageSize;
        return userMapper.queryPage(start, pageSize);
    }

    @Override
    public int getCount(int pageSize) {
        return userMapper.queryCount();
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
