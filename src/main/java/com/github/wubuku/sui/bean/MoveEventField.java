package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 *
 * export type MoveEventField = {
 *   path: string;
 *   value: SuiJsonValue;
 * };
 * </pre>
 */
public class MoveEventField {
    private String path;
    private SuiJsonValue value;

    public MoveEventField() {
    }

    public MoveEventField(String path, SuiJsonValue value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public SuiJsonValue getValue() {
        return value;
    }

    public void setValue(SuiJsonValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MoveEventField{" +
                "path='" + path + '\'' +
                ", value=" + value +
                '}';
    }
}
