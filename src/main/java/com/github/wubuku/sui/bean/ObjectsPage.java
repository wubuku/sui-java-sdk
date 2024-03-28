package com.github.wubuku.sui.bean;

import java.util.List;

public class ObjectsPage extends Page<SuiObjectResponse, String> {

    public ObjectsPage() {
    }

    public ObjectsPage(List<SuiObjectResponse> data, String nextCursor) {
        super(data, nextCursor);
    }

    @Override
    public String toString() {
        return "CoinPage{" +
                "data=" + getData() +
                ", nextCursor=" + getNextCursor() +
                ", hasNextPage=" + getHasNextPage() +
                '}';
    }
}
