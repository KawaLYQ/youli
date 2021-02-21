package com.kawa.youli.service.impl;

import com.kawa.youli.dao.UserDao;
import com.kawa.youli.entity.DO.User;
import com.kawa.youli.entity.DTO.UserDto;
import com.kawa.youli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getByUserId(String userId) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user=userDao.getByUserId(userId);
        UserDto userDto=new UserDto(user);
        return userDto;
    }

    @Override
    public List<UserDto> getByUserName(String userName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<User> users=userDao.getByUserName(userName);
        List<UserDto> res=new ArrayList<>();
        for(int i=0;i<users.size();i++){
            res.add(new UserDto(users.get(i)));
        }
        return res;
    }

    @Override
    public String update(UserDto userDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user=new User(userDto);
        return userDao.update(user);
    }

    @Override
    public String insert(UserDto userDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user=new User(userDto);
        return userDao.insert(user);
    }

    @Override
    public String delete(String userId) {
        return userDao.delete(userId);
    }
}
