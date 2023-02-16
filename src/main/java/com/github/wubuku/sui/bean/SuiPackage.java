package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiPackage = {
 *   digest: string;
 *   objectId: string;
 *   version: number;
 * };
 * </pre>
 */
public class SuiPackage {
    private String digest;
    private String objectId;
    private BigInteger version;

    public SuiPackage() {
    }

    public SuiPackage(String digest, String objectId, BigInteger version) {
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

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "SuiPackage{" +
                "digest='" + digest + '\'' +
                ", objectId='" + objectId + '\'' +
                ", version=" + version +
                '}';
    }
}
