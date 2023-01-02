package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiTransactionData = {
 *   transactions: SuiTransactionKind[];
 *   sender: SuiAddress;
 *   gasPayment: SuiObjectRef;
 *   gasBudget: number;
 * };
 * </pre>
 */
public class SuiTransactionData {
    private SuiTransactionKind[] transactions;
    private String sender;
    private SuiObjectRef gasPayment;
    private Long gasBudget;

    public SuiTransactionData() {
    }

    public SuiTransactionData(SuiTransactionKind[] transactions, String sender, SuiObjectRef gasPayment, Long gasBudget) {
        this.transactions = transactions;
        this.sender = sender;
        this.gasPayment = gasPayment;
        this.gasBudget = gasBudget;
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

    @Override
    public String toString() {
        return "SuiTransactionData{" +
                "transactions=" + Arrays.toString(transactions) +
                ", sender='" + sender + '\'' +
                ", gasPayment=" + gasPayment +
                ", gasBudget=" + gasBudget +
                '}';
    }
}
