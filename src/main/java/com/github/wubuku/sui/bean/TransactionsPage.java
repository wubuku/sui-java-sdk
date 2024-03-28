package com.github.wubuku.sui.bean;

public class TransactionsPage extends Page<String, String> {

    public TransactionsPage() {
    }

    public TransactionsPage(java.util.List<String> data, String nextCursor) {
        super(data, nextCursor);
    }

    @Override
    public String toString() {
        return "TransactionsPage{" +
                "data=" + getData() +
                ", nextCursor=" + getNextCursor() +
                ", hasNextPage=" + getHasNextPage() +
                '}';
    }

}
