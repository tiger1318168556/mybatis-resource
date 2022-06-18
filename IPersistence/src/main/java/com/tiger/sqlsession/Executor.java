package com.tiger.sqlsession;

import com.tiger.bean.Configuration;
import com.tiger.bean.MappedStatement;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-21:54
 * @Description:com.tiger.sqlsession
 * @Version:1.0
 **/
public interface Executor {
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object ... params) throws Exception;
}
