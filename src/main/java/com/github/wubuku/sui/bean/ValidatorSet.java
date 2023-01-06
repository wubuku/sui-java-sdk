package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::validator_set::ValidatorSet type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct ValidatorSet {
 *     pub validator_stake: u64,
 *     pub delegation_stake: u64,
 *     pub quorum_stake_threshold: u64,
 *     pub active_validators: Vec<Validator>,
 *     pub pending_validators: Vec<Validator>,
 *     pub pending_removals: Vec<u64>,
 *     pub next_epoch_validators: Vec<ValidatorMetadata>,
 *     pub pending_delegation_switches: VecMap<ValidatorPair, Vec<PendingWithdrawEntry>>,
 * }
 * </pre>
 */
public class ValidatorSet {
    @JsonProperty("validator_stake")
    private BigInteger validatorStake;
    @JsonProperty("delegation_stake")
    private BigInteger delegationStake;
    @JsonProperty("quorum_stake_threshold")
    private BigInteger quorumStakeThreshold;
    @JsonProperty("active_validators")
    private Validator[] activeValidators;
    @JsonProperty("pending_validators")
    private Validator[] pendingValidators;
    @JsonProperty("pending_removals")
    private BigInteger[] pendingRemovals;
    @JsonProperty("next_epoch_validators")
    private ValidatorMetadata[] nextEpochValidators;
    @JsonProperty("pending_delegation_switches")
    private PendingDelegationSwitches pendingDelegationSwitches;

    public BigInteger getValidatorStake() {
        return validatorStake;
    }

    public void setValidatorStake(BigInteger validatorStake) {
        this.validatorStake = validatorStake;
    }

    public BigInteger getDelegationStake() {
        return delegationStake;
    }

    public void setDelegationStake(BigInteger delegationStake) {
        this.delegationStake = delegationStake;
    }

    public BigInteger getQuorumStakeThreshold() {
        return quorumStakeThreshold;
    }

    public void setQuorumStakeThreshold(BigInteger quorumStakeThreshold) {
        this.quorumStakeThreshold = quorumStakeThreshold;
    }

    public Validator[] getActiveValidators() {
        return activeValidators;
    }

    public void setActiveValidators(Validator[] activeValidators) {
        this.activeValidators = activeValidators;
    }

    public Validator[] getPendingValidators() {
        return pendingValidators;
    }

    public void setPendingValidators(Validator[] pendingValidators) {
        this.pendingValidators = pendingValidators;
    }

    public BigInteger[] getPendingRemovals() {
        return pendingRemovals;
    }

    public void setPendingRemovals(BigInteger[] pendingRemovals) {
        this.pendingRemovals = pendingRemovals;
    }

    public ValidatorMetadata[] getNextEpochValidators() {
        return nextEpochValidators;
    }

    public void setNextEpochValidators(ValidatorMetadata[] nextEpochValidators) {
        this.nextEpochValidators = nextEpochValidators;
    }

    public PendingDelegationSwitches getPendingDelegationSwitches() {
        return pendingDelegationSwitches;
    }

    public void setPendingDelegationSwitches(PendingDelegationSwitches pendingDelegationSwitches) {
        this.pendingDelegationSwitches = pendingDelegationSwitches;
    }

    @Override
    public String toString() {
        return "ValidatorSet{" +
                "validatorStake=" + validatorStake +
                ", delegationStake=" + delegationStake +
                ", quorumStakeThreshold=" + quorumStakeThreshold +
                ", activeValidators=" + Arrays.toString(activeValidators) +
                ", pendingValidators=" + Arrays.toString(pendingValidators) +
                ", pendingRemovals=" + Arrays.toString(pendingRemovals) +
                ", nextEpochValidators=" + Arrays.toString(nextEpochValidators) +
                ", pendingDelegationSwitches=" + pendingDelegationSwitches +
                '}';
    }

    public static class PendingDelegationSwitches extends VecMap<ValidatorPair, PendingWithdrawEntry[]> {
        public PendingDelegationSwitches() {
        }

        public PendingDelegationSwitches(Entry<ValidatorPair, PendingWithdrawEntry[]>[] contents) {
            super(contents);
        }
    }
}
