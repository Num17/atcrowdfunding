package com.jiuhe.atcrowdfunding.controller;

import com.jiuhe.atcrowdfunding.domain.User;
import com.jiuhe.atcrowdfunding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private UserService userService;

    @RequestMapping("/index")
    public User test() {
        return userService.getUserById(1);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
