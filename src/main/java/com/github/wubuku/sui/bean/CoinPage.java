package com.github.wubuku.sui.bean;

import java.util.List;

public class CoinPage extends Page<Coin, String> {

    public CoinPage() {
    }

    public CoinPage(List<Coin> data, String nextCursor) {
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
