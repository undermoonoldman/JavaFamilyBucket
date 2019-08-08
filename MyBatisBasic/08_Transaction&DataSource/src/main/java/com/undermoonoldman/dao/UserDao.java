package com.undermoonoldman.dao;

import com.undermoonoldman.bean.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findUserById(Integer userId);

    List<User> findByName(String username);

    int countTotal();
}