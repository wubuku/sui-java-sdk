package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type CoinBalanceChangeEvent = {
 *   packageId: ObjectId,
 *   transactionModule: string,
 *   sender: SuiAddress,
 *   owner: ObjectOwner,
 *   changeType: BalanceChangeType,
 *   coinType: string,
 *   coinObjectId: ObjectId,
 *   version: SequenceNumber,
 *   amount: number,
 * };
 * </pre>
 */
public class CoinBalanceChangeEvent {
    private String packageId;
    private String transactionModule;
    private String sender;
    private ObjectOwner owner;
    private BalanceChangeType changeType;
    private String coinType;
    private String coinObjectId;
    private BigInteger version;
    private BigInteger amount;

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

    public ObjectOwner getOwner() {
        return owner;
    }

    public void setOwner(ObjectOwner owner) {
        this.owner = owner;
    }

    public BalanceChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(BalanceChangeType changeType) {
        this.changeType = changeType;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getCoinObjectId() {
        return coinObjectId;
    }

    public void setCoinObjectId(String coinObjectId) {
        this.coinObjectId = coinObjectId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CoinBalanceChangeEvent{" +
                "packageId='" + packageId + '\'' +
                ", transactionModule='" + transactionModule + '\'' +
                ", sender='" + sender + '\'' +
                ", owner=" + owner +
                ", changeType=" + changeType +
                ", coinType='" + coinType + '\'' +
                ", coinObjectId='" + coinObjectId + '\'' +
                ", version=" + version +
                ", amount=" + amount +
                '}';
    }
}
