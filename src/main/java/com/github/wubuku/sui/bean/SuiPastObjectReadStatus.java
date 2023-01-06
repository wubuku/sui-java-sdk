package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = SuiPastObjectReadStatusDeserializer.class)
@JsonSerialize(using = SuiPastObjectReadStatusSerializer.class)
public enum SuiPastObjectReadStatus {
    VERSION_FOUND {
        @Override
        public String getCode() {
            return "VersionFound";
        }
    },
    OBJECT_NOT_EXISTS {
        @Override
        public String getCode() {
            return "ObjectNotExists";
        }
    },
    OBJECT_DELETED {
        @Override
        public String getCode() {
            return "ObjectDeleted";
        }
    },
    VERSION_NOT_FOUND {
        @Override
        public String getCode() {
            return "VersionNotFound";
        }
    },
    VERSION_TOO_HIGH {
        @Override
        public String getCode() {
            return "VersionTooHigh";
        }
    };

    public abstract String getCode();
}