package com.undermoonoldman.dao;

import com.undermoonoldman.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("com.undermoonoldman.dao.UserDao.findAll");
        sqlSession.close();
        return userList;
    }

    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.undermoonoldman.dao.UserDao.saveUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("com.undermoonoldman.dao.UserDao.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("com.undermoonoldman.dao.UserDao.deleteUser", userId);
        sqlSession.commit();
        sqlSession.close();
    }

    public User findUserById(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("com.undermoonoldman.dao.UserDao.findUserById", userId);
        sqlSession.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("com.undermoonoldman.dao.UserDao.findByName", username);
        sqlSession.close();
        return userList;
    }

    public int countTotal() {
        SqlSession sqlSession = factory.openSession();
        int count = sqlSession.selectOne("com.undermoonoldman.dao.UserDao.countTotal");
        sqlSession.close();
        return count;
    }
}
