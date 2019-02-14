package com.hdrtrr.jmh.utils.page;

/**
 * @Author hdrtrr jmh
 * @Date 2019/2/14 0014  下午 1:48
 * @Version 1.0
 */
public class NgFilter {

    /**
     * 要查询的值
     */
    private String value;
    /**
     * 匹配模式
     */
    private String matchMode;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }
}
