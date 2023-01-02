package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type ObjectStatus = 'Exists' | 'NotExists' | 'Deleted';
 * </pre>
 */
@JsonDeserialize(using = ObjectStatusDeserializer.class)
@JsonSerialize(using = ObjectStatusSerializer.class)
public enum ObjectStatus {
    EXISTS {
        @Override
        public String getCode() {
            return "Exists";
        }
    },
    NOT_EXISTS {
        @Override
        public String getCode() {
            return "NotExists";
        }
    },
    DELETED {
        @Override
        public String getCode() {
            return "Deleted";
        }
    };

    public abstract String getCode();
}
