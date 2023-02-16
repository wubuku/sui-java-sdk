package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone)]
 * #[serde(rename = "TransactionData", rename_all = "camelCase")]
 * pub struct SuiTransactionData {
 *     pub transactions: Vec<SuiTransactionKind>,
 *     pub sender: SuiAddress,
 *     pub gas_payment: SuiObjectRef,
 *     pub gas_price: u64,
 *     pub gas_budget: u64,
 * }
 * </pre>
 */
public class SuiTransactionData {
    private SuiTransactionKind[] transactions;
    private String sender;
    private SuiObjectRef gasPayment;
    private Long gasPrice;
    private Long gasBudget;

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

    public SuiObjectRef getGasPayment() {
        return gasPayment;
    }

    public void setGasPayment(SuiObjectRef gasPayment) {
        this.gasPayment = gasPayment;
    }

    public Long getGasBudget() {
        return gasBudget;
    }

    public void setGasBudget(Long gasBudget) {
        this.gasBudget = gasBudget;
    }

    public Long getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(Long gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "SuiTransactionData{" +
                "transactions=" + Arrays.toString(transactions) +
                ", sender='" + sender + '\'' +
                ", gasPayment=" + gasPayment +
                ", gasPrice=" + gasPrice +
                ", gasBudget=" + gasBudget +
                '}';
    }
}
