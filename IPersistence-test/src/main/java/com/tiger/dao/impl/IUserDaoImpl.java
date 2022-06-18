package com.tiger.dao.impl;

import com.tiger.bean.User;
import com.tiger.dao.IUserDao;
import com.tiger.io.Resources;
import com.tiger.sqlsession.SqlSession;
import com.tiger.sqlsession.SqlSessionFactory;
import com.tiger.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-1:10
 * @Description:com.tiger.dao.impl
 * @Version:1.0
 **/
public class IUserDaoImpl implements IUserDao {
    @Override
    public List<User> findAll() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("tiger");
        List<User> users = sqlSession.selectList("user.selectList");
        return users;
    }

    @Override
    public User findUserByCondition(User user) throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User queryUser = sqlSession.selectOne("user.selectOne", user);
        return queryUser;

    }
}
