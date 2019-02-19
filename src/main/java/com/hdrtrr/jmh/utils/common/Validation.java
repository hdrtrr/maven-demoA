package com.hdrtrr.jmh.utils.common;

import java.util.regex.Pattern;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ���� 4:16
 * ��֤
 * @Version 1.0
 */
public class Validation {
    /**
     * �ֻ�������
     */
    private static final String PHONE_REGEX = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|" +
            "(18[0-9])|(19[8|9]))\\d{8}$";

    /**
     * ���֤����
     */
    private static final String ID_REGEX = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])" +
            "|10|20|30|31)\\d{3}[0-9Xx]$";

    /**
     * ��������
     */
    private static final String MAIL_REGEX = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)" +
            "+[a-zA-Z]{2,}$";

    /**
     * �Ƿ����ֻ���
     *
     * @param phone �ֻ���
     * @return �Ƿ���true�����Ƿ���false
     */
    public static boolean isPhoneNum(String phone) {
        if (phone.length() != 11) {
            return false;
        } else {
            return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
        }
    }

    /**
     * �Ƿ������֤��
     *
     * @param idCard ���֤
     * @return �Ƿ���true�����Ƿ���false
     */
    public static boolean isIdCard(String idCard) {
        return Pattern.compile(ID_REGEX).matcher(idCard).matches();
    }

    /**
     * �Ƿ�������
     *
     * @param mail ����
     * @return �Ƿ���true�����Ƿ���false
     */
    public static boolean isMail(String mail) {
        if (mail == null) {
            return false;
        }
        return Pattern.compile(MAIL_REGEX).matcher(mail).matches();
    }
}
