package com.tiger.sqlsession;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-20:38
 * @Description:com.tiger.sqlsession
 * @Version:1.0
 **/
public interface SqlSessionFactory {
    public SqlSession openSession();
}
