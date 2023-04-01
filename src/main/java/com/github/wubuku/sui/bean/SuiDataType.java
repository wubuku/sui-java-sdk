package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type ObjectType = 'moveObject' | 'package';
 * </pre>
 */
@JsonDeserialize(using = SuiDataTypeDeserializer.class)
@JsonSerialize(using = SuiDataTypeSerializer.class)
public enum SuiDataType {
    MOVE_OBJECT {
        @Override
        public String getCode() {
            return "moveObject";
        }
    },
    PACKAGE {
        @Override
        public String getCode() {
            return "package";
        }
    };

    public abstract String getCode();
}
