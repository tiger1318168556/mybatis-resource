package com.tiger.bean;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-20:26
 * @Description:com.tiger.bean
 * @Version:1.0
 **/
public class MappedStatement {
    //id 标识
    private String id;
    //返回值类型
    private String resultType;
    //参数值类型
    private String paramterType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getParamterType() {
        return paramterType;
    }

    public void setParamterType(String paramterType) {
        this.paramterType = paramterType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    //sql 语句
    private String sql;


    //
}
