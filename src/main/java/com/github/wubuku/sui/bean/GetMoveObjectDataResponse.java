package com.github.wubuku.sui.bean;

public class GetMoveObjectDataResponse<T> extends AbstractGetObjectDataResponse<GetMoveObjectDataResponse.Details<T>> {
    @Override
    public String toString() {
        return "GetMoveObjectDataResponse{" +
                "status=" + getStatus() +
                ", details=" + getDetails() +
                "}";
    }

    public static class Details<T> extends com.github.wubuku.sui.bean.AbstractSuiObject<MoveObject<T>> {
        @Override
        public String toString() {
            return "GetMoveObjectDataResponse.Details{" +
                    "data=" + getData() +
                    ", owner=" + getOwner() +
                    ", previousTransaction='" + getPreviousTransaction() + '\'' +
                    ", storageRebate=" + getStorageRebate() +
                    ", reference=" + getReference() +
                    "}";
        }
    }

    public static class MoveObject<T> extends com.github.wubuku.sui.bean.SuiMoveObject<T> {
        private SuiDataType dataType;

        public MoveObject() {
        }

        public MoveObject(String type, T fields, Boolean hasPublicTransfer, SuiDataType dataType) {
            super(type, fields, hasPublicTransfer);
            this.dataType = dataType;
        }

        public SuiDataType getDataType() {
            return dataType;
        }

        public void setDataType(SuiDataType dataType) {
            this.dataType = dataType;
        }

        @Override
        public String toString() {
            return "GetMoveObjectDataResponse.MoveObject{" +
                    "dataType=" + dataType +
                    ", type='" + getType() + '\'' +
                    ", fields=" + getFields() +
                    ", hasPublicTransfer=" + getHasPublicTransfer() +
                    '}';
        }
    }
}
