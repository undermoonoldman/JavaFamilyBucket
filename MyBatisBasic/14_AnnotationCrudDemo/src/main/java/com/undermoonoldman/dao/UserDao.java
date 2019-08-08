package com.undermoonoldman.dao;


import com.undermoonoldman.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username, address, sex, birthday) values (#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Update("update user set username = #{username}, address = #{address}, sex = #{sex}, birthday = #{birthday} where id = #{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{userId}")
    void deleteUser(Integer userId);

    @Select("select * from user where id = #{userId}")
    User findUserById(Integer userId);

}
