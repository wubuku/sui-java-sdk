package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Clone, Serialize, Deserialize, JsonSchema, Debug)]
 * #[serde(rename_all = "camelCase")]
 * pub struct DynamicFieldInfo {
 *     pub name: DynamicFieldName,
 *     #[schemars(with = "Base58")]
 *     #[serde_as(as = "Readable<Base58, _>")]
 *     pub bcs_name: Vec<u8>,
 *     pub type_: DynamicFieldType,
 *     pub object_type: String,
 *     pub object_id: ObjectID,
 *     pub version: SequenceNumber,
 *     pub digest: ObjectDigest,
 * }
 * </pre>
 */
public class DynamicFieldInfo<NT> {
    private DynamicFieldName<NT> name;
    private String bcsName;
    private String type;
    private String objectType;
    private String objectId;
    private BigInteger version;
    private String digest;

    public DynamicFieldInfo() {
    }

    public DynamicFieldName getName() {
        return name;
    }

    public void setName(DynamicFieldName name) {
        this.name = name;
    }

    public String getBcsName() {
        return bcsName;
    }

    public void setBcsName(String bcsName) {
        this.bcsName = bcsName;
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
                "name=" + name +
                ", bcsName='" + bcsName + '\'' +
                ", type='" + type + '\'' +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", version=" + version +
                ", digest='" + digest + '\'' +
                '}';
    }
}
