package com.github.wubuku.sui.bean;

public class MoveStruct<T> {
    private String type;
    private T fields;

    public MoveStruct() {
    }

    public MoveStruct(String type, T fields) {
        this.type = type;
        this.fields = fields;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getFields() {
        return fields;
    }

    public void setFields(T fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "MoveObject{" +
                "type='" + type + '\'' +
                ", fields=" + fields +
                '}';
    }
}
