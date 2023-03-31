package com.github.wubuku.sui.bean;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Serialize, Deserialize, Debug, JsonSchema, Clone, Default)]
 * #[serde(rename_all = "camelCase", rename = "TransactionBlockResponse")]
 * pub struct SuiTransactionBlockResponse {
 *     pub digest: TransactionDigest,
 *     /// Transaction input data
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub transaction: Option<SuiTransactionBlock>,
 *     /// BCS encoded [SenderSignedData] that includes input object references
 *     /// returns empty array if `show_raw_transaction` is false
 *     #[serde_as(as = "Base64")]
 *     #[schemars(with = "Base64")]
 *     #[serde(skip_serializing_if = "Vec::is_empty", default)]
 *     pub raw_transaction: Vec<u8>,
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub effects: Option<SuiTransactionBlockEffects>,
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub events: Option<SuiTransactionBlockEvents>,
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub object_changes: Option<Vec<ObjectChange>>,
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub balance_changes: Option<Vec<BalanceChange>>,
 *     #[serde(default, skip_serializing_if = "Option::is_none")]
 *     pub timestamp_ms: Option<u64>,
 *     #[serde(default, skip_serializing_if = "Option::is_none")]
 *     pub confirmed_local_execution: Option<bool>,
 *     /// The checkpoint number when this transaction was included and hence finalized.
 *     /// This is only returned in the read api, not in the transaction execution api.
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub checkpoint: Option<CheckpointSequenceNumber>,
 *     #[serde(skip_serializing_if = "Vec::is_empty", default)]
 *     pub errors: Vec<String>,
 * }
 * </pre>
 */
public class SuiTransactionBlockResponse {
    private String digest;
    private SuiTransactionBlock transaction;
    private String rawTransaction;
    private SuiTransactionBlockEffects effects;
    private SuiTransactionBlockEvents events;
    private ObjectChange[] objectChanges;
    private BalanceChange[] balanceChanges;
    private Long timestampMs;
    private Boolean confirmedLocalExecution;
    private BigInteger checkpoint;
    private String[] errors;

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public SuiTransactionBlock getTransaction() {
        return transaction;
    }

    public void setTransaction(SuiTransactionBlock transaction) {
        this.transaction = transaction;
    }

    public String getRawTransaction() {
        return rawTransaction;
    }

    public void setRawTransaction(String rawTransaction) {
        this.rawTransaction = rawTransaction;
    }

    public SuiTransactionBlockEffects getEffects() {
        return effects;
    }

    public void setEffects(SuiTransactionBlockEffects effects) {
        this.effects = effects;
    }

    public SuiTransactionBlockEvents getEvents() {
        return events;
    }

    public void setEvents(SuiTransactionBlockEvents events) {
        this.events = events;
    }

    public ObjectChange[] getObjectChanges() {
        return objectChanges;
    }

    public void setObjectChanges(ObjectChange[] objectChanges) {
        this.objectChanges = objectChanges;
    }

    public BalanceChange[] getBalanceChanges() {
        return balanceChanges;
    }

    public void setBalanceChanges(BalanceChange[] balanceChanges) {
        this.balanceChanges = balanceChanges;
    }

    public Long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(Long timestampMs) {
        this.timestampMs = timestampMs;
    }

    public Boolean getConfirmedLocalExecution() {
        return confirmedLocalExecution;
    }

    public void setConfirmedLocalExecution(Boolean confirmedLocalExecution) {
        this.confirmedLocalExecution = confirmedLocalExecution;
    }

    public BigInteger getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(BigInteger checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "SuiTransactionBlockResponse{" +
                "digest='" + digest + '\'' +
                ", transaction=" + transaction +
                ", rawTransaction='" + rawTransaction + '\'' +
                ", effects=" + effects +
                ", events=" + events +
                ", objectChanges=" + Arrays.toString(objectChanges) +
                ", balanceChanges=" + Arrays.toString(balanceChanges) +
                ", timestampMs=" + timestampMs +
                ", confirmedLocalExecution=" + confirmedLocalExecution +
                ", checkpoint=" + checkpoint +
                ", errors=" + Arrays.toString(errors) +
                '}';
    }
}
