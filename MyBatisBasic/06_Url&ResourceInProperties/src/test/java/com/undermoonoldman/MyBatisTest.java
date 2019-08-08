package com.undermoonoldman;

import com.undermoonoldman.bean.User;
import com.undermoonoldman.dao.UserDao;
import com.undermoonoldman.dao.UserDaoImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    private UserDao userDao;
    private InputStream in;

    @Before
    public void init(){
        try {
//        1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
//        3.使用工厂对象创建dao对象
            userDao = new UserDaoImpl(factory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        try {
            /**因为自动关闭了自动提交,所以这里做手动提交*/
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public  void testFindAll() throws Exception {
//        5.使用代理对象执行方法
        List<User> userList = userDao.findAll();

        System.out.println(userList);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("李明");
        user.setAddress("长安街");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("before save " + user);
        userDao.saveUser(user);
        System.out.println("after save " + user);
//        List<User> userList = userDao.findAll();
//        System.out.println(userList);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(8);
        user.setUsername("韩梅梅");
        user.setAddress("木樨地");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    public void testDelete(){
        Integer userId = 9;
        userDao.deleteUser(userId);
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    public void testFindById(){
        Integer userId = 8;
        User user = userDao.findUserById(userId);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        String username = "%王%";

        List<User> userList = userDao.findByName(username);
        System.out.println(userList);
    }

    @Test
    public void testCountTotal(){
        int total = userDao.countTotal();
        System.out.println(total);
    }

}
