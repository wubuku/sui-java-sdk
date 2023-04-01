package com.github.wubuku.sui.bean;

public class SuiMoveObjectResponse<C> extends AbstractSuiObjectResponse<SuiObjectData<SuiMoveObjectResponse.MoveObject<C>>> {

    @Override
    public String toString() {
        return "SuiObjectResponse{" +
                "data=" + data +
                ", error=" + error +
                '}';
    }

    public static class MoveObject<C> extends com.github.wubuku.sui.bean.SuiMoveObject<C> {
        private SuiDataType dataType;

        public MoveObject() {
        }

        public MoveObject(String type,
                          C fields,
                          Boolean hasPublicTransfer,
                          SuiDataType dataType) {
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
            return "MoveObject{" +
                    "dataType=" + dataType +
                    ", type='" + getType() + '\'' +
                    ", fields=" + getFields() +
                    ", hasPublicTransfer=" + getHasPublicTransfer() +
                    '}';
        }


    }

}
