package com.hdrtrr.jmh.utils.page;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ���� 2:41
 * ��ѯ��ʽ
 * @Version 1.0
 */
public interface NgMathMode {
    /**
     * ����
     */
    String CONTAINS = "contains";
    /**
     * ��xx��ʼ
     */
    String STARTS_WITH = "startsWith";
    /**
     * ��xx����
     */
    String ENDS_WITH = "endsWith";
    /**
     * ����
     */
    String EQUALS = "equals";
    /**
     * ���б���
     */
    String IN = "in";
    /**
     * is null
     */
    String ISNULL = "isNull";
    /**
     * is null
     */
    String ISNOTNULL = "isNotNull";
    /**
     * С��
     */
    String LT = "lt";
    /**
     * ����
     */
    String GT = "gt";

    /**
     * ���ڵ���
     */
    String GTE = "gte";
    /**
     * С�ڵ���
     */
    String LTE = "lte";

    /**
     * between
     */
    String BETWEEN = "between";
}
