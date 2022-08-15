package com.linxi.service;

import com.linxi.pojo.User;
import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {

    private UserService userService;
    @Before
    public void init(){
        userService = new UserService();
    }

    @Test
    public void addUser() {
        userService.addUser(new User(2,"test","123456","test","",""));
    }
}