package com.linyinlu.service;
import com.linyinlu.entity.User;
import java.util.List;

public interface IUserService {

    //查询所有
     List<User> findAll();
    List<User> findAllTeacher();
    User checkUserName(int account);
    //添加用户
    public void addUser(User user);
    //删
    void deleteUser(int id);
    //改
    void updateUser(User user);
    User getUserById(int user_id);
    //查
    //根据用户名和密码查询
    User selectUserByAccountAndPassword(User user);
    void updateUserToken(User user);
    boolean isCommonToken(String reqToken, String sqlToken);
    User selectUserByRefreshToken(String refreshToken);
}

