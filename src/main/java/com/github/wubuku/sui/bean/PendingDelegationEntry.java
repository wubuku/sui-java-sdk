package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::staking_pool::PendingDelegationEntry type.
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct PendingDelegationEntry {
 *     pub delegator: SuiAddress,
 *     pub sui_amount: u64,
 * }
 * </pre>
 */
public class PendingDelegationEntry {
    private String delegator;
    @JsonProperty("sui_amount")
    private BigInteger suiAmount;

    public PendingDelegationEntry() {
    }

    public PendingDelegationEntry(String delegator, BigInteger suiAmount) {
        this.delegator = delegator;
        this.suiAmount = suiAmount;
    }

    public String getDelegator() {
        return delegator;
    }

    public void setDelegator(String delegator) {
        this.delegator = delegator;
    }

    public BigInteger getSuiAmount() {
        return suiAmount;
    }

    public void setSuiAmount(BigInteger suiAmount) {
        this.suiAmount = suiAmount;
    }

    @Override
    public String toString() {
        return "PendingDelegationEntry{" +
                "delegator='" + delegator + '\'' +
                ", suiAmount=" + suiAmount +
                '}';
    }
}
