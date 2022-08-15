package com.linxi.service;

import com.linxi.dao.UserDao;
import com.linxi.pojo.User;
import com.linxi.service.check.CheckParas;

/**
 * @author: linxi
 * Date: 2022/8/15
 * Time: 14:55
 * Description:
 */
public class LoginService {
    private static LoginService loginService = null;
    private UserDao userDao = UserDao.getInstance();
    private LoginService(){}

    public static LoginService getInstance() {
        if(loginService == null){
            loginService = new LoginService();
        }
        return loginService;
    }

    public void login(String userName, String userPwd){


        /**
         *  1.判空
         *     用户名 密码非空校验
         *  2.根据用户名查找用户记录
         *  3.记录存在判断
         *     不存在-->抛异常
         *  4.用户存在
         *      用户密码比较
         *         不正确-->抛异常
         *  5.密码正确
         *      登录成功
         */
        CheckParas.isBlank(userName, "用户名");
        CheckParas.isBlank(userPwd, "密码");
        User user = userDao.getUserByName(userName);
        if(user == null){
            throw new RuntimeException("用户名不存在!");
        }
        if(!userPwd.equals(user.getUserPwd())){
            throw new RuntimeException("密码错误!");
        }else{
            System.out.println("登录成功");
        }

    }
}
