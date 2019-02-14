package com.hdrtrr.jmh.utils.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 4:19
 * @Version 1.0
 */
public class Md5Util {
    /**
     * MD5加密字符串
     *
     * @param str 源字符串
     * @return 加密后的字符串
     */
    public static String encryptToMD5(String str) {
        String hexStr = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(str.getBytes(StandardCharsets.UTF_8));
            hexStr = ByteUtils.toHexString(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexStr;
    }



    // test main
    public static void main(String[] args) {
        String s = "124565ss5";
        String s1 = encryptToMD5(s);
        System.out.println(s1);
    }

}
