package com.xu.spring.test.common.query;

/**
 * @author xu
 * @date 2020/1/1 12:40
 */
public class BaseQuery {
    private int currentPage = 1;
    private int pageSize = 10;
    private int limit;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getLimit() {
        return (currentPage - 1) * pageSize;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
