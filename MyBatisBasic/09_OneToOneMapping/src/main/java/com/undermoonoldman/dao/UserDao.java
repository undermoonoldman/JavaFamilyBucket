package com.undermoonoldman.dao;


import com.undermoonoldman.bean.User;
import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findUserById(Integer userId);


}
