package com.kawa.youli.dao;

import com.kawa.youli.entity.DO.User;

import java.util.List;

public interface UserDao {
    public User getByUserId(String userId);
    public List<User> getByUserName(String userName);
    public String insert(User user);
    public String update(User user);
    public String delete(String userId);
}
