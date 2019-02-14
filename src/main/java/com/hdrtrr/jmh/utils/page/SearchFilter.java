package com.hdrtrr.jmh.utils.page;

import java.util.Objects;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 2:19
 * 动态查询对象
 * @Version 1.0
 */
public class SearchFilter {
    private String fieldName;
    private Object value;
    private Operator operator;

    /**
     * 查询条件枚举
     */
    public enum Operator {
        /**
         * 等于
         */
        EQ,
        /**
         * like
         */
        LIKE,
        /**
         * 大于
         */
        GT,
        /**
         * 小于
         */
        LT,
        /**
         * 大于等于
         */
        GTE,
        /**
         * 小于等于
         */
        LTE,
        /**
         * in
         */
        IN,
        /**
         * 左侧 like
         */
        LLIKE,
        /**
         * 右侧 like
         */
        RLIKE,
        /**
         * 为null
         */
        ISNULL,
        /**
         * between
         */
        BETWEEN,
        /**
         * 不等于
         */
        NOTEQ,
        /**
         * 不是null
         */
        ISNOTNULL;
    }

    public SearchFilter(String fieldName, Operator operator, Object value) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SearchFilter)) {
            return false;
        }
        SearchFilter that = (SearchFilter) o;
        return Objects.equals(fieldName, that.fieldName) &&
                Objects.equals(value, that.value) &&
                operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, value, operator);
    }
}
