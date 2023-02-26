package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone)]
 * #[serde(rename = "TransactionData", rename_all = "camelCase")]
 * pub struct SuiTransactionData {
 *     pub transactions: Vec<SuiTransactionKind>,
 *     pub sender: SuiAddress,
 *     pub gas_data: SuiGasData,
 * }
 * </pre>
 */
public class SuiTransactionData {
    private SuiTransactionKind[] transactions;
    private String sender;

    private SuiGasData gasData;

    public SuiTransactionData() {
    }

    public SuiTransactionKind[] getTransactions() {
        return transactions;
    }

    public void setTransactions(SuiTransactionKind[] transactions) {
        this.transactions = transactions;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public SuiGasData getGasData() {
        return gasData;
    }

    public void setGasData(SuiGasData gasData) {
        this.gasData = gasData;
    }

    @Override
    public String toString() {
        return "SuiTransactionData{" +
                "transactions=" + Arrays.toString(transactions) +
                ", sender='" + sender + '\'' +
                ", gasData=" + gasData +
                '}';
    }
}
