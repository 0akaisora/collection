package com.linxi.dao;

import com.linxi.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: linxi
 * Date: 2022/8/15
 * Time: 15:40
 * Description:
 */
public class UserDao {
    private static UserDao userDao = null;
    private List<User> users;

    private UserDao() {
        if(users == null){
            users = new ArrayList<>();
            users.add(new User(1, "admin", "123456", "admin", "", ""));
            users.add(new User(2, "user1", "123456", "admin", "", ""));
            users.add(new User(3, "user2", "123456", "admin", "", ""));
        }
    }

    public static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }

    public User getUserByName(String name) {
        Optional<User> UserOpt = users.stream().filter(u -> u.getUserName().equals(name)).findFirst();
        if (UserOpt.isPresent()) {
            return UserOpt.get();
        } else {
            return null;
        }
    }

    public User getUserById(Integer id) {
        Optional<User> UserOpt = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return UserOpt.isPresent() ? UserOpt.get() : null;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean updataUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUserById(Integer id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(id)){
                users.remove(i);
                return true;
            }
        }
        return false;
    }


}
