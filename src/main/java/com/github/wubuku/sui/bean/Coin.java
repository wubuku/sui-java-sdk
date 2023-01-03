package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub struct Coin {
 *     pub coin_type: String,
 *     pub coin_object_id: ObjectID,
 *     pub version: SequenceNumber,
 *     pub digest: ObjectDigest,
 *     pub balance: u64,
 * }
 * </pre>
 */
public class Coin {
    private String coinType;
    private String coinObjectId;
    private Long version;
    private String digest;
    private BigInteger balance;

    public Coin() {
    }

    public Coin(String coinType, String coinObjectId, Long version, String digest, BigInteger balance) {
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
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

    @Override
    public String toString() {
        return "Coin{" +
                "coinType='" + coinType + '\'' +
                ", coinObjectId='" + coinObjectId + '\'' +
                ", version=" + version +
                ", digest='" + digest + '\'' +
                ", balance=" + balance +
                '}';
    }
}
