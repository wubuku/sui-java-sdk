package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Debug, Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(tag = "objectType", rename_all = "camelCase")]
 * pub enum SuiObjectArg {
 *     // A Move object, either immutable, or owned mutable.
 *     #[serde(rename_all = "camelCase")]
 *     ImmOrOwnedObject {
 *         object_id: ObjectID,
 *         version: SequenceNumber,
 *         digest: ObjectDigest,
 *     },
 *     // A Move object that's shared.
 *     // SharedObject::mutable controls whether caller asks for a mutable reference to shared object.
 *     #[serde(rename_all = "camelCase")]
 *     SharedObject {
 *         object_id: ObjectID,
 *         initial_shared_version: SequenceNumber,
 *         mutable: bool,
 *     },
 * }
 * </pre>
 */
public abstract class SuiObjectArg {

    public abstract String getObjectType();

    public static class ImmOrOwnedObject extends SuiObjectArg {
        private String objectId;
        private BigInteger version;
        private String digest;

        public ImmOrOwnedObject(String objectId, BigInteger version, String digest) {
            this.objectId = objectId;
            this.version = version;
            this.digest = digest;
        }

        public ImmOrOwnedObject() {
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public BigInteger getVersion() {
            return version;
        }

        public void setVersion(BigInteger version) {
            this.version = version;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        @Override
        public String toString() {
            return "ImmOrOwnedObject{" +
                    "objectId='" + objectId + '\'' +
                    ", version=" + version +
                    ", digest='" + digest + '\'' +
                    '}';
        }

        @Override
        public String getObjectType() {
            return "immOrOwnedObject";
        }
    }

    public static class SharedObject extends SuiObjectArg {
        private String objectId;
        private BigInteger initialSharedVersion;
        private Boolean mutable;

        public SharedObject() {
        }

        public SharedObject(String objectId, BigInteger initialSharedVersion, Boolean mutable) {
            this.objectId = objectId;
            this.initialSharedVersion = initialSharedVersion;
            this.mutable = mutable;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public BigInteger getInitialSharedVersion() {
            return initialSharedVersion;
        }

        public void setInitialSharedVersion(BigInteger initialSharedVersion) {
            this.initialSharedVersion = initialSharedVersion;
        }

        public Boolean getMutable() {
            return mutable;
        }

        public void setMutable(Boolean mutable) {
            this.mutable = mutable;
        }

        @Override
        public String toString() {
            return "SharedObject{" +
                    "objectId='" + objectId + '\'' +
                    ", initialSharedVersion=" + initialSharedVersion +
                    ", mutable=" + mutable +
                    '}';
        }

        @Override
        public String getObjectType() {
            return "sharedObject";
        }
    }
}
