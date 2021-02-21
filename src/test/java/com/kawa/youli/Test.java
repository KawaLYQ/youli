package com.kawa.youli;


import com.kawa.youli.entity.DO.User;
import com.kawa.youli.entity.DTO.UserDto;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {YouliApplication.class})
public class Test {
    @org.junit.Test
    public void test()
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user=new User();
        user.setUserName("kk");
        user.setSex(2);
        UserDto userDto=new UserDto(user);
        System.out.println(userDto);
        System.out.println(user);
    }
}
