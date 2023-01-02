package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiData = { dataType: ObjectType } & (
 *   | SuiMoveObject
 *   | SuiMovePackage
 * );
 * </pre>
 */
@JsonDeserialize(using = SuiDataDeserializer.class)
public interface SuiData {
    ObjectType getDataType();

    class SuiMoveObject extends com.github.wubuku.sui.bean.SuiMoveObject implements SuiData {
        private ObjectType dataType;

        public SuiMoveObject() {
        }

        @Override
        public ObjectType getDataType() {
            return dataType;
        }

        public void setDataType(ObjectType dataType) {
            this.dataType = dataType;
        }

        @Override
        public String toString() {
            return "SuiMoveObject{" +
                    "dataType=" + dataType +
                    ", type='" + getType() + '\'' +
                    ", fields=" + getFields() +
                    ", hasPublicTransfer=" + getHasPublicTransfer() +
                    '}';
        }
    }

    class SuiMovePackage extends com.github.wubuku.sui.bean.SuiMovePackage implements SuiData {
        private ObjectType dataType;

        public SuiMovePackage() {
        }

        @Override
        public ObjectType getDataType() {
            return dataType;
        }

        public void setDataType(ObjectType dataType) {
            this.dataType = dataType;
        }

        @Override
        public String toString() {
            return "SuiMovePackage{" +
                    "dataType=" + dataType +
                    ", disassembled=" + getDisassembled() +
                    '}';
        }
    }
}
