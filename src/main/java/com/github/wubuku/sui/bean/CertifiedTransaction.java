package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type CertifiedTransaction = {
 *   transactionDigest: TransactionDigest;
 *   data: SuiTransactionData;
 *   txSignature: string;
 *   authSignInfo: AuthorityQuorumSignInfo;
 * };
 * </pre>
 */
public class CertifiedTransaction {
    private String transactionDigest;
    private SuiTransactionData data;
    private String txSignature;
    private AuthorityQuorumSignInfo authSignInfo;

    public CertifiedTransaction() {
    }

    public CertifiedTransaction(String transactionDigest,
                                SuiTransactionData data,
                                String txSignature,
                                AuthorityQuorumSignInfo authSignInfo
    ) {
        this.transactionDigest = transactionDigest;
        this.data = data;
        this.txSignature = txSignature;
        this.authSignInfo = authSignInfo;
    }

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

    public AuthorityQuorumSignInfo getAuthSignInfo() {
        return authSignInfo;
    }

    public void setAuthSignInfo(AuthorityQuorumSignInfo authSignInfo) {
        this.authSignInfo = authSignInfo;
    }

    @Override
    public String toString() {
        return "CertifiedTransaction{" +
                "transactionDigest='" + transactionDigest + '\'' +
                ", data=" + data +
                ", txSignature='" + txSignature + '\'' +
                ", authSignInfo=" + authSignInfo +
                '}';
    }
}
