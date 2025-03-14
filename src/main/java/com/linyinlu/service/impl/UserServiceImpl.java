package com.linyinlu.service.impl;

import com.linyinlu.dao.IUserDao;
import com.linyinlu.entity.User;
import com.linyinlu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;

    @Override
    public List<User> findAll() {
        System.out.println("user业务层实现类--findAll");
        return userDao.findAll();
    }

    @Override
    public List<User> findAllTeacher() {
        return userDao.findAllTeacher();
    }

    @Override
    public User checkUserName(int account) {
        return userDao.checkUserName(account);
    }

    @Override
    public void addUser(User user) {
        System.out.println("user业务层实现类--saveUser");
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        System.out.println("user业务层实现类--deleteUser");
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        System.out.println("user业务层实现类--updateUser");
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(int user_id) {
        return userDao.getUserById(user_id);
    }

    @Override
    public User selectUserByAccountAndPassword(User user) {
        System.out.println("user业务层实现类--selectUserByNameAndPassword");
        User userFromDb = userDao.selectUserByAccountAndPassword(user);
        return userFromDb;
    }

    @Override
    public void updateUserToken(User user) {
        userDao.updateUserToken(user);
    }

    @Override
    public boolean isCommonToken(String reqToken, String sqlToken) {
        return reqToken.equals(sqlToken);
    }

    @Override
    public User selectUserByRefreshToken(String refreshToken) {
        return userDao.selectUserByRefreshToken(refreshToken);
    }


}
