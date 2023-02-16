package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export const CoinStruct = object({
 *     coinType: string(),
 *     coinObjectId: ObjectId,
 *     version: number(),
 *     digest: TransactionDigest,
 *     balance: number(),
 *     lockedUntilEpoch: nullable(number()),
 *     // TODO: remove optional when it is supported from all deployed networks
 *     previousTransaction: optional(TransactionDigest),
 * });
 * </pre>
 */
public class Coin {
    private String coinType;
    private String coinObjectId;
    private BigInteger version;
    private String digest;
    private BigInteger balance;

    private BigInteger lockedUntilEpoch;

    private String previousTransaction;

    public Coin() {
    }

    public Coin(String coinType, String coinObjectId, BigInteger version, String digest, BigInteger balance) {
        this.coinType = coinType;
        this.coinObjectId = coinObjectId;
        this.version = version;
        this.digest = digest;
        this.balance = balance;
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

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(BigInteger balance) {
        this.balance = balance;
    }

    public BigInteger getLockedUntilEpoch() {
        return lockedUntilEpoch;
    }

    public void setLockedUntilEpoch(BigInteger lockedUntilEpoch) {
        this.lockedUntilEpoch = lockedUntilEpoch;
    }

    public String getPreviousTransaction() {
        return previousTransaction;
    }

    public void setPreviousTransaction(String previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinType='" + coinType + '\'' +
                ", coinObjectId='" + coinObjectId + '\'' +
                ", version=" + version +
                ", digest='" + digest + '\'' +
                ", balance=" + balance +
                ", lockedUntilEpoch=" + lockedUntilEpoch +
                ", previousTransaction='" + previousTransaction + '\'' +
                '}';
    }
}
