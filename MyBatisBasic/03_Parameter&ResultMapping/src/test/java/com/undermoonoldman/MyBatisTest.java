package com.undermoonoldman;

import com.undermoonoldman.bean.QueryVo;
import com.undermoonoldman.bean.User;
import com.undermoonoldman.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
    private SqlSession sqlSession;
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
//        3.使用工厂生产一个SqlSession对象
            sqlSession = factory.openSession();
//        4.使用SqlSession对象创建dao接口的代理对象
            userDao = sqlSession.getMapper(UserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        try {
            /**因为自动关闭了自动提交,所以这里做手动提交*/
            sqlSession.commit();
            in.close();
            sqlSession.close();
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
        user.setId(7);
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
        Integer userId = 7;
        userDao.deleteUser(userId);
        List<User> userList = userDao.findAll();
        System.out.println(userList);
    }

    @Test
    public void testFindById(){
        Integer userId = 1;
        User user = userDao.findUserById(userId);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        String username = "王";

        List<User> userList = userDao.findByName(username);
        System.out.println(userList);
    }

    @Test
    public void testCountTotal(){
        int total = userDao.countTotal();
        System.out.println(total);
    }

    @Test
    public void testFindUserByVo(){
        List<User> result = null;
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        result = userDao.findUserByVo(queryVo);
        System.out.println(result);
    }
}
