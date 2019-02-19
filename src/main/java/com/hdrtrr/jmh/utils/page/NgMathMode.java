package com.hdrtrr.jmh.utils.page;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 2:41
 * 查询方式
 * @Version 1.0
 */
public interface NgMathMode {
    /**
     * 包含
     */
    String CONTAINS = "contains";
    /**
     * 以xx开始
     */
    String STARTS_WITH = "startsWith";
    /**
     * 以xx结束
     */
    String ENDS_WITH = "endsWith";
    /**
     * 等于
     */
    String EQUALS = "equals";
    /**
     * 在列表中
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
     * 小于
     */
    String LT = "lt";
    /**
     * 大于
     */
    String GT = "gt";

    /**
     * 大于等于
     */
    String GTE = "gte";
    /**
     * 小于等于
     */
    String LTE = "lte";

    /**
     * between
     */
    String BETWEEN = "between";
}
