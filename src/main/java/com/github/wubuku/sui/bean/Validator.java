package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::validator::Validator type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct Validator {
 *     pub metadata: ValidatorMetadata,
 *     pub stake_amount: u64,
 *     pub pending_stake: u64,
 *     pub pending_withdraw: u64,
 *     pub gas_price: u64,
 *     pub delegation_staking_pool: StakingPool,
 *     pub commission_rate: u64,
 * }
 * </pre>
 */
public class Validator {
    private ValidatorMetadata metadata;
    @JsonProperty("stake_amount")
    private Long stakeAmount;
    @JsonProperty("pending_stake")
    private Long pendingStake;
    @JsonProperty("pending_withdraw")
    private Long pendingWithdraw;
    @JsonProperty("gas_price")
    private Long gasPrice;
    @JsonProperty("delegation_staking_pool")
    private StakingPool delegationStakingPool;
    @JsonProperty("commission_rate")
    private Long commissionRate;

    public Validator() {
    }

    public Validator(ValidatorMetadata metadata, Long stakeAmount, Long pendingStake, Long pendingWithdraw, Long gasPrice, StakingPool delegationStakingPool, Long commissionRate) {
        this.metadata = metadata;
        this.stakeAmount = stakeAmount;
        this.pendingStake = pendingStake;
        this.pendingWithdraw = pendingWithdraw;
        this.gasPrice = gasPrice;
        this.delegationStakingPool = delegationStakingPool;
        this.commissionRate = commissionRate;
    }

    public ValidatorMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(ValidatorMetadata metadata) {
        this.metadata = metadata;
    }

    public Long getStakeAmount() {
        return stakeAmount;
    }

    public void setStakeAmount(Long stakeAmount) {
        this.stakeAmount = stakeAmount;
    }

    public Long getPendingStake() {
        return pendingStake;
    }

    public void setPendingStake(Long pendingStake) {
        this.pendingStake = pendingStake;
    }

    public Long getPendingWithdraw() {
        return pendingWithdraw;
    }

    public void setPendingWithdraw(Long pendingWithdraw) {
        this.pendingWithdraw = pendingWithdraw;
    }

    public Long getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(Long gasPrice) {
        this.gasPrice = gasPrice;
    }

    public StakingPool getDelegationStakingPool() {
        return delegationStakingPool;
    }

    public void setDelegationStakingPool(StakingPool delegationStakingPool) {
        this.delegationStakingPool = delegationStakingPool;
    }

    public Long getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Long commissionRate) {
        this.commissionRate = commissionRate;
    }

    @Override
    public String toString() {
        return "Validator{" +
                "metadata=" + metadata +
                ", stakeAmount=" + stakeAmount +
                ", pendingStake=" + pendingStake +
                ", pendingWithdraw=" + pendingWithdraw +
                ", gasPrice=" + gasPrice +
                ", delegationStakingPool=" + delegationStakingPool +
                ", commissionRate=" + commissionRate +
                '}';
    }
}
