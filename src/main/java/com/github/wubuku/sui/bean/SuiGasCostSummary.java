package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "GasCostSummary", rename_all = "camelCase")]
 * pub struct SuiGasCostSummary {
 *     pub computation_cost: u64,
 *     pub storage_cost: u64,
 *     pub storage_rebate: u64,
 * }
 * </pre>
 */
public class SuiGasCostSummary {
    private BigInteger computationCost;
    private BigInteger storageCost;
    private BigInteger storageRebate;

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

    @Override
    public String toString() {
        return "SuiGasCostSummary{" +
                "computationCost=" + computationCost +
                ", storageCost=" + storageCost +
                ", storageRebate=" + storageRebate +
                '}';
    }
}
