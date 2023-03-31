package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "GasCostSummary", rename_all = "camelCase")]
 * pub struct SuiGasCostSummary {
 *     pub computation_cost: BigInt,
 *     pub storage_cost: BigInt,
 *     pub storage_rebate: BigInt,
 *     pub non_refundable_storage_fee: BigInt,
 * }
 * </pre>
 */
public class SuiGasCostSummary {
    private BigInteger computationCost;
    private BigInteger storageCost;
    private BigInteger storageRebate;

    private BigInteger nonRefundableStorageFee;

    public BigInteger getComputationCost() {
        return computationCost;
    }

    public void setComputationCost(BigInteger computationCost) {
        this.computationCost = computationCost;
    }

    public BigInteger getStorageCost() {
        return storageCost;
    }

    public void setStorageCost(BigInteger storageCost) {
        this.storageCost = storageCost;
    }

    public BigInteger getStorageRebate() {
        return storageRebate;
    }

    public void setStorageRebate(BigInteger storageRebate) {
        this.storageRebate = storageRebate;
    }

    public BigInteger getNonRefundableStorageFee() {
        return nonRefundableStorageFee;
    }

    public void setNonRefundableStorageFee(BigInteger nonRefundableStorageFee) {
        this.nonRefundableStorageFee = nonRefundableStorageFee;
    }

    @Override
    public String toString() {
        return "SuiGasCostSummary{" +
                "computationCost=" + computationCost +
                ", storageCost=" + storageCost +
                ", storageRebate=" + storageRebate +
                ", nonRefundableStorageFee=" + nonRefundableStorageFee +
                '}';
    }
}
