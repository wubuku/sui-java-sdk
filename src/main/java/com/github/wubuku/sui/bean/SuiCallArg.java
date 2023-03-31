package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Debug, Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(tag = "type", rename_all = "camelCase")]
 * pub enum SuiCallArg {
 *     // Needs to become an Object Ref or Object ID, depending on object type
 *     Object(SuiObjectArg),
 *     // pure value, bcs encoded
 *     Pure(SuiPureValue),
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiCallArgDeserializer.class)
public interface SuiCallArg {
    String getType();

    interface Object extends SuiCallArg {
        default String getType() {
            return "object";
        }

        class ImmOrOwnedObject extends SuiObjectArg.ImmOrOwnedObject implements SuiCallArg.Object {
            public ImmOrOwnedObject() {
            }

            public ImmOrOwnedObject(String objectId, BigInteger version, String digest) {
                super(objectId, version, digest);
            }

        }

        class SharedObject extends SuiObjectArg.SharedObject implements SuiCallArg.Object {
            public SharedObject() {
            }

            public SharedObject(String objectId, BigInteger initialSharedVersion, Boolean mutable) {
                super(objectId, initialSharedVersion, mutable);
            }
        }
    }

    class Pure extends SuiPureValue implements SuiCallArg {
        public Pure() {
        }

        public Pure(String valueType, SuiJsonValue value) {
            super(valueType, value);
        }

        @Override
        public String getType() {
            return "pure";
        }

    }
}
