package com.undermoonoldman.dao;

import com.undermoonoldman.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {
    /**配置对应Sql语句*/
    @Select("select * from user")
    List<User> findAll();
}
