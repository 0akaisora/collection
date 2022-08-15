package com.linxi.service;

import com.linxi.dao.UserDao;
import com.linxi.pojo.User;
import com.linxi.service.check.CheckParas;

import java.util.List;

/**
 * @author: linxi
 * Date: 2022/8/15
 * Time: 14:53
 * Description:
 */
public class UserService {
    private UserDao userDao = UserDao.getInstance();
    private static UserService userService = null;
    private UserService(){}

    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }


    public void addUser(User user){
        /**
         * 1.参数合法校验
         *     用户名 密码 昵称 非空
         * 2.用户名唯一  & 编号唯一
         * 3.执行添加 返回结果
         */
        CheckParas.isBlank(user.getUserName(), "用户名");
        CheckParas.isBlank(user.getUserPwd(), "密码");
        CheckParas.isBlank(user.getNick(), "昵称");

        CheckParas.isRepeatUserName(user);
        CheckParas.isRepeatUserId(user);
        userDao.addUser(user);
    }

    public void listUsers(){
        System.out.println("--------------------------------------");
        List<User> users = userDao.getUsers();
        users.forEach(System.out::println);
        System.out.println("--------------------------------------");
    }

    public void updateUser(User user){
        /**
         * 1.校验
         *    用户名 密码 昵称 非空
         * 2.根据id 查询用户记录是否存在
         *    不存在->抛异常(更新记录不存在)
         * 3.记录存在，判断用户名 昵称是否出现重复
         *      用户名唯一校验
         *      昵称唯一校验
         * 4.执行更新 判断结果
         */
        CheckParas.isBlank(user.getUserName(), "用户名");
        CheckParas.isBlank(user.getUserPwd(), "密码");
        CheckParas.isBlank(user.getNick(), "昵称");
        CheckParas.isBlank(user.getId(), "用户编号");
        CheckParas.isNullUserId(user.getId());
        CheckParas.isRepeatUserName(user);
        userDao.updataUser(user);
    }
    public void deleteUser(Integer id){
        CheckParas.isNullUserId(id);
        userDao.deleteUserById(id);
    }
}
