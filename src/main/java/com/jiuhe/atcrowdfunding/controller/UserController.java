package com.jiuhe.atcrowdfunding.controller;

import com.jiuhe.atcrowdfunding.bean.BaseResponse;
import com.jiuhe.atcrowdfunding.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @RequestMapping("/login")
    public BaseResponse login(String username, String password) {

        if (username.equals("admin") || password.equals("admin")) {
            logger.info("登录成功!");
            return BaseResponse.newErrorResponse();
        }

        return BaseResponse.newSuccessResponse();

    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
