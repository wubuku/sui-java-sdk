package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "CertifiedTransaction", rename_all = "camelCase")]
 * pub struct SuiCertifiedTransaction {
 *     pub transaction_digest: TransactionDigest,
 *     pub data: SuiTransactionData,
 *     /// tx_signatures is a list of signatures signed by transaction participants,
 *     /// committing to the intent message containing the transaction data and intent.
 *     pub tx_signatures: Vec<GenericSignature>,
 *     /// authority signature information, if available, is signed by an authority, applied on `data`.
 *     pub auth_sign_info: SuiAuthorityStrongQuorumSignInfo,
 * }
 * </pre>
 */
public class SuiCertifiedTransaction {
    private String transactionDigest;
    private SuiTransactionData data;
    private String[] txSignatures;
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

    public String[] getTxSignatures() {
        return txSignatures;
    }

    public void setTxSignatures(String[] txSignatures) {
        this.txSignatures = txSignatures;
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
                ", txSignatures=" + Arrays.toString(txSignatures) +
                ", authSignInfo=" + authSignInfo +
                '}';
    }
}
