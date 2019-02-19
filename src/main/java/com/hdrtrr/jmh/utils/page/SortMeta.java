package com.hdrtrr.jmh.utils.page;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ÏÂÎç 1:47
 * @Version 1.0
 */
public class SortMeta {
    /**
     * ÅÅĞò×Ö¶Î
     */
    private String field;
    /**
     * ÅÅĞò·½Ê½
     */
    private int order;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
