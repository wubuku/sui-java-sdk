package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub struct Balance {
 *     pub coin_type: String,
 *     pub coin_object_count: usize,
 *     pub total_balance: u128,
 * }
 * </pre>
 */
public class Balance {
    private String coinType;
    private Long coinObjectCount;
    private BigInteger totalBalance;

    public Balance() {
    }

    public Balance(String coinType, Long coinObjectCount, BigInteger totalBalance) {
        this.coinType = coinType;
        this.coinObjectCount = coinObjectCount;
        this.totalBalance = totalBalance;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public Long getCoinObjectCount() {
        return coinObjectCount;
    }

    public void setCoinObjectCount(Long coinObjectCount) {
        this.coinObjectCount = coinObjectCount;
    }

    public BigInteger getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigInteger totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "coinType='" + coinType + '\'' +
                ", coinObjectCount=" + coinObjectCount +
                ", totalBalance=" + totalBalance +
                '}';
    }
}
