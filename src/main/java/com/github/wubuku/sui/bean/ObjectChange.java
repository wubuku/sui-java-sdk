package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema, PartialEq, Eq)]
 * #[serde(rename_all = "camelCase", tag = "type")]
 * pub enum ObjectChange {
 *     /// Module published
 *     #[serde(rename_all = "camelCase")]
 *     Published {
 *     //...
 *     },
 *     /// Transfer objects to new address / wrap in another object
 *     #[serde(rename_all = "camelCase")]
 *     Transferred {
 *     //...
 *     },
 *     /// Object mutated.
 *     #[serde(rename_all = "camelCase")]
 *     Mutated {
 *     //...
 *     },
 *     /// Delete object
 *     #[serde(rename_all = "camelCase")]
 *     Deleted {
 *     //...
 *     },
 *     /// Wrapped object
 *     #[serde(rename_all = "camelCase")]
 *     Wrapped {
 *     //...
 *     },
 *     /// New object creation
 *     #[serde(rename_all = "camelCase")]
 *     Created {
 *     //...
 *     },
 * }
 * </pre>
 */
@JsonDeserialize(using = ObjectChangeDeserializer.class)
public abstract class ObjectChange {
    protected String packageId;
    protected BigInteger version;
    protected String digest;
    protected String[] modules;
    protected String sender;
    protected ObjectOwner recipient;
    protected String objectType;
    protected String objectId;
    protected ObjectOwner owner;
    protected BigInteger previousVersion;

    public abstract String getType();

    @JsonDeserialize() // using JsonDeserializer.None.class
    static class TempObjectChange extends ObjectChange {
        private String type;

        public String getPackageId() {
            return packageId;
        }

