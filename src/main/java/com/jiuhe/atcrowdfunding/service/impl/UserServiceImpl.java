package com.jiuhe.atcrowdfunding.service.impl;

import com.jiuhe.atcrowdfunding.bean.Page;
import com.jiuhe.atcrowdfunding.dao.UserMapper;
import com.jiuhe.atcrowdfunding.domain.User;
import com.jiuhe.atcrowdfunding.service.UserService;
import com.jiuhe.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Override
    public int removeUser(String account) {
        return userMapper.deleteUser(account);
    }

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
    public Page<User> getPage(Integer offset, Integer limit, String query) {
        if (!StringUtil.isEmpty(query)) {
            query = "%" + query + "%";
        }

        List<User> users = userMapper.queryPage(offset, limit, query);

        int count = this.getCount(limit);
        Page<User> page = new Page<>();
        page.setRows(users);
        page.setTotal(count);

        return page;
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
