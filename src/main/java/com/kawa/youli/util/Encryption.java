package com.kawa.youli.util;

import java.security.MessageDigest;

public class Encryption {

    public static String encrypt(String src){
        try{
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte[] srcByte=src.getBytes();
            byte[] digest=md5.digest(srcByte);
            char[] chars = new char[]
                    { '0', '1', '2', '3', '4', '5', '6', '7' , '8', '9', 'A', 'B', 'C', 'D', 'E','F' };
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(chars[(b >> 4) & 15]);
                sb.append(chars[b & 15]);
            }
            return sb.toString();
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
            return null;
        }
    }
}
