package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, Eq, PartialEq)]
 * #[serde(tag = "dataType", rename_all = "camelCase", rename = "Data")]
 * pub enum SuiParsedData {
 *     // Manually handle generic schema generation
 *     MoveObject(SuiParsedMoveObject),
 *     Package(SuiMovePackage),
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiParsedDataDeserializer.class)
public interface SuiParsedData {
    SuiDataType getDataType();

    class MoveObject extends com.github.wubuku.sui.bean.SuiMoveObject<ObjectContentFields> implements SuiParsedData {
        private SuiDataType dataType;

        public MoveObject() {
        }

        public MoveObject(String type,
                          ObjectContentFields fields,
                          Boolean hasPublicTransfer,
                          SuiDataType dataType) {
            super(type, fields, hasPublicTransfer);
            this.dataType = dataType;
        }

        @Override
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

    class Package extends com.github.wubuku.sui.bean.SuiMovePackage implements SuiParsedData {
        private SuiDataType dataType;

        public Package() {
        }

        public Package(MovePackageContent disassembled, SuiDataType dataType) {
            super(disassembled);
            this.dataType = dataType;
        }

        @Override
        public SuiDataType getDataType() {
            return dataType;
        }

        public void setDataType(SuiDataType dataType) {
            this.dataType = dataType;
        }

        @Override
        public String toString() {
            return "Package{" +
                    "dataType=" + dataType +
                    ", disassembled=" + getDisassembled() +
                    '}';
        }
    }
}
