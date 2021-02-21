package com.kawa.youli.controller;

import com.kawa.youli.entity.DTO.StrategyDto;
import com.kawa.youli.entity.common.ResponseBody;
import com.kawa.youli.service.StrategyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StrategyController {
    @Autowired
    private StrategyService strategyService;

    @ApiOperation("按攻略ID获得攻略信息")
    @GetMapping("/strategy/{id}")
    public ResponseBody<StrategyDto> getById(@PathVariable @NotNull Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        return new ResponseBody<StrategyDto>().success(strategyService.getById(id));
    }

    @ApiOperation("按作者ID查找攻略")
    @GetMapping("/strategy/author/{id}")
    public ResponseBody<List<StrategyDto>> getByAuthorId(@PathVariable("id") @NotBlank String id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        return new ResponseBody<List<StrategyDto>>().success(strategyService.getByAuthorId(id));
    }

    @ApiOperation("按攻略名称模糊查找攻略")
    @GetMapping("/strategy/name/{name}")
    public ResponseBody<List<StrategyDto>> getByStrategyName(@PathVariable("name") @NotBlank String name)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        return new ResponseBody<List<StrategyDto>>().success(strategyService.getByStrategyName(name));
    }

    @ApiOperation("添加攻略")
    @PostMapping("/strategy")
    public ResponseBody<String> insert(@RequestBody @Valid StrategyDto strategyDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(strategyService.insert(strategyDto));
    }

    @ApiOperation("更新攻略")
    @PutMapping("/strategy")
    public ResponseBody<String> update(@RequestBody @Valid StrategyDto strategyDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(strategyService.update(strategyDto));
    }

    @ApiOperation("攻略观看数增加")
    @PutMapping("/strategy/views/{id}")
    public ResponseBody<String> views(@PathVariable("id") @NotNull Integer id){
        return new ResponseBody<String>().success(strategyService.views(id));
    }

    @ApiOperation("攻略点赞数增加")
    @PutMapping("/strategy/likes/{id}")
    public ResponseBody<String> likes(@PathVariable("id") @NotNull Integer id){
        return new ResponseBody<String>().success(strategyService.likes(id));
    }

    @ApiOperation("攻略评论数增加")
    @PutMapping("/strategy/comments/{id}")
    public ResponseBody<String> comments(@PathVariable("id") @NotNull Integer id){
        return new ResponseBody<String>().success(strategyService.comments(id));
    }

    @ApiOperation("按攻略ID删除攻略")
    @DeleteMapping("/strategy/{id}")
    public ResponseBody<String> delete(@PathVariable @NotNull Integer id){
        return new ResponseBody<String>().success(strategyService.delete(id));
    }
}
