package com.undermoonoldman.dao;


import com.undermoonoldman.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address"),
            @Result(property = "accounts", column = "id", many = @Many(select = "com.undermoonoldman.dao.AccountDao.findAccountByUid", fetchType = FetchType.EAGER))
    })
    List<User> findAll();

    @Select("select * from user where id = #{userId}")
    @ResultMap(value = {"userMap"})
    User findUserById(Integer userId);

}
