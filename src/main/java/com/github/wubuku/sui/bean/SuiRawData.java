package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, Eq, PartialEq)]
 * #[serde(tag = "dataType", rename_all = "camelCase", rename = "Data")]
 * pub enum SuiRawData {
 *     // Manually handle generic schema generation
 *     MoveObject(SuiRawMoveObject),
 *     Package(SuiRawMovePackage),
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiRawDataDeserializer.class)
public interface SuiRawData {
    ObjectType getDataType();

    class SuiMoveObject extends com.github.wubuku.sui.bean.SuiRawMoveObject implements SuiRawData {
        private ObjectType dataType;

        public SuiMoveObject() {
        }

        public SuiMoveObject(ObjectType dataType) {
            this.dataType = dataType;
        }

        public SuiMoveObject(String type, Boolean hasPublicTransfer, Long version, String bcsBytes, ObjectType dataType) {
            super(type, hasPublicTransfer, version, bcsBytes);
            this.dataType = dataType;
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
            return "SuiRawData.SuiMoveObject{" +
                    "dataType=" + dataType + '\'' +
                    ", type='" + getType() + '\'' +
                    ", hasPublicTransfer=" + getHasPublicTransfer() +
                    ", version=" + getVersion() +
                    ", bcsBytes='" + getBcsBytes() + '\'' +
                    '}';
        }
    }

    class SuiMovePackage extends com.github.wubuku.sui.bean.SuiRawMovePackage implements SuiRawData {
        private ObjectType dataType;

        public SuiMovePackage(ObjectType dataType) {
            this.dataType = dataType;
        }

        public SuiMovePackage(String id, Map<String, String> moduleMap, ObjectType dataType) {
            super(id, moduleMap);
            this.dataType = dataType;
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
            return "SuiRawData.SuiMovePackage{" +
                    "dataType=" + dataType + '\'' +
                    ", id='" + getId() + '\'' +
                    ", moduleMap=" + getModuleMap() +
                    '}';
        }
    }
}
