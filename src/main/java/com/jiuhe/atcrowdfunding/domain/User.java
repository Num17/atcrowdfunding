package com.jiuhe.atcrowdfunding.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    private Integer id;
    private String account;
    private String username;
    private String password;
    private String email;
    private Boolean isDeleted;
    private Date createTime;

}