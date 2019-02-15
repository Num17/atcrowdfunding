package com.jiuhe.atcrowdfunding.bean;

import java.util.List;

public class Page<T> {

    public static final Page EMPTY = null;

    private Integer pageNumber;
    private Integer pageSize;

    private int count;
    private int pageCount;
    private List<T> data;

    public Page() {
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", count=" + count +
                ", pageCount=" + pageCount +
                ", data=" + data +
                '}';
    }
}
