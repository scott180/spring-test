package com.xu.spring.test.common;

/**
 * @author xu
 * @date 2020/1/1 13:11
 */
public class Page<T> {
    private int currentPage;
    private int total;
    private T content;

    public Page(int currentPage, int total, T content) {
        this.currentPage = currentPage;
        this.total = total;
        this.content = content;
    }

}
