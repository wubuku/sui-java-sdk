package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * pub struct SuiConsensusCommitPrologue {
 *     pub epoch: u64,
 *     pub round: u64,
 *     pub commit_timestamp_ms: u64,
 * }
 * </pre>
 */
public class SuiConsensusCommitPrologue {
    private BigInteger epoch;
    private BigInteger round;
    @JsonProperty("commit_timestamp_ms")
    private BigInteger commitTimestampMs;

    public SuiConsensusCommitPrologue() {
    }

    public SuiConsensusCommitPrologue(BigInteger epoch, BigInteger round, BigInteger commitTimestampMs) {
        this.epoch = epoch;
        this.round = round;
        this.commitTimestampMs = commitTimestampMs;
    }

    public BigInteger getEpoch() {
        return epoch;
    }

    public void setEpoch(BigInteger epoch) {
        this.epoch = epoch;
    }

    public BigInteger getRound() {
        return round;
    }

    public void setRound(BigInteger round) {
        this.round = round;
    }

    public BigInteger getCommitTimestampMs() {
        return commitTimestampMs;
    }

    public void setCommitTimestampMs(BigInteger commitTimestampMs) {
        this.commitTimestampMs = commitTimestampMs;
    }

    @Override
    public String toString() {
        return "SuiConsensusCommitPrologue{" +
                "epoch=" + epoch +
                ", round=" + round +
                ", commitTimestampMs=" + commitTimestampMs +
                '}';
    }
}
