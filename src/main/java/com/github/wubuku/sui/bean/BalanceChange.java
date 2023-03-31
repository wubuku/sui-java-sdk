package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema, PartialEq, Eq)]
 * #[serde(rename_all = "camelCase")]
 * pub struct BalanceChange {
 *     /// Owner of the balance change
 *     pub owner: Owner,
 *     #[schemars(with = "String")]
 *     #[serde_as(as = "SuiTypeTag")]
 *     pub coin_type: TypeTag,
 *     /// The amount indicate the balance value changes,
 *     /// negative amount means spending coin value and positive means receiving coin value.
 *     #[schemars(with = "String")]
 *     #[serde_as(as = "DisplayFromStr")]
 *     pub amount: i128,
 * }
 * </pre>
 */
public class BalanceChange {
    private ObjectOwner owner;
    private String coinType;
    private BigInteger amount;

    public ObjectOwner getOwner() {
        return owner;
    }

    public void setOwner(ObjectOwner owner) {
        this.owner = owner;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BalanceChange{" +
                "owner=" + owner +
                ", coinType='" + coinType + '\'' +
                ", amount=" + amount +
                '}';
    }
}
