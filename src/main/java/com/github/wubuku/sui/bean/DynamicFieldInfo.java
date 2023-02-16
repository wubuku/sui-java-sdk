package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Serialize, Deserialize, JsonSchema, Ord, PartialOrd, Eq, PartialEq, Debug)]
 * #[serde(rename_all = "camelCase")]
 * pub struct DynamicFieldInfo {
 *     pub name: String,
 *     pub type_: DynamicFieldType,
 *     pub object_type: String,
 *     pub object_id: ObjectID,
 *     pub version: SequenceNumber,
 *     pub digest: ObjectDigest,
 * }
 * </pre>
 */
public class DynamicFieldInfo {
    private String name;
    private String type;
    private String objectType;
    private String objectId;
    private BigInteger version;
    private String digest;

    public DynamicFieldInfo() {
    }

    public DynamicFieldInfo(String name, String type, String objectType, String objectId, BigInteger version, String digest) {
        this.name = name;
        this.type = type;
        this.objectType = objectType;
        this.objectId = objectId;
        this.version = version;
        this.digest = digest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "DynamicFieldInfo{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", version=" + version +
                ", digest='" + digest + '\'' +
                '}';
    }
}
