package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "CertifiedTransaction", rename_all = "camelCase")]
 * pub struct SuiCertifiedTransaction {
 *     pub transaction_digest: TransactionDigest,
 *     pub data: SuiTransactionData,
 *     /// tx_signature is signed by the transaction sender, committing to the intent message containing the transaction data and intent.
 *     pub tx_signature: Signature,
 *     /// authority signature information, if available, is signed by an authority, applied on `data`.
 *     pub auth_sign_info: SuiAuthorityStrongQuorumSignInfo,
 * }
 * </pre>
 */
public class SuiCertifiedTransaction {
    private String transactionDigest;
    private SuiTransactionData data;
    private String txSignature;
    private SuiAuthorityStrongQuorumSignInfo authSignInfo;

    public String getTransactionDigest() {
        return transactionDigest;
    }

    public void setTransactionDigest(String transactionDigest) {
        this.transactionDigest = transactionDigest;
    }

    public SuiTransactionData getData() {
        return data;
    }

    public void setData(SuiTransactionData data) {
        this.data = data;
    }

    public String getTxSignature() {
        return txSignature;
    }

    public void setTxSignature(String txSignature) {
        this.txSignature = txSignature;
    }

    public SuiAuthorityStrongQuorumSignInfo getAuthSignInfo() {
        return authSignInfo;
    }

    public void setAuthSignInfo(SuiAuthorityStrongQuorumSignInfo authSignInfo) {
        this.authSignInfo = authSignInfo;
    }

    @Override
    public String toString() {
        return "SuiCertifiedTransaction{" +
                "transactionDigest='" + transactionDigest + '\'' +
                ", data=" + data +
                ", txSignature='" + txSignature + '\'' +
                ", authSignInfo=" + authSignInfo +
                '}';
    }
}