        public void setPackageId(String packageId) {
            this.packageId = packageId;
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

        public String[] getModules() {
            return modules;
        }

        public void setModules(String[] modules) {
            this.modules = modules;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public ObjectOwner getRecipient() {
            return recipient;
        }

        public void setRecipient(ObjectOwner recipient) {
            this.recipient = recipient;
        }

        public String getObjectType() {
            return objectType;
        }

        public void setObjectType(String objectType) {
            this.objectType = objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public ObjectOwner getOwner() {
            return owner;
        }

        public void setOwner(ObjectOwner owner) {
            this.owner = owner;
        }

        public BigInteger getPreviousVersion() {
            return previousVersion;
        }

        public void setPreviousVersion(BigInteger previousVersion) {
            this.previousVersion = previousVersion;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    /*
     *     Published {
     *         package_id: ObjectID,
     *         version: SequenceNumber,
     *         digest: ObjectDigest,
     *         modules: Vec<String>,
     *     },
     */
    public static class Published extends ObjectChange {
        public Published() {
        }

        public Published(String packageId, BigInteger version, String digest, String[] modules) {
            this.packageId = packageId;
            this.version = version;
            this.digest = digest;
            this.modules = modules;
        }

        @Override
        public String getType() {
            return "published";
        }

        @Override
        public String toString() {
            return "Published{" +
                    "packageId='" + packageId + '\'' +
                    ", version=" + version +
                    ", digest='" + digest + '\'' +
                    ", modules=" + Arrays.toString(modules) +
                    '}';
        }

        public String getPackageId() {
            return packageId;
        }

        public BigInteger getVersion() {
            return version;
        }

        public String getDigest() {
            return digest;
        }

        public String[] getModules() {
            return modules;
        }
    }

    /*
     *   Transferred {
     *         sender: SuiAddress,
     *         recipient: Owner,
     *         #[schemars(with = "String")]
     *         #[serde_as(as = "SuiStructTag")]
     *         object_type: StructTag,
     *         object_id: ObjectID,
     *         version: SequenceNumber,
     *         digest: ObjectDigest,
     *     },
     */
    public static class Transferred extends ObjectChange {
        public Transferred() {
        }

        public Transferred(String sender, ObjectOwner recipient, String objectType, String objectId, BigInteger version, String digest) {
            this.sender = sender;
            this.recipient = recipient;
            this.objectType = objectType;
            this.objectId = objectId;
            this.version = version;
            this.digest = digest;
        }

        @Override
        public String getType() {
            return "transferred";
        }

        @Override
        public String toString() {
            return "Transferred{" +
                    "version=" + version +
                    ", digest='" + digest + '\'' +
                    ", sender='" + sender + '\'' +
                    ", recipient=" + recipient +
                    ", objectType='" + objectType + '\'' +
                    ", objectId='" + objectId + '\'' +
                    '}';
        }

        public String getSender() {
            return sender;
        }

        public ObjectOwner getRecipient() {
            return recipient;
        }

        public String getObjectType() {
            return objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public BigInteger getVersion() {
            return version;
        }

        public String getDigest() {
            return digest;
        }

    }

    /*
     *     Mutated {
     *         sender: SuiAddress,
     *         owner: Owner,
     *         #[schemars(with = "String")]
     *         #[serde_as(as = "SuiStructTag")]
     *         object_type: StructTag,
     *         object_id: ObjectID,
     *         version: SequenceNumber,
     *         previous_version: SequenceNumber,
     *         digest: ObjectDigest,
     *     },
     */
    public static class Mutated extends ObjectChange {
        public Mutated() {
        }

        public Mutated(String sender, ObjectOwner owner, String objectType, String objectId, BigInteger version, BigInteger previousVersion, String digest) {
            this.sender = sender;
            this.owner = owner;
            this.objectType = objectType;
            this.objectId = objectId;
            this.version = version;
            this.previousVersion = previousVersion;
            this.digest = digest;
        }

        @Override
        public String getType() {
            return "mutated";
        }

        @Override
        public String toString() {
            return "Mutated{" +
                    "version=" + version +
                    ", digest='" + digest + '\'' +
                    ", sender='" + sender + '\'' +
                    ", objectType='" + objectType + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", owner=" + owner +
                    ", previousVersion=" + previousVersion +
                    '}';
        }

        public String getSender() {
            return sender;
        }

        public ObjectOwner getOwner() {
            return owner;
        }

        public String getObjectType() {
            return objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public BigInteger getVersion() {
            return version;
        }

        public BigInteger getPreviousVersion() {
            return previousVersion;
        }

        public String getDigest() {
            return digest;
        }

    }

    /*
     *     Deleted {
     *         sender: SuiAddress,
     *         #[schemars(with = "String")]
     *         #[serde_as(as = "SuiStructTag")]
     *         object_type: StructTag,
     *         object_id: ObjectID,
     *         version: SequenceNumber,
     *     },
     */
    public static class Deleted extends ObjectChange {
        public Deleted() {
        }

        public Deleted(String sender, String objectType, String objectId, BigInteger version) {
            this.sender = sender;
            this.objectType = objectType;
            this.objectId = objectId;
            this.version = version;
        }

        @Override
        public String getType() {
            return "deleted";
        }

        @Override
        public String toString() {
            return "Deleted{" +
                    "version=" + version +
                    ", sender='" + sender + '\'' +
                    ", objectType='" + objectType + '\'' +
                    ", objectId='" + objectId + '\'' +
                    '}';
        }

        public String getSender() {
            return sender;
        }

        public String getObjectType() {
            return objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public BigInteger getVersion() {
            return version;
        }


    }

    /*
     *     Wrapped {
     *         sender: SuiAddress,
     *         #[schemars(with = "String")]
     *         #[serde_as(as = "SuiStructTag")]
     *         object_type: StructTag,
     *         object_id: ObjectID,
     *         version: SequenceNumber,
     *     },
     */
    public static class Wrapped extends ObjectChange {
        public Wrapped() {
        }

        public Wrapped(String sender, String objectType, String objectId, BigInteger version) {
            this.sender = sender;
            this.objectType = objectType;
            this.objectId = objectId;
            this.version = version;
        }

        @Override
        public String getType() {
            return "wrapped";
        }

        @Override
        public String toString() {
            return "Wrapped{" +
                    "version=" + version +
                    ", sender='" + sender + '\'' +
                    ", objectType='" + objectType + '\'' +
                    ", objectId='" + objectId + '\'' +
                    '}';
        }

        public String getSender() {
            return sender;
        }

        public String getObjectType() {
            return objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public BigInteger getVersion() {
            return version;
        }

    }

    /*
     *     Created {
     *         sender: SuiAddress,
     *         owner: Owner,
     *         #[schemars(with = "String")]
     *         #[serde_as(as = "SuiStructTag")]
     *         object_type: StructTag,
     *         object_id: ObjectID,
     *         version: SequenceNumber,
     *         digest: ObjectDigest,
     *     },
     */
    public static class Created extends ObjectChange {
        public Created() {
        }

        public Created(String sender, ObjectOwner owner, String objectType, String objectId, BigInteger version, String digest) {
            this.sender = sender;
            this.owner = owner;
            this.objectType = objectType;
            this.objectId = objectId;
            this.version = version;
            this.digest = digest;
        }

        @Override
        public String getType() {
            return "created";
        }

        @Override
        public String toString() {
            return "Created{" +
                    "version=" + version +
                    ", digest='" + digest + '\'' +
                    ", sender='" + sender + '\'' +
                    ", objectType='" + objectType + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", owner=" + owner +
                    '}';
        }

        public String getSender() {
            return sender;
        }

        public ObjectOwner getOwner() {
            return owner;
        }

        public String getObjectType() {
            return objectType;
        }

        public String getObjectId() {
            return objectId;
        }

        public BigInteger getVersion() {
            return version;
        }

        public String getDigest() {
            return digest;
        }


    }
}
