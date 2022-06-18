package com.tiger.config;

import com.tiger.util.ParameterMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-22:27
 * @Description:com.tiger.config
 * @Version:1.0
 **/
public class BoundSql {
    private String sqlText;//解析过后的sql
    private List<ParameterMapping> parameterMappingList = new ArrayList<>();

    public BoundSql(String sqlText, List<ParameterMapping> parameterMappingList) {
        this.sqlText = sqlText;
        this.parameterMappingList = parameterMappingList;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public List<ParameterMapping> getParameterMappingList() {
        return parameterMappingList;
    }

    public void setParameterMappingList(List<ParameterMapping> parameterMappingList) {
        this.parameterMappingList = parameterMappingList;
    }
}
