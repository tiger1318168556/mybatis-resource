package com.tiger.sqlsession;

import com.tiger.bean.Configuration;
import com.tiger.bean.MappedStatement;

import java.lang.invoke.CallSite;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-21:40
 * @Description:com.tiger.sqlsession
 * @Version:1.0
 **/
public class DefaultSqlSession implements SqlSession{
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) throws Exception {
        //将要去完成SimpleExecutor 里的query方法的调用
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> list = simpleExecutor.query(configuration, mappedStatement, params);
        return (List<E>) list;
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws Exception {
        List<Object> objects = selectList(statementId, params);
        if(objects.size() ==1){
            return (T) objects.get(0);
        }else{
            throw  new RuntimeException("查询结果为空或者返回结果过多");
        }
    }
}
