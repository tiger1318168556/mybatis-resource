package com.tiger.sqlsession;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-21:38
 * @Description:com.tiger.sqlsession
 * @Version:1.0
 **/
public interface SqlSession {
    //查询所有
    public <E> List<E> selectList(String statementId,Object ... params) throws Exception;
    //根据条件查询单个
    public <T> T selectOne(String statementId,Object ... params) throws Exception;
    //为Dao接口生成代理实现类
    public <T> T getMapper(Class<?> mapperClass);

}
