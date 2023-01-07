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
 *     pub staked_sui_id: ObjectID,
 * }
 * </pre>
 */
public class PendingDelegationEntry {
    private String delegator;
    @JsonProperty("sui_amount")
    private BigInteger suiAmount;
    @JsonProperty("staked_sui_id")
    private String stakedSuiId;

    public PendingDelegationEntry() {
    }

    public PendingDelegationEntry(String delegator, BigInteger suiAmount, String stakedSuiId) {
        this.delegator = delegator;
        this.suiAmount = suiAmount;
        this.stakedSuiId = stakedSuiId;
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

    public String getStakedSuiId() {
        return stakedSuiId;
    }

    public void setStakedSuiId(String stakedSuiId) {
        this.stakedSuiId = stakedSuiId;
    }

    @Override
    public String toString() {
        return "PendingDelegationEntry{" +
                "delegator='" + delegator + '\'' +
                ", suiAmount=" + suiAmount +
                ", stakedSuiId='" + stakedSuiId + '\'' +
                '}';
    }
}
