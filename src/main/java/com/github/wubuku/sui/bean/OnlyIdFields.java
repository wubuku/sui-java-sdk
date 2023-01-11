package com.github.wubuku.sui.bean;

public class OnlyIdFields {
    private String id;

    public OnlyIdFields() {
    }

    public OnlyIdFields(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OnlyIdFields{" +
                "id='" + id + '\'' +
                '}';
    }
}
