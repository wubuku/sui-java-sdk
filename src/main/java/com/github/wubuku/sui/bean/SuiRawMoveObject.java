package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, Eq, PartialEq)]
 * #[serde(rename = "RawMoveObject")]
 * pub struct SuiRawMoveObject {
 *     #[serde(rename = "type")]
 *     pub type_: String,
 *     pub has_public_transfer: bool,
 *     pub version: SequenceNumber,
 *     #[serde_as(as = "Base64")]
 *     #[schemars(with = "Base64")]
 *     pub bcs_bytes: Vec<u8>,
 * }
 * </pre>
 */
public class SuiRawMoveObject {
    private String type;
    @JsonProperty("has_public_transfer")
    private Boolean hasPublicTransfer;
    private BigInteger version;
    @JsonProperty("bcs_bytes")
    private String bcsBytes;

    public SuiRawMoveObject() {
    }

    public SuiRawMoveObject(String type, Boolean hasPublicTransfer, BigInteger version, String bcsBytes) {
        this.type = type;
        this.hasPublicTransfer = hasPublicTransfer;
        this.version = version;
        this.bcsBytes = bcsBytes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHasPublicTransfer() {
        return hasPublicTransfer;
    }

    public void setHasPublicTransfer(Boolean hasPublicTransfer) {
        this.hasPublicTransfer = hasPublicTransfer;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getBcsBytes() {
        return bcsBytes;
    }

    public void setBcsBytes(String bcsBytes) {
        this.bcsBytes = bcsBytes;
    }

    @Override
    public String toString() {
        return "SuiRawMoveObject{" +
                "type='" + type + '\'' +
                ", hasPublicTransfer=" + hasPublicTransfer +
                ", version=" + version +
                ", bcsBytes='" + bcsBytes + '\'' +
                '}';
    }
}
