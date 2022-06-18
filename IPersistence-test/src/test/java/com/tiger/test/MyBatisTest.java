package com.tiger.test;

import com.tiger.bean.User;
import com.tiger.io.Resources;
import com.tiger.sqlsession.SqlSession;
import com.tiger.sqlsession.SqlSessionFactory;
import com.tiger.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-1:02
 * @Description:com.tiger.test
 * @Version:1.0
 **/
public class MyBatisTest {
    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("tiger");
        //User queryUser = sqlSession.selectOne("user.selectOne", user);
        //System.out.println(queryUser);
        List<User> users = sqlSession.selectList("user.selectList");
        for (User u : users) {
            System.out.println(u);
        }
    }
}
