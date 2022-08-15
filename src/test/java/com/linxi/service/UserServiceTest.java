package com.linxi.service;

import com.linxi.pojo.User;
import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {

    private UserService userService = UserService.getInstance();

    @Before
    public void init(){
        addUser();
    }

    @Test
    public void addUser() {
        userService.addUser(new User(1, "admin", "123456", "admin", "", ""));
        userService.addUser(new User(2, "user1", "123456", "test", "", ""));
        userService.addUser(new User(3, "user2", "123456", "test", "", ""));
    }

    @Test
    public void listUser() {
        userService.listUsers();
    }


    @Test
    public void updateUser() {
        userService.listUsers();
        userService.updateUser(new User(2, "test", "s", "324", "", ""));
        userService.listUsers();
    }

    @Test
    public void deleteUser() {
        listUser();
        userService.deleteUser(2);
        listUser();
    }
}