package com.linxi.service;

import com.linxi.pojo.User;
import org.apache.commons.lang3.StringUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: linxi
 * Date: 2022/8/15
 * Time: 14:53
 * Description:
 */
public class UserService {

    private List<User> users;
    UserService(){
        users = new ArrayList<>();
        users.add(new User(1,"admin","123456","admin","",""));
        users.add(new User(2,"test","123456","test","",""));

    }

    public void addUser(User user){
        /**
         * 1.参数合法校验
         *     用户名 密码 昵称 非空
         * 2.用户名唯一  & 昵称唯一
         * 3.执行添加 返回结果
         */
        if(StringUtils.isBlank(user.getUserName())){
            throw new RuntimeException("用户名不能为空!");
        }
        if(StringUtils.isBlank(user.getUserPwd())){
            throw new RuntimeException("密码不能为空!");
        }
        if(StringUtils.isBlank(user.getNick())){
            throw new RuntimeException("昵称不能为空!");
        }

        long count = users.stream().filter(u-> u.getUserName().equals(user.getUserName())).count();
        if(count>0){
            throw new RuntimeException("用户名已存在!");
        }
        users.add(user);
    }
}
