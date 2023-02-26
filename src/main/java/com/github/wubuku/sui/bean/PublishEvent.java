package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export const PublishEvent = object({
 *   sender: SuiAddress,
 *   packageId: ObjectId,
 *   version: optional(number()),
 *   digest: optional(string()),
 * });
 * </pre>
 */
public class PublishEvent {
    private String sender;
    private String packageId;
    private BigInteger version;
    private String digest;

    public PublishEvent() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

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

    @Override
    public String toString() {
        return "PublishEvent{" +
                "sender='" + sender + '\'' +
                ", packageId='" + packageId + '\'' +
                ", version=" + version +
                ", digest='" + digest + '\'' +
                '}';
    }
}
