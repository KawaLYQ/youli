package com.kawa.youli.controller;

import com.kawa.youli.entity.DTO.EvaluateDto;
import com.kawa.youli.entity.common.ResponseBody;
import com.kawa.youli.service.EvaluateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EvaluateController {

    @Autowired
    EvaluateService evaluateService;

    @ApiOperation("按礼物ID获得评价")
    @GetMapping("/evaluate/gift/{id}")
    public ResponseBody<List<EvaluateDto>> getByGiftId(@PathVariable("id") @NotNull Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<List<EvaluateDto>>().success(evaluateService.getByGiftId(id));
    }

    @ApiOperation("按攻略ID获得评价")
    @GetMapping("/evaluate/strategy/{id}")
    public ResponseBody<List<EvaluateDto>> getByStrategyId(@PathVariable("id") @NotNull Integer id)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<List<EvaluateDto>>().success(evaluateService.getByStrategyId(id));
    }

    @ApiOperation("对礼物添加评价")
    @PostMapping("/evaluate/gift")
    public ResponseBody<String> insertAboutGift(@RequestBody @Valid EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(evaluateService.insertAboutGift(evaluateDto));
    }

    @ApiOperation("对攻略添加评价")
    @PostMapping("/evaluate/strategy")
    public ResponseBody<String> insertAboutStrategy(@RequestBody @Valid EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(evaluateService.insertAboutStrategy(evaluateDto));
    }

    @ApiOperation("更新礼物评价")
    @PutMapping("/evaluate/gift")
    public ResponseBody<String> updateAboutGift(@RequestBody @Valid EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(evaluateService.updateAboutGift(evaluateDto));
    }

    @ApiOperation("更新攻略评价")
    @PutMapping("/evaluate/strategy")
    public ResponseBody<String> updateAboutStrategy(@RequestBody @Valid EvaluateDto evaluateDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(evaluateService.updateAboutStrategy(evaluateDto));
    }

    @ApiOperation("按评价ID删除对礼物的评价")
    @DeleteMapping("/evaluate/gift/{id}")
    public ResponseBody<String> deleteAboutGift(@PathVariable @NotNull Integer id){
        return new ResponseBody<String>().success(evaluateService.deleteAboutGift(id));
    }

    @ApiOperation("按评价ID删除对攻略的评价")
    @DeleteMapping("/evaluate/strategy/{id}")
    public ResponseBody<String> deleteAboutStrategy(@PathVariable @NotNull Integer id){
        return new ResponseBody<String>().success(evaluateService.deleteAboutStrategy(id));
    }
}
