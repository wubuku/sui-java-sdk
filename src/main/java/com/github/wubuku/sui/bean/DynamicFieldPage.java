package com.github.wubuku.sui.bean;

import java.util.List;

public class DynamicFieldPage extends Page<DynamicFieldInfo, String> {
    public DynamicFieldPage() {
    }

    public DynamicFieldPage(List<DynamicFieldInfo> data, String nextCursor) {
        super(data, nextCursor);
    }

    @Override
    public String toString() {
        return "DynamicFieldPage{" +
                "data=" + getData() +
                ", nextCursor=" + getNextCursor() +
                "}";
    }
}
