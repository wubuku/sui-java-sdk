package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type NewObjectEvent = {
 *   packageId: ObjectId;
 *   transactionModule: string;
 *   sender: SuiAddress;
 *   recipient: ObjectOwner;
 *   objectType: string,
 *   objectId: ObjectId;
 *   version: SequenceNumber;
 * };
 * </pre>
 */
public class NewObjectEvent {
    private String packageId;
    private String transactionModule;
    private String sender;
    private ObjectOwner recipient;
    private String objectType;
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

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "NewObjectEvent{" +
                "packageId='" + packageId + '\'' +
                ", transactionModule='" + transactionModule + '\'' +
                ", sender='" + sender + '\'' +
                ", recipient=" + recipient +
                ", objectType='" + objectType + '\'' +
                ", objectId='" + objectId + '\'' +
                ", version=" + version +
                '}';
    }
}
