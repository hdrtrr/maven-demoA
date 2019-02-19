package com.hdrtrr.jmh.utils.common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ÏÂÎç 4:19
 * @Version 1.0
 */
public class Md5Util {
    /**
     * MD5¼ÓÃÜ×Ö·û´®
     *
     * @param str Ô´×Ö·û´®
     * @return ¼ÓÃÜºóµÄ×Ö·û´®
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
        String s1 = encryptToMD5(encryptToMD5(s));
        System.out.println(s1);
    }

}
