package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type ExecutionStatusType = 'success' | 'failure';
 * </pre>
 */
@JsonDeserialize(using = ExecutionStatusTypeDeserializer.class)
@JsonSerialize(using = ExecutionStatusTypeSerializer.class)
public enum ExecutionStatusType {
    SUCCESS {
        @Override
        public String getCode() {
            return "success";
        }
    },
    FAILURE {
        @Override
        public String getCode() {
            return "failure";
        }
    };

    public abstract String getCode();
}
