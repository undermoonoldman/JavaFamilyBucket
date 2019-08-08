package com.undermoonoldman.dao;

import com.undermoonoldman.bean.Account;
import com.undermoonoldman.bean.AccountUser;
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
            accountDao = sqlSession.getMapper(AccountDao.class);
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
        List<Account> accountList = accountDao.findAll();

        System.out.println(accountList);
    }

    @Test
    public void testFindAllAccount(){
        List<AccountUser> accountUserList = accountDao.findAllAccount();
        System.out.println(accountUserList);
    }
}
