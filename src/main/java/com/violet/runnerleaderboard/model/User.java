package com.violet.runnerleaderboard.model;

public class User {

    private Integer userId;
    private String userName;
    private Integer age;

    public User(){}

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
