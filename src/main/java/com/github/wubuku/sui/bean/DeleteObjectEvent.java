package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type DeleteObjectEvent = {
 *   packageId: ObjectId;
 *   transactionModule: string;
 *   sender: SuiAddress;
 *   objectId: ObjectId;
 *   version: SequenceNumber;
 * };
 * </pre>
 */
public class DeleteObjectEvent {
    private String packageId;
    private String transactionModule;
    private String sender;
    private String objectId;
    private BigInteger version;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getTransactionModule() {
        return transactionModule;
    }

    public void setTransactionModule(String transactionModule) {
        this.transactionModule = transactionModule;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
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
        return "DeleteObjectEvent{" +
                "packageId='" + packageId + '\'' +
                ", transactionModule='" + transactionModule + '\'' +
                ", sender='" + sender + '\'' +
                ", objectId='" + objectId + '\'' +
                ", version=" + version +
                '}';
    }
}
