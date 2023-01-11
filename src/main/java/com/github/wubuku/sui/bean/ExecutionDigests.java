package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * pub struct ExecutionDigests {
 *     pub transaction: TransactionDigest,
 *     pub effects: TransactionEffectsDigest,
 * }
 * </pre>
 */
public class ExecutionDigests {
    private String transaction;
    private String effects;

    public ExecutionDigests() {
    }

    public ExecutionDigests(String transaction, String effects) {
        this.transaction = transaction;
        this.effects = effects;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public String getEffects() {
        return effects;
    }

    public void setEffects(String effects) {
        this.effects = effects;
    }

    @Override
    public String toString() {
        return "ExecutionDigests{" +
                "transaction='" + transaction + '\'' +
                ", effects='" + effects + '\'' +
                '}';
    }
}
