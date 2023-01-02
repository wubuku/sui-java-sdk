package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type GasCostSummary = {
 *   computationCost: number;
 *   storageCost: number;
 *   storageRebate: number;
 * };
 * </pre>
 */
public class GasCostSummary {
    private Long computationCost;
    private Long storageCost;
    private Long storageRebate;

    public GasCostSummary() {
    }

    public GasCostSummary(Long computationCost, Long storageCost, Long storageRebate) {
        this.computationCost = computationCost;
        this.storageCost = storageCost;
        this.storageRebate = storageRebate;
    }

    public Long getComputationCost() {
        return computationCost;
    }

    public void setComputationCost(Long computationCost) {
        this.computationCost = computationCost;
    }

    public Long getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(Long storageCost) {
        this.storageCost = storageCost;
    }

    public Long getStorageRebate() {
        return storageRebate;
    }

    public void setStorageRebate(Long storageRebate) {
        this.storageRebate = storageRebate;
    }

    @Override
    public String toString() {
        return "GasCostSummary{" +
                "computationCost=" + computationCost +
                ", storageCost=" + storageCost +
                ", storageRebate=" + storageRebate +
                '}';
    }
}
