package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Debug, Serialize, Deserialize)]
 * pub struct CheckpointContents {
 *     transactions: Vec<ExecutionDigests>,
 * }
 * </pre>
 */
public class CheckpointContents {
    private ExecutionDigests[] transactions;

    public CheckpointContents() {
    }

    public CheckpointContents(ExecutionDigests[] transactions) {
        this.transactions = transactions;
    }

    public ExecutionDigests[] getTransactions() {
        return transactions;
    }

    public void setTransactions(ExecutionDigests[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CheckpointContents{" +
                "transactions=" + Arrays.toString(transactions) +
                '}';
    }
}
