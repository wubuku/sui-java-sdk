package com.github.wubuku.sui.bean;

import java.util.List;

public class DynamicFieldPage<NT> extends Page<DynamicFieldInfo<NT>, String> {
    public DynamicFieldPage() {
    }

    public DynamicFieldPage(List<DynamicFieldInfo<NT>> data, String nextCursor) {
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
