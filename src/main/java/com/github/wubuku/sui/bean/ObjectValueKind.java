package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub enum ObjectValueKind {
 *     ByImmutableReference,
 *     ByMutableReference,
 *     ByValue,
 * }
 * </pre>
 */
@JsonDeserialize(using = ObjectValueKindDeserializer.class)
@JsonSerialize(using = ObjectValueKindSerializer.class)
public enum ObjectValueKind {
    BY_IMMUTABLE_REFERENCE {
        @Override
        public String getCode() {
            return "ByImmutableReference";
        }
    },
    BY_MUTABLE_REFERENCE {
        @Override
        public String getCode() {
            return "ByMutableReference";
        }
    },
    BY_VALUE {
        @Override
        public String getCode() {
            return "ByValue";
        }
    };

    public abstract String getCode();
}
