package com.hdrtrr.jmh.utils.page;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 12:00
 * 分页查询出来的数据封装对象
 * @Version 1.0
 */
public class NgData<T> {

    /**
     * 查出来的数据对象
     */
    private List<T> data;
    /**
     * 不清楚
     */
    private int draw = 1;
    /**
     * 总行数
     */
    private Long totalRecords = 0L;
    /**
     * 不清楚
     */
    private Long filteredValue = 0L;
    /**
     * 不清楚
     */
    private Integer flag;
    /**
     * 错误信息
     */
    private String error = "";

    public NgData(Page<T> dataPage, NgPager pager) {
        this.data = dataPage.getContent();
        if (this.data != null) {
            this.totalRecords = dataPage.getTotalElements();
            this.filteredValue = (long) this.data.size();
        }
    }

    public NgData(Page<T> dataPage, NgPager pager, Integer flag) {
        this.data = dataPage.getContent();
        if (this.data != null) {
            this.totalRecords = dataPage.getTotalElements();
            this.filteredValue = (long) this.data.size();
        }
        this.flag = flag;
    }

    public NgData(List<T> aaData, Long iTotalRecords, Long iTotalDisplayRecords, int sEcho) {
        this.data = aaData;
        this.totalRecords = iTotalRecords;
        this.filteredValue = iTotalDisplayRecords;
        this.draw = sEcho;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Long getFilteredValue() {
        return filteredValue;
    }

    public void setFilteredValue(Long filteredValue) {
        this.filteredValue = filteredValue;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
