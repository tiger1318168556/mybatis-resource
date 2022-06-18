package com.tiger.bean;

/**
 * @author:zhanglihu
 * @Date:2022/6/18-06-18-21:48
 * @Description:com.tiger.bean
 * @Version:1.0
 **/
public class User {
    private Integer id;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
