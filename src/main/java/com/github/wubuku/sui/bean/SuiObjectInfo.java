package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiObjectInfo = SuiObjectRef & {
 *   type: string;
 *   owner: ObjectOwner;
 *   previousTransaction: TransactionDigest;
 * };
 * </pre>
 */
public class SuiObjectInfo extends SuiObjectRef {
    private String type;
    private ObjectOwner owner;
    private String previousTransaction;

    public SuiObjectInfo() {
    }

    public SuiObjectInfo(String digest, String objectId, BigInteger version, String type, ObjectOwner owner, String previousTransaction) {
        super(digest, objectId, version);
        this.type = type;
        this.owner = owner;
        this.previousTransaction = previousTransaction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectOwner getOwner() {
        return owner;
    }

    public void setOwner(ObjectOwner owner) {
        this.owner = owner;
    }

    public String getPreviousTransaction() {
        return previousTransaction;
    }

    public void setPreviousTransaction(String previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    @Override
    public String toString() {
        return "SuiObjectInfo{" +
                "digest='" + getDigest() + '\'' +
                ", objectId='" + getObjectId() + '\'' +
                ", version=" + getVersion() +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                ", previousTransaction='" + previousTransaction + '\'' +
                '}';
    }
}
