package com.undermoonoldman;

import com.undermoonoldman.bean.User;
import com.undermoonoldman.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws Exception {
//        1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//        3.使用工厂生产一个SqlSession对象
        SqlSession sqlSession = factory.openSession();
//        4.使用SqlSession对象创建dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        5.使用代理对象执行方法
        List<User> userList = userDao.findAll();

        System.out.println(userList);
//        6.释放资源
        sqlSession.close();
        in.close();
    }
}
