package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, PartialEq, Eq)]
 * #[serde(rename = "TransactionBlock", rename_all = "camelCase")]
 * pub struct SuiTransactionBlock {
 *     pub data: SuiTransactionBlockData,
 *     pub tx_signatures: Vec<GenericSignature>,
 * }
 * </pre>
 */
public class SuiTransactionBlock {
    private SuiTransactionBlockData data;
    private String[] txSignatures;

    public SuiTransactionBlockData getData() {
        return data;
    }

    public void setData(SuiTransactionBlockData data) {
        this.data = data;
    }

    public String[] getTxSignatures() {
        return txSignatures;
    }

    public void setTxSignatures(String[] txSignatures) {
        this.txSignatures = txSignatures;
    }

    @Override
    public String toString() {
        return "SuiTransactionBlock{" +
                "data=" + data +
                ", txSignatures=" + Arrays.toString(txSignatures) +
                '}';
    }
}
