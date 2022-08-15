package com.linxi.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService loginService = LoginService.getInstance();
    @Test
    public void login() {
        loginService.login("admin", "123456");
    }
}