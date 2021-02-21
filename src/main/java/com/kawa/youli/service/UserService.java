package com.kawa.youli.service;

import com.kawa.youli.entity.DTO.UserDto;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService {
    public UserDto getByUserId(String userId) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
    public List<UserDto> getByUserName(String userName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String update(UserDto userDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String insert(UserDto userDto) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
    public String delete(String userId);
}
