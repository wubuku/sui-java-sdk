package com.github.wubuku.sui.bean;

public class AbstractSuiObjectResponse<D> {
    protected D data;
    protected Object error; //SuiObjectResponseError

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
