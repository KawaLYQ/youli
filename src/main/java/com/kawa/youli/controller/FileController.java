package com.kawa.youli.controller;

import com.kawa.youli.entity.common.ResponseBody;
import com.kawa.youli.service.EvaluateService;
import com.kawa.youli.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/static")
public class FileController {

    @Autowired
    FileService fileService;


    @ApiOperation("获取攻略内容")
    @GetMapping(value = "/strategy/content/{contentId}")
    public ResponseBody getStrategyContent(@PathVariable(value = "contentId") @NotBlank String contentId) {
        return new ResponseBody<String>().success(fileService.getStrategyContent(contentId));
    }

    @ApiOperation("获取礼物介绍")
    @GetMapping(value = "/gift/content/{contentId}")
    public ResponseBody getGiftContent(@PathVariable(value = "contentId") @NotBlank String contentId) {
        return new ResponseBody<String>().success(fileService.getGiftContent(contentId));
    }

    @ApiOperation("获取用户头像url")
    @GetMapping(value = "/headShot/{headShotId}")
    public ResponseBody getUserPic(@PathVariable(value = "headShotId") @NotBlank String headShotId) {
        return new ResponseBody<String>().success(fileService.getHeadShot(headShotId));
    }

    @ApiOperation("获取攻略图片url")
    @GetMapping(value = "/strategy/pic/{picId}")
    public ResponseBody getStrategyPic(@PathVariable(value = "picId") @NotBlank String PicId) {
        return new ResponseBody<String>().success(fileService.getStrategyPic(PicId));
    }

    @ApiOperation("获取礼物图片url")
    @GetMapping(value = "/gift/pic/{picId}")
    public ResponseBody getGiftPic(@PathVariable(value = "picId") @NotBlank String PicId) {
        return new ResponseBody<String>().success(fileService.getGiftPic(PicId));
    }

    @ApiOperation("上传用户头像")
    @PostMapping(value = "/headShot")
    public ResponseBody uploadHeadShot(@RequestParam(value = "headShot") MultipartFile file) {
        return new ResponseBody<String>().success(fileService.uploadHeadShot(file));
    }

    @ApiOperation("上传攻略内容")
    @PostMapping(value = "/strategy/content")
    public ResponseBody uploadStrategyContent(@RequestParam(value = "content") String[] content) {
        return new ResponseBody<String>().success(fileService.uploadStrategyContent(content));
    }

    @ApiOperation("上传礼物介绍")
    @PostMapping(value = "/gift/content")
    public ResponseBody uploadGiftContent(@RequestParam(value = "content") String[] content) {
        return new ResponseBody<String>().success(fileService.uploadGiftContent(content));
    }


    @ApiOperation("上传攻略图片")
    @PostMapping(value = "/strategy/pic")
    public ResponseBody uploadStrategyPic(@RequestParam(value = "pic") MultipartFile file) {
        return new ResponseBody<String>().success(fileService.uploadStrategyPic(file));
    }

    @ApiOperation("上传礼物图片")
    @PostMapping(value = "/gift/pic")
    public ResponseBody uploadGiftPic(@RequestParam(value = "pic") MultipartFile file) {
        return new ResponseBody<String>().success(fileService.uploadGiftPic(file));
    }
}
