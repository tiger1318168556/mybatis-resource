package com.tiger.sqlsession;

import com.tiger.bean.Configuration;
import com.tiger.config.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-20:36
 * @Description:com.tiger.sqlsession
 * @Version:1.0
 **/
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream inputStream){
        //1使用dom4j 解析配置文件，将解析出来的内容，封装到Configuration中
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(inputStream);
        //2 创建SqlSessionFactory对象 工厂类：生产sqlSession 会话对象
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }
}
