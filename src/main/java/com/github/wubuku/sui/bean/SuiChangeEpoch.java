package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiChangeEpoch = {
 *   epoch: EpochId;
 *   storage_charge: number;
 *   computation_charge: number;
 * };
 * </pre>
 */
public class SuiChangeEpoch {
    private Long epoch;
    @JsonProperty("storage_charge")
    private Long storageCharge;
    @JsonProperty("computation_charge")
    private Long computationCharge;

    public SuiChangeEpoch() {
    }

    public SuiChangeEpoch(Long epoch, Long storageCharge, Long computationCharge) {
        this.epoch = epoch;
        this.storageCharge = storageCharge;
        this.computationCharge = computationCharge;
    }

    public Long getEpoch() {
        return epoch;
    }

    public void setEpoch(Long epoch) {
        this.epoch = epoch;
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
                '}';
    }
}
