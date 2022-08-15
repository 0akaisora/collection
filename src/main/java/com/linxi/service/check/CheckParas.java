package com.linxi.service.check;

import com.linxi.dao.UserDao;
import com.linxi.pojo.User;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: linxi
 * Date: 2022/8/15
 * Time: 17:44
 * Description:
 */
public class CheckParas {
    private static UserDao userDao = UserDao.getInstance();

    public static void isBlank(String obj, String msg){
        if(StringUtils.isBlank(obj)){
            throw new RuntimeException(msg + "不能为空!");
        }
    }
    public static void isBlank(Integer obj, String msg){
        if(obj == null){
            throw new RuntimeException(msg + "不能为空!");
        }
    }
    // 检查用户编号是否有效
    public static void isNullUserId(Integer id){
        User user = userDao.getUserById(id);
        if(user == null){
            throw new RuntimeException("无效的用户编号!");
        }
    }
    // 检查用户名是否已存在
    public static void isRepeatUserName(User user){
        User u = userDao.getUserByName(user.getUserName());
        if(u != null && !u.getId().equals(user.getId())){
            throw new RuntimeException("用户名已存在!");
        }
    }
    // 检查用户编号是否已存在
    public static void isRepeatUserId(User user){
        User u = userDao.getUserById(user.getId());
        if(u != null){
            throw new RuntimeException("用户编号已存在!");
        }
    }


}

