package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiTransactionResponse = {
 *   certificate: CertifiedTransaction;
 *   effects: TransactionEffects;
 *   timestamp_ms: number | null;
 *   parsed_data: SuiParsedTransactionResponse | null;
 * };
 * </pre>
 */
public class SuiTransactionResponse {
    private CertifiedTransaction certificate;
    private TransactionEffects effects;
    @JsonProperty("timestamp_ms")
    private Long timestampMS;
    @JsonProperty("parsed_data")
    private SuiParsedTransactionResponse parsedData;

    public SuiTransactionResponse() {
    }

    public SuiTransactionResponse(CertifiedTransaction certificate,
                                  TransactionEffects effects,
                                  Long timestampMS,
                                  SuiParsedTransactionResponse parsedData) {
        this.certificate = certificate;
        this.effects = effects;
        this.timestampMS = timestampMS;
        this.parsedData = parsedData;
    }

    public CertifiedTransaction getCertificate() {
        return certificate;
    }

    public void setCertificate(CertifiedTransaction certificate) {
        this.certificate = certificate;
    }

    public TransactionEffects getEffects() {
        return effects;
    }

    public void setEffects(TransactionEffects effects) {
        this.effects = effects;
    }

    public Long getTimestampMS() {
        return timestampMS;
    }

    public void setTimestampMS(Long timestampMS) {
        this.timestampMS = timestampMS;
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
                ", timestampMS=" + timestampMS +
                ", parsedData=" + parsedData +
                '}';
    }
}
