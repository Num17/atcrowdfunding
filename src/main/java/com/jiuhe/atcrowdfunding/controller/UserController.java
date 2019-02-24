package com.jiuhe.atcrowdfunding.controller;

import com.jiuhe.atcrowdfunding.bean.BaseResponse;
import com.jiuhe.atcrowdfunding.bean.Page;
import com.jiuhe.atcrowdfunding.domain.User;
import com.jiuhe.atcrowdfunding.service.UserService;
import com.jiuhe.atcrowdfunding.util.CollectionUtil;
import com.jiuhe.atcrowdfunding.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
//TODO 异常,日志

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseResponse updateUser(
            @RequestParam("account") String account,
            @RequestParam("name") String name,
            @RequestParam("email") String email) {

        userService.updateUser(account, name, email);

        return BaseResponse.SUCCESS_RESPONSE;

    }

    @RequestMapping(value = "get", method = RequestMethod.POST)
    public BaseResponse getUser(@RequestParam("account") String account) {

        User user = userService.getUserByAccount(account);
        return BaseResponse.SUCCESS_RESPONSE.put("user", user);
    }

    @RequestMapping("/check-account")
    public BaseResponse checkAccount(@RequestParam("account") String account) {

        boolean flag = userService.checkAccount(account);
        if (!flag) {
            return BaseResponse.ERROR_RESPONSE;
        }

        return BaseResponse.SUCCESS_RESPONSE;
    }

    @RequestMapping("/add")
    public BaseResponse addUser(
            @RequestParam("account") String account,
            @RequestParam("name") String name,
            @RequestParam("email") String email) {

        if (StringUtil.isEmpty(account)) {
            return BaseResponse.newErrorResponse("请输入账号!");
        }

        if (!userService.checkAccount(account)) {
            logger.warn("账号重复无法新增该用户,账号:[{}]", account);
            return BaseResponse.newErrorResponse("账号重复无法新增该用户!");
        }

        if (StringUtil.isEmpty(name)) {
            return BaseResponse.newErrorResponse("请输入姓名!");
        }

        userService.addUser(account, name, email);
        return BaseResponse.SUCCESS_RESPONSE;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public BaseResponse deleteUser(@RequestParam("accounts") List<String> accounts) {

        if (CollectionUtil.isEmpty(accounts)) {
            return BaseResponse.ERROR_RESPONSE;
        }

        userService.removeUser(accounts);

        return BaseResponse.SUCCESS_RESPONSE;
    }

    @RequestMapping("/query-page")
    public Page<User> queryPage(
            @RequestParam("offset") Integer offset,
            @RequestParam("limit") Integer limit,
            @RequestParam("query") String query) {

        if (offset == null || offset < 0) {
            offset = 0;
        }

        if (limit == null || limit <= 0) {
            limit = 10;
        }

        return userService.getPage(offset, limit, query);
    }

    @RequestMapping("/logout")
    public BaseResponse logout(HttpSession session) {
        logger.info("用户[{}]退出成功!", session.getAttribute("username"));
        session.invalidate();
        return BaseResponse.SUCCESS_RESPONSE;
    }

    @RequestMapping("/login")
    public BaseResponse login(String username, String password, HttpSession session) {

        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return BaseResponse.newErrorResponse("登录失败，请输入用户名或者密码!");
        }

        int count = userService.login(username, password);
        if (count == 0) {
            return BaseResponse.ERROR_RESPONSE;
        }

        session.setAttribute("username", username);

        logger.info("账号[{}]登录成功!", username);
        return BaseResponse.SUCCESS_RESPONSE;

    }

    @RequestMapping("/info")
    public BaseResponse getUserInfo(HttpSession session) {

        return BaseResponse.SUCCESS_RESPONSE.put("username", session.getAttribute("username"));
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
