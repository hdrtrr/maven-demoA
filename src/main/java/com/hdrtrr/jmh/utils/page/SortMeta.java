package com.hdrtrr.jmh.utils.page;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 1:47
 * @Version 1.0
 */
public class SortMeta {
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序方式
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
