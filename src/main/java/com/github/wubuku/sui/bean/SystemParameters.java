package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::sui_system::SystemParameters type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct SystemParameters {
 *     pub min_validator_stake: u64,
 *     pub max_validator_candidate_count: u64,
 *     pub storage_gas_price: u64,
 * }
 * </pre>
 */
public class SystemParameters {
    @JsonProperty("min_validator_stake")
    private BigInteger minValidatorStake;
    @JsonProperty("max_validator_candidate_count")
    private BigInteger maxValidatorCandidateCount;
    @JsonProperty("storage_gas_price")
    private BigInteger storageGasPrice;

    public SystemParameters() {
    }

    public SystemParameters(BigInteger minValidatorStake, BigInteger maxValidatorCandidateCount, BigInteger storageGasPrice) {
        this.minValidatorStake = minValidatorStake;
        this.maxValidatorCandidateCount = maxValidatorCandidateCount;
        this.storageGasPrice = storageGasPrice;
    }

    public BigInteger getMinValidatorStake() {
        return minValidatorStake;
    }

    public void setMinValidatorStake(BigInteger minValidatorStake) {
        this.minValidatorStake = minValidatorStake;
    }

    public BigInteger getMaxValidatorCandidateCount() {
        return maxValidatorCandidateCount;
    }

    public void setMaxValidatorCandidateCount(BigInteger maxValidatorCandidateCount) {
        this.maxValidatorCandidateCount = maxValidatorCandidateCount;
    }

    public BigInteger getStorageGasPrice() {
        return storageGasPrice;
    }

    public void setStorageGasPrice(BigInteger storageGasPrice) {
        this.storageGasPrice = storageGasPrice;
    }

    @Override
    public String toString() {
        return "SystemParameters{" +
                "minValidatorStake=" + minValidatorStake +
                ", maxValidatorCandidateCount=" + maxValidatorCandidateCount +
                ", storageGasPrice=" + storageGasPrice +
                '}';
    }
}
