package com.kawa.youli.controller;

import com.kawa.youli.entity.DTO.UserDto;
import com.kawa.youli.entity.common.ResponseBody;
import com.kawa.youli.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("按id查询用户")
    @GetMapping("/user/{id}")
    public ResponseBody<UserDto> getByUserId(@PathVariable("id") @NotBlank String id)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<UserDto>().success(userService.getByUserId(id));
    }

    @ApiOperation("按用户名模糊查询用户")
    @GetMapping("/user/name/{name}")
    public ResponseBody<List<UserDto>> getByUserName(@PathVariable("name") @NotBlank String name)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<List<UserDto>>().success(userService.getByUserName(name));
    }

    @ApiOperation("添加用户")
    @PostMapping("/user")
    public ResponseBody<String> insert(@RequestBody @Valid UserDto userDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(userService.insert(userDto));
    }

    @ApiOperation("更新用户数据")
    @PutMapping("/user")
    public ResponseBody<String> update(@RequestBody @Valid UserDto userDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(userService.update(userDto));
    }

    @ApiOperation("按id删除用户")
    @DeleteMapping("/user/{id}")
    public ResponseBody<String> delete(@PathVariable("id") @NotBlank String id){
        return new ResponseBody<String>().success(userService.delete(id));
    }
}
