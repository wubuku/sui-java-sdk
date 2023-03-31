package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * pub struct SuiChangeEpoch {
 *     pub epoch: SuiEpochId,
 *     pub storage_charge: u64,
 *     pub computation_charge: u64,
 *     pub storage_rebate: u64,
 *     pub epoch_start_timestamp_ms: u64,
 * }
 * </pre>
 */
public class SuiChangeEpoch {
    private BigInteger epoch;
    @JsonProperty("storage_charge")
    private Long storageCharge;
    @JsonProperty("computation_charge")
    private Long computationCharge;

    @JsonProperty("storage_rebate")
    private Long storageRebate;

    @JsonProperty("epoch_start_timestamp_ms")
    private Long epochStartTimestampMs;

    public SuiChangeEpoch() {
    }

    public SuiChangeEpoch(BigInteger epoch, Long storageCharge, Long computationCharge, Long storageRebate, Long epochStartTimestampMs) {
        this.epoch = epoch;
        this.storageCharge = storageCharge;
        this.computationCharge = computationCharge;
        this.storageRebate = storageRebate;
        this.epochStartTimestampMs = epochStartTimestampMs;
    }

    public BigInteger getEpoch() {
        return epoch;
    }

    public void setEpoch(BigInteger epoch) {
        this.epoch = epoch;
    }

    public Long getStorageRebate() {
        return storageRebate;
    }

    public void setStorageRebate(Long storageRebate) {
        this.storageRebate = storageRebate;
    }

    public Long getEpochStartTimestampMs() {
        return epochStartTimestampMs;
    }

    public void setEpochStartTimestampMs(Long epochStartTimestampMs) {
        this.epochStartTimestampMs = epochStartTimestampMs;
    }

    public Long getStorageCharge() {
        return storageCharge;
    }

    public void setStorageCharge(Long storageCharge) {
        this.storageCharge = storageCharge;
    }

    public Long getComputationCharge() {
        return computationCharge;
    }

    public void setComputationCharge(Long computationCharge) {
        this.computationCharge = computationCharge;
    }

    @Override
    public String toString() {
        return "SuiChangeEpoch{" +
                "epoch=" + epoch +
                ", storageCharge=" + storageCharge +
                ", computationCharge=" + computationCharge +
                ", storageRebate=" + storageRebate +
                ", epochStartTimestampMs=" + epochStartTimestampMs +
                '}';
    }
}
