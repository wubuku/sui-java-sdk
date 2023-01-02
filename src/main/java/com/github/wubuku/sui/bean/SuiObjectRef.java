package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiObjectRef = {
 *     digest: TransactionDigest;
 *     objectId: string;
 *     version: number;
 * };
 * </pre>
 */
public class SuiObjectRef {
    private String digest;
    private String objectId;
    private Long version;

    public SuiObjectRef() {
    }

    public SuiObjectRef(String digest, String objectId, Long version) {
        this.digest = digest;
        this.objectId = objectId;
        this.version = version;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SuiObjectRef{" +
                "digest='" + digest + '\'' +
                ", objectId='" + objectId + '\'' +
                ", version=" + version +
                '}';
    }
}
