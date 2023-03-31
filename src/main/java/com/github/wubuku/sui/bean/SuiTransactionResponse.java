package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiTransactionResponse {
 *     pub certificate: SuiCertifiedTransaction,
 *     pub effects: SuiTransactionEffects,
 *     pub timestamp_ms: Option<u64>,
 *     /// The checkpoint number when this transaction was included and hence finalized.
 *     /// This is only returned in the read api, not in the transaction execution api.
 *     pub checkpoint: Option<CheckpointSequenceNumber>,
 *     pub parsed_data: Option<SuiParsedTransactionResponse>,
 * }
 * </pre>
 */
public class SuiTransactionResponse {
    private SuiCertifiedTransaction certificate;
    private SuiTransactionEffects effects;
    @JsonProperty("timestamp_ms")
    private Long timestampMs;
    private BigInteger checkpoint;
    @JsonProperty("parsed_data")
    private SuiParsedTransactionResponse parsedData;

    public SuiTransactionResponse() {
    }

    public SuiCertifiedTransaction getCertificate() {
        return certificate;
    }

    public void setCertificate(SuiCertifiedTransaction certificate) {
        this.certificate = certificate;
    }

    public SuiTransactionEffects getEffects() {
        return effects;
    }

    public void setEffects(SuiTransactionEffects effects) {
        this.effects = effects;
    }

    public Long getTimestampMs() {
        return timestampMs;
    }

    public void setTimestampMs(Long timestampMs) {
        this.timestampMs = timestampMs;
    }

    public BigInteger getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(BigInteger checkpoint) {
        this.checkpoint = checkpoint;
    }

    public SuiParsedTransactionResponse getParsedData() {
        return parsedData;
    }

    public void setParsedData(SuiParsedTransactionResponse parsedData) {
        this.parsedData = parsedData;
    }

    @Override
    public String toString() {
        return "SuiTransactionResponse{" +
                "certificate=" + certificate +
                ", effects=" + effects +
                ", timestampMs=" + timestampMs +
                ", checkpoint=" + checkpoint +
                ", parsedData=" + parsedData +
                '}';
    }
}
