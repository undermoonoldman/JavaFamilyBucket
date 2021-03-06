package com.undermoonoldman.dao;

import com.undermoonoldman.bean.Account;
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

public class AccountDaoTest {
    private AccountDao accountDao;
    private InputStream in;
    private SqlSession sqlSession;

    @Before
    public void init(){
        try {
//        1.读取配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
//        3.使用工厂对象创建dao对象
            sqlSession = factory.openSession();
//        4.使用SqlSession对象创建dao接口的代理对象
            accountDao = sqlSession.getMapper(AccountDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destory(){
        try {
            sqlSession.commit();
            in.close();
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() throws Exception {
        List<Account> accountList = accountDao.findAll();

        for(Account account : accountList)
            System.out.println(account);
    }

}
