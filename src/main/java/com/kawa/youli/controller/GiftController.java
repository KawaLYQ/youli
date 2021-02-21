package com.kawa.youli.controller;

import com.kawa.youli.entity.DTO.GiftDto;
import com.kawa.youli.entity.common.ResponseBody;
import com.kawa.youli.service.GiftService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GiftController {
    @Autowired
    private GiftService giftService;

    @ApiOperation("按礼物ID获得礼物信息")
    @GetMapping("/gift/{id}")
    public ResponseBody<GiftDto> getById(@PathVariable("id") @NotNull Integer id)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<GiftDto>().success(giftService.getById(id));
    }

    @ApiOperation("按礼物名称模糊查找礼物信息")
    @GetMapping("/gift/author/{name}")
    public ResponseBody<List<GiftDto>> getByName(@PathVariable("name") @NotBlank String name)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<List<GiftDto>>().success(giftService.getByName(name));
    }

    @ApiOperation("按价格区间查找礼物信息")
    @GetMapping("/gift/priceRange")
    public ResponseBody<List<GiftDto>> getByPriceRange(@RequestParam(value = "min",defaultValue = "0") @NotNull Integer min,
                                                       @RequestParam(value = "max",defaultValue = "2147483647") @NotNull Integer max)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<List<GiftDto>>().success(giftService.getByPriceRange(min,max));
    }

    @ApiOperation("获得礼物人气值排名")
    @GetMapping("/gift/Rank")
    public ResponseBody<List<GiftDto>> getPopularRank()
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<List<GiftDto>>().success(giftService.getPopularRank());
    }

    @ApiOperation("添加礼物")
    @PostMapping("/gift")
    public ResponseBody<String> insert(@RequestBody @Valid GiftDto giftDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(giftService.insert(giftDto));
    }

    @ApiOperation("更新礼物信息")
    @PutMapping("/gift")
    public ResponseBody<String> update(@RequestBody @Valid GiftDto giftDto)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new ResponseBody<String>().success(giftService.update(giftDto));
    }

    @ApiOperation("增加礼物人气值")
    @PutMapping("/gift/popular/{id}")
    public ResponseBody<String> popular(@PathVariable("id") @NotNull Integer id) {
        return new ResponseBody<String>().success(giftService.popular(id));
    }

    @ApiOperation("按礼物ID删除礼物信息")
    @DeleteMapping("/gift/{id}")
    public ResponseBody<String> delete(@PathVariable("id") @NotNull Integer id) {
        return new ResponseBody<String>().success(giftService.delete(id));
    }
}
