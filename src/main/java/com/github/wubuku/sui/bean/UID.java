package com.github.wubuku.sui.bean;

public class UID {
    private String id;

    public UID() {
    }

    public UID(String id) {
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
        return "UID{" +
                "id='" + id + '\'' +
                '}';
    }
}
