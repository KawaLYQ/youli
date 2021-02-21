package com.kawa.youli.util;

import com.kawa.youli.exception.FileLoadFailedException;
import com.kawa.youli.exception.FileNotExistException;
import com.kawa.youli.exception.FileUploadFailedException;
import com.kawa.youli.exception.UserNotExistException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class ServerFilesIO {
    public static String loadContent(String filePath) {
        try {
            StringBuilder result = new StringBuilder();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)), "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = bfr.readLine()) != null) {
                result.append(lineTxt).append("\n");
            }
            bfr.close();
            return result.toString();
        }catch (IOException e){
            String errMsg = e.getMessage();
            if (StringUtils.isNotBlank(errMsg) && errMsg.contains("系统找不到指定的文件")) {
                throw new FileNotExistException(e);
            } else {
                throw new FileLoadFailedException(e);
            }
        }
    }

    public static String uploadContent(String[] content,String parentPath) {
        Integer contentId=content.hashCode();
        String filePath=parentPath+contentId+".txt";
        try {
            File dest = new File(filePath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), "UTF-8"));
            for (String arr : content) {
                bfw.write(arr);
            }
            bfw.close();
            return contentId.toString();
        }catch (IOException e){
            throw new FileUploadFailedException(e);
        }
    }

    public static String uploadContent(String content,String parentPath) {
        Integer contentId=content.hashCode();
        String filePath=parentPath+contentId;
        try {
            File dest = new File(filePath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest), "UTF-8"));
            bfw.write(content);
            bfw.close();
            return contentId.toString();
        }catch (IOException e){
            throw new FileUploadFailedException(e);
        }
    }

    public static String uploadPic(MultipartFile file,String parentPath){
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(parentPath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
            throw new FileUploadFailedException(e);
        }
    }
}
