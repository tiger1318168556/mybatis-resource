package com.tiger.dao;

import com.tiger.bean.User;

import java.util.List;

/**
 * @author:zhanglihu
 * @Date:2022/6/19-06-19-1:10
 * @Description:com.tiger.dao
 * @Version:1.0
 **/
public interface IUserDao {
    //查询所有用户
    public List<User> findAll() throws Exception;
    //根据条件进行用户查询
    public User findUserByCondition(User user) throws Exception;
}
