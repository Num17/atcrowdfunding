package com.jiuhe.atcrowdfunding.service.impl;

import com.jiuhe.atcrowdfunding.bean.Page;
import com.jiuhe.atcrowdfunding.dao.UserMapper;
import com.jiuhe.atcrowdfunding.domain.User;
import com.jiuhe.atcrowdfunding.service.UserService;
import com.jiuhe.atcrowdfunding.util.CollectionUtil;
import com.jiuhe.atcrowdfunding.util.DateUtil;
import com.jiuhe.atcrowdfunding.util.DoubleUtil;
import com.jiuhe.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String INIT_PASSWORD = "171339";

    private UserMapper userMapper;

    @Override
    public int updateUser(String account, String name, String email) {
        return userMapper.updateUser(account, name, email);
    }

    @Override
    public User getUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }

    @Override
    public int addUser(String account, String name, String email) {

        User user = new User();
        user.setAccount(account);
        user.setEmail(email);
        user.setPassword(INIT_PASSWORD);
        user.setCreateTime(DateUtil.NOW);
        user.setIsDeleted(Boolean.FALSE);
        user.setUsername(name);

        return userMapper.insertUser(user);
    }

    /**
     * 校验账号如果存在则返回false
     */
    @Override
    public boolean checkAccount(String account) {

        if (StringUtil.isEmpty(account)) {
            return Boolean.TRUE;
        }

        User user = userMapper.queryCountByAccount(account);

        if (user != null) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    public int removeUser(Collection<String> accounts) {
        if (CollectionUtil.isEmpty(accounts)) {
            return DoubleUtil._ZEOR;
        }

        return userMapper.deleteUser(accounts);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public int login(String username, String password) {
        return userMapper.querByUserNameAndPassword(username, password);
    }

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
