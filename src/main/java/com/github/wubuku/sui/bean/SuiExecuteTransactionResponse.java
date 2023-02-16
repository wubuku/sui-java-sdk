package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * pub struct SuiExecuteTransactionResponse {
 *     // If this transaction was already finalized previously, there is no guarantee that a
 *     // certificate is still available.
 *     pub certificate: Option<SuiCertifiedTransaction>,
 *     pub effects: SuiFinalizedEffects,
 *     // If the transaction is confirmed to be executed locally
 *     // before this response.
 *     pub confirmed_local_execution: bool,
 * }
 * </pre>
 */
public class SuiExecuteTransactionResponse {
    private SuiCertifiedTransaction certificate;
    private SuiFinalizedEffects effects;
    @JsonProperty("confirmed_local_execution")
    private Boolean confirmedLocalExecution;

    public SuiCertifiedTransaction getCertificate() {
        return certificate;
    }

    public void setCertificate(SuiCertifiedTransaction certificate) {
        this.certificate = certificate;
    }

    public SuiFinalizedEffects getEffects() {
        return effects;
    }

    public void setEffects(SuiFinalizedEffects effects) {
        this.effects = effects;
    }

    public Boolean isConfirmedLocalExecution() {
        return confirmedLocalExecution;
    }

    public void setConfirmedLocalExecution(Boolean confirmedLocalExecution) {
        this.confirmedLocalExecution = confirmedLocalExecution;
    }

    @Override
    public String toString() {
        return "SuiExecuteTransactionResponse{" +
                "certificate=" + certificate +
                ", effects=" + effects +
                ", confirmedLocalExecution=" + confirmedLocalExecution +
                '}';
    }
}
