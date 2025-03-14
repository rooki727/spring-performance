package com.linyinlu.dao;

import com.linyinlu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    List<User> findAll();
    List<User> findAllTeacher();
    User checkUserName(int account);
    void addUser(User user);

    void deleteUser(int user_id);

    void updateUser(User user);
    User getUserById(int user_id);
    User selectUserByAccountAndPassword(User user);
    void updateUserToken(User user);
    User selectUserByRefreshToken(String refreshToken);
}
