package com.tiger.bean;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-20:28
 * @Description:com.tiger.bean
 * @Version:1.0
 **/
public class Configuration {
    private DataSource dataSource;
    //key: statementId value:封装好的MappedStatement 对象
    Map<String,MappedStatement> mappedStatementMap = new HashMap<>();

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Map<String, MappedStatement> getMappedStatementMap() {
        return mappedStatementMap;
    }

    public void setMappedStatementMap(Map<String, MappedStatement> mappedStatementMap) {
        this.mappedStatementMap = mappedStatementMap;
    }
}
