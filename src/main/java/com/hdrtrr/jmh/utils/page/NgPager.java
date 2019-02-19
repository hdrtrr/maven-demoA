package com.hdrtrr.jmh.utils.page;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  ���� 1:46
 * @Version 1.0
 */
public class NgPager {

    /**
     * ��ҳ��ʼ����
     */
    private int first = 0;
    /**
     * ��ҳ�ĸ���
     */
    private int rows = 10;
    /**
     * �����ֶ�
     */
    private String sortField;
    /**
     * �����ֶΣ�1��ʾasc��-1��ʾdesc
     */
    private int sortOrder;
    /**
     * ȫ�������ֶ�
     */
    private Object globalFilter;
    /**
     * ������������
     */
    private SortMeta[] multiSortMeta;
    /**
     * ��ѯ����
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
