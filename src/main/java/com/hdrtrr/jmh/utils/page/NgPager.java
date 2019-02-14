package com.hdrtrr.jmh.utils.page;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 1:46
 * @Version 1.0
 */
public class NgPager {

    /**
     * 分页起始个数
     */
    private int first = 0;
    /**
     * 分页的个数
     */
    private int rows = 10;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序字段，1表示asc，-1表示desc
     */
    private int sortOrder;
    /**
     * 全局搜索字段
     */
    private Object globalFilter;
    /**
     * 多项排序条件
     */
    private SortMeta[] multiSortMeta;
    /**
     * 查询条件
     */
    private Map<String, NgFilter> filters;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Object getGlobalFilter() {
        return globalFilter;
    }

    public void setGlobalFilter(Object globalFilter) {
        this.globalFilter = globalFilter;
    }

    public SortMeta[] getMultiSortMeta() {
        return multiSortMeta;
    }

    public void setMultiSortMeta(SortMeta[] multiSortMeta) {
        this.multiSortMeta = multiSortMeta;
    }

    public Map<String, NgFilter> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, NgFilter> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "NgPager{" +
                "first=" + first +
                ", rows=" + rows +
                ", sortField='" + sortField + '\'' +
                ", sortOrder=" + sortOrder +
                ", globalFilter=" + globalFilter +
                ", multiSortMeta=" + Arrays.toString(multiSortMeta) +
                ", filters=" + filters +
                '}';
    }
}
