package com.hdrtrr.jmh.utils.common;

import java.util.regex.Pattern;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 4:16
 * 验证
 * @Version 1.0
 */
public class Validation {
    /**
     * 手机号正则
     */
    private static final String PHONE_REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|" +
            "(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * 身份证正则
     */
    private static final String ID_REGEX = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])" +
            "|10|20|30|31)\\d{3}[0-9Xx]$";

    /**
     * 邮箱正则
     */
    private static final String MAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)" +
            "+[a-zA-Z]{2,}$";

    /**
     * 是否是手机号
     *
     * @param phone 手机号
     * @return 是返回true，不是返回false
     */
    public static boolean isPhoneNum(String phone) {
        if (phone.length() != 11) {
            return false;
        } else {
            return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
        }
    }

    /**
     * 是否是身份证号
     *
     * @param idCard 身份证
     * @return 是返回true，不是返回false
     */
    public static boolean isIdCard(String idCard) {
        return Pattern.compile(ID_REGEX).matcher(idCard).matches();
    }

    /**
     * 是否是邮箱
     *
     * @param mail 邮箱
     * @return 是返回true，不是返回false
     */
    public static boolean isMail(String mail) {
        if (mail == null) {
            return false;
        }
        return Pattern.compile(MAIL_REGEX).matcher(mail).matches();
    }
}
