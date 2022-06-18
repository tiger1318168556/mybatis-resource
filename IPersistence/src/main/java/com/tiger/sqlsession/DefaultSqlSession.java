package com.tiger.sqlsession;

import com.tiger.bean.Configuration;
import com.tiger.bean.MappedStatement;

import java.lang.invoke.CallSite;
import java.lang.reflect.*;
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

    /**
     * 使用JDK动态代理为Dao接口生成代理对象并返回
     * @param mapperClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<?> mapperClass) {
        Object proxyInstance = Proxy.newProxyInstance(DefaultSqlSession.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            /**
             *
             * @param proxy 当前代理对象的引用
             * @param method 当前被调用方法的引用
             * @param args 传递的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //根据不同情况来调用selectList或者selectOne
                //1、准备参数1 statementId：sql语句的唯一标识 namespace.id,namespace 的值要和接口的全限定名保持一致，id 的值要和接口的方法名保持一致
                String methodName = method.getName();//方法名
                String className = method.getDeclaringClass().getName();//className
                String statementId = className+"."+methodName;
                //准备参数2 params = args
                //获取被调用方法返回值类型
                Type genericReturnType = method.getGenericReturnType();
                //判断是否进行了  泛型类型参数化
                if(genericReturnType instanceof ParameterizedType){

                    List<Object> objects = selectList(statementId, args);
                    return objects;
                }else{
                    return selectOne(statementId,args);
                }
            }
        });

        return (T) proxyInstance;
    }
}
