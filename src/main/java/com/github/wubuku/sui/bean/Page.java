package com.github.wubuku.sui.bean;

import java.util.List;

public class Page<T, C> {
    private List<T> data;
    private C nextCursor;

    public Page() {
    }

    public Page(List<T> data, C nextCursor) {
        this.data = data;
        this.nextCursor = nextCursor;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public C getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(C nextCursor) {
        this.nextCursor = nextCursor;
    }

    @Override
    public String toString() {
        return "Page{" +
                "data=" + data +
                ", nextCursor=" + nextCursor +
                '}';
    }
}
