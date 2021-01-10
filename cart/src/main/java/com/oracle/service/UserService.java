package com.oracle.service;


import com.oracle.pojo.Users;

public interface UserService {
    Users findUser(String loginname, String pwd);

    void addUser(Users users);

    void updateUserStatus(String loginname);
}
