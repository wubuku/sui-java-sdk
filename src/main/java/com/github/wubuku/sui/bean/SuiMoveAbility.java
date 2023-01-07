package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub enum SuiMoveAbility {
 *     Copy,
 *     Drop,
 *     Store,
 *     Key,
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiMoveAbilityDeserializer.class)
@JsonSerialize(using = SuiMoveAbilitySerializer.class)
public enum SuiMoveAbility {
    COPY {
        @Override
        public String getCode() {
            return "Copy";
        }
    },
    DROP {
        @Override
        public String getCode() {
            return "Drop";
        }
    },
    STORE {
        @Override
        public String getCode() {
            return "Store";
        }
    },
    KEY {
        @Override
        public String getCode() {
            return "Key";
        }
    };

    public abstract String getCode();
}
