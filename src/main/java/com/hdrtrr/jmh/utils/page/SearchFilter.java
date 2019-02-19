package com.hdrtrr.jmh.utils.page;

import java.util.Objects;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ���� 2:19
 * ��̬��ѯ����
 * @Version 1.0
 */
public class SearchFilter {
    private String fieldName;
    private Object value;
    private Operator operator;

    /**
     * ��ѯ����ö��
     */
    public enum Operator {
        /**
         * ����
         */
        EQ,
        /**
         * like
         */
        LIKE,
        /**
         * ����
         */
        GT,
        /**
         * С��
         */
        LT,
        /**
         * ���ڵ���
         */
        GTE,
        /**
         * С�ڵ���
         */
        LTE,
        /**
         * in
         */
        IN,
        /**
         * ��� like
         */
        LLIKE,
        /**
         * �Ҳ� like
         */
        RLIKE,
        /**
         * Ϊnull
         */
        ISNULL,
        /**
         * between
         */
        BETWEEN,
        /**
         * ������
         */
        NOTEQ,
        /**
         * ����null
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
