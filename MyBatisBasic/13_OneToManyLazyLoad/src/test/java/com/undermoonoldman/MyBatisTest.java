package com.undermoonoldman;

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
            SqlSession sqlSession = factory.openSession();
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
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> userList = userDao.findAll();

        System.out.println(userList);
    }



    @Test
    public void testFindById(){
        Integer userId = 8;
        User user = userDao.findUserById(userId);
        System.out.println(user);
    }

}
