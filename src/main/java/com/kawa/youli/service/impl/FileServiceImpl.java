package com.kawa.youli.service.impl;

import com.kawa.youli.service.FileService;
import com.kawa.youli.util.IPUtil;
import com.kawa.youli.util.ServerFilesIO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.SocketException;

@Service
public class FileServiceImpl implements FileService {
    private static String StrategyPicPath="/static/pic/strategy/";
    private static String GiftPicPath="/static/pic/gift/";
    private static String HeadShotPath="/static/pic/headShot/";
    private static String StrategyPath="/static/content/strategy/";
    private static String GiftPath="/static/content/gift/";
    private final static String UrlPath="http://www.youliappcloud.wang/";
    private final static String LocalPath="http://127.0.0.1/";
    private static String HeadShotUrlPath="headShot/";
    private static String StrategyPicUrlPath="strategyPic/";
    private static String GiftPicUrlPath="giftPic/";

    public FileServiceImpl() throws SocketException {
        if (IPUtil.isWindowsOS()) {  //如果是Windows系统
            StrategyPicPath="D:"+StrategyPicPath;
            GiftPicPath="D:"+GiftPicPath;
            HeadShotPath="D:"+HeadShotPath;
            StrategyPath="D:"+StrategyPath;
            GiftPath="D:"+GiftPath;
        }
        if(!IPUtil.getSelfPublicIp().equals("49.234.75.232")){
            HeadShotUrlPath=LocalPath+HeadShotUrlPath;
            StrategyPicUrlPath=LocalPath+StrategyPicUrlPath;
            GiftPicUrlPath=LocalPath+GiftPicUrlPath;
        }
        else{
            HeadShotUrlPath=UrlPath+HeadShotUrlPath;
            StrategyPicUrlPath=UrlPath+StrategyPicUrlPath;
            GiftPicUrlPath=UrlPath+GiftPicUrlPath;
        }
    }

    @Override
    public String getStrategyContent(String contentId){
        return ServerFilesIO.loadContent(StrategyPath+contentId+".txt");
    }

    @Override
    public String getGiftContent(String contentId){
        return ServerFilesIO.loadContent(GiftPath+contentId+".txt");
    }

    @Override
    public String getHeadShot(String headShotId) {
        return HeadShotUrlPath+headShotId;
    }

    @Override
    public String getStrategyPic(String PicId) {
        return StrategyPicUrlPath+PicId;
    }

    @Override
    public String getGiftPic(String PicId) {
        return GiftPicUrlPath+PicId;
    }

    @Override
    public String uploadHeadShot(MultipartFile file) {
        return ServerFilesIO.uploadPic(file,HeadShotPath);
    }

    @Override
    public String uploadGiftPic(MultipartFile file) {
        return ServerFilesIO.uploadPic(file,GiftPicPath);
    }

    @Override
    public String uploadStrategyPic(MultipartFile file) {
        return ServerFilesIO.uploadPic(file,StrategyPicPath);
    }

    @Override
    public String uploadStrategyContent(String[] content){
        return ServerFilesIO.uploadContent(content,StrategyPath);
    }

    @Override
    public String uploadGiftContent(String[] content){
        return ServerFilesIO.uploadContent(content,GiftPath);
    }

    @Override
    public String uploadStrategyContent(String content){
        return ServerFilesIO.uploadContent(content,StrategyPath);
    }

    @Override
    public String uploadGiftContent(String content){
        return ServerFilesIO.uploadContent(content,GiftPath);
    }
}
