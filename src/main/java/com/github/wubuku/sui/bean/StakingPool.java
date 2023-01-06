package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::staking_pool::StakingPool type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct StakingPool {
 *     pub validator_address: SuiAddress,
 *     pub starting_epoch: u64,
 *     pub sui_balance: u64,
 *     pub rewards_pool: Balance,
 *     pub delegation_token_supply: Supply,
 *     pub pending_delegations: Vec<PendingDelegationEntry>,
 *     pub pending_withdraws: Vec<PendingWithdrawEntry>,
 * }
 * </pre>
 */
public class StakingPool {
    @JsonProperty("validator_address")
    private String validatorAddress;
    @JsonProperty("starting_epoch")
    private BigInteger startingEpoch;
    @JsonProperty("sui_balance")
    private BigInteger suiBalance;
    @JsonProperty("rewards_pool")
    private Balance rewardsPool;
    @JsonProperty("delegation_token_supply")
    private Supply delegationTokenSupply;
    @JsonProperty("pending_delegations")
    private PendingDelegationEntry[] pendingDelegations;
    @JsonProperty("pending_withdraws")
    private PendingWithdrawEntry[] pendingWithdraws;

    public String getValidatorAddress() {
        return validatorAddress;
    }

    public void setValidatorAddress(String validatorAddress) {
        this.validatorAddress = validatorAddress;
    }

    public BigInteger getStartingEpoch() {
        return startingEpoch;
    }

    public void setStartingEpoch(BigInteger startingEpoch) {
        this.startingEpoch = startingEpoch;
    }

    public BigInteger getSuiBalance() {
        return suiBalance;
    }

    public void setSuiBalance(BigInteger suiBalance) {
        this.suiBalance = suiBalance;
    }

    public Balance getRewardsPool() {
        return rewardsPool;
    }

    public void setRewardsPool(Balance rewardsPool) {
        this.rewardsPool = rewardsPool;
    }

    public Supply getDelegationTokenSupply() {
        return delegationTokenSupply;
    }

    public void setDelegationTokenSupply(Supply delegationTokenSupply) {
        this.delegationTokenSupply = delegationTokenSupply;
    }

    public PendingDelegationEntry[] getPendingDelegations() {
        return pendingDelegations;
    }

    public void setPendingDelegations(PendingDelegationEntry[] pendingDelegations) {
        this.pendingDelegations = pendingDelegations;
    }

    public PendingWithdrawEntry[] getPendingWithdraws() {
        return pendingWithdraws;
    }

    public void setPendingWithdraws(PendingWithdrawEntry[] pendingWithdraws) {
        this.pendingWithdraws = pendingWithdraws;
    }

    @Override
    public String toString() {
        return "StakingPool{" +
                "validatorAddress='" + validatorAddress + '\'' +
                ", startingEpoch=" + startingEpoch +
                ", suiBalance=" + suiBalance +
                ", rewardsPool=" + rewardsPool +
                ", delegationTokenSupply=" + delegationTokenSupply +
                ", pendingDelegations=" + Arrays.toString(pendingDelegations) +
                ", pendingWithdraws=" + Arrays.toString(pendingWithdraws) +
                '}';
    }
}
