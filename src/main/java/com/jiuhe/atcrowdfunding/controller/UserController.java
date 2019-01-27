package com.jiuhe.atcrowdfunding.controller;

import com.jiuhe.atcrowdfunding.bean.BaseResponse;
import com.jiuhe.atcrowdfunding.service.UserService;
import com.jiuhe.atcrowdfunding.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @RequestMapping("/logout")
    public BaseResponse logout(HttpSession session) {
        logger.info("用户[{}]退出成功!", session.getAttribute("username"));
        session.invalidate();
        return BaseResponse.newSuccessResponse();
    }

    @RequestMapping("/login")
    public BaseResponse login(String username, String password, HttpSession session) {

        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return BaseResponse.newErrorResponse("登录失败，请输入用户名或者密码!");
        }

        int count = userService.login(username, password);
        if (count == 0) {
            return BaseResponse.newErrorResponse();
        }

        session.setAttribute("username", username);

        logger.info("账号[{}]登录成功!", username);
        return BaseResponse.newSuccessResponse();

    }

    @RequestMapping("/info")
    public BaseResponse getUserInfo(HttpSession session) {

        return BaseResponse.newSuccessResponse().put("username", session.getAttribute("username"));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
