package com.kawa.youli.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public String getStrategyContent(String contentId);
    public String getGiftContent(String contentId);
    public String getHeadShot(String headShotId);
    public String getStrategyPic(String PicId);
    public String getGiftPic(String PicId);
    public String uploadHeadShot(MultipartFile file);
    public String uploadGiftPic(MultipartFile file);
    public String uploadStrategyPic(MultipartFile file);
    public String uploadStrategyContent(String[] content);
    public String uploadGiftContent(String[] content);
    public String uploadStrategyContent(String content);
    public String uploadGiftContent(String content);
}
