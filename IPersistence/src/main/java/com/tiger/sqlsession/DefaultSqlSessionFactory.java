package com.tiger.sqlsession;

import com.tiger.bean.Configuration;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-21:34
 * @Description:com.tiger.sqlsession
 * @Version:1.0
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private Configuration configuration;
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
