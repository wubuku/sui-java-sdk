package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;
import java.util.Map;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, Eq, PartialEq)]
 * #[serde(tag = "dataType", rename_all = "camelCase", rename = "RawData")]
 * pub enum SuiRawData {
 *     // Manually handle generic schema generation
 *     MoveObject(SuiRawMoveObject),
 *     Package(SuiRawMovePackage),
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiRawDataDeserializer.class)
public interface SuiRawData {
    SuiDataType getDataType();

    class MoveObject extends com.github.wubuku.sui.bean.SuiRawMoveObject implements SuiRawData {
        private SuiDataType dataType;

        public MoveObject() {
        }

        public MoveObject(SuiDataType dataType) {
            this.dataType = dataType;
        }

        public MoveObject(String type, Boolean hasPublicTransfer, BigInteger version, String bcsBytes, SuiDataType dataType) {
            super(type, hasPublicTransfer, version, bcsBytes);
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
            return "SuiRawData.SuiMoveObject{" +
                    "dataType=" + dataType + '\'' +
                    ", type='" + getType() + '\'' +
                    ", hasPublicTransfer=" + getHasPublicTransfer() +
                    ", version=" + getVersion() +
                    ", bcsBytes='" + getBcsBytes() + '\'' +
                    '}';
        }
    }

    class Package extends com.github.wubuku.sui.bean.SuiRawMovePackage implements SuiRawData {
        private SuiDataType dataType;

        public Package(SuiDataType dataType) {
            this.dataType = dataType;
        }

        public Package(String id, Map<String, String> moduleMap, SuiDataType dataType) {
            super(id, moduleMap);
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
            return "SuiRawData.SuiMovePackage{" +
                    "dataType=" + dataType + '\'' +
                    ", id='" + getId() + '\'' +
                    ", moduleMap=" + getModuleMap() +
                    '}';
        }
    }
}
