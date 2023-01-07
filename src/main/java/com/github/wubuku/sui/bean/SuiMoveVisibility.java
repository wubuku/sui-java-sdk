package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub enum SuiMoveVisibility {
 *     Private,
 *     Public,
 *     Friend,
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiMoveVisibilityDeserializer.class)
@JsonSerialize(using = SuiMoveVisibilitySerializer.class)
public enum SuiMoveVisibility {
    PRIVATE {
        @Override
        public String getCode() {
            return "Private";
        }
    },
    PUBLIC {
        @Override
        public String getCode() {
            return "Public";
        }
    },
    FRIEND {
        @Override
        public String getCode() {
            return "Friend";
        }
    };

    public abstract String getCode();
}
