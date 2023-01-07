package com.github.wubuku.sui.bean;

public abstract class AbstractGetObjectDataResponse<D> {

    private ObjectStatus status;
    private D details;

    public AbstractGetObjectDataResponse() {
    }

    public AbstractGetObjectDataResponse(ObjectStatus status, D details) {
        this.status = status;
        this.details = details;
    }

    public ObjectStatus getStatus() {
        return status;
    }

    public void setStatus(ObjectStatus status) {
        this.status = status;
    }

    public D getDetails() {
        return details;
    }

    public void setDetails(D details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "AbstractGetObjectDataResponse{" +
                "status=" + status +
                ", details=" + details +
                '}';
    }
}
