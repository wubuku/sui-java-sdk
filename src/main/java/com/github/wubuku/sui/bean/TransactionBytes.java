package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type TransactionBytes = {
 *   txBytes: string;
 *   gas: SuiObjectRef;
 *   // ...Add input_objects field
 * };
 * </pre>
 */
public class TransactionBytes {
    private String txBytes;
    private SuiObjectRef gas;
    private InputObjectKind[] inputObjects;

    public TransactionBytes() {
    }

    public TransactionBytes(String txBytes, SuiObjectRef gas, InputObjectKind[] inputObjects) {
        this.txBytes = txBytes;
        this.gas = gas;
        this.inputObjects = inputObjects;
    }

    public String getTxBytes() {
        return txBytes;
    }

    public void setTxBytes(String txBytes) {
        this.txBytes = txBytes;
    }

    public SuiObjectRef getGas() {
        return gas;
    }

    public void setGas(SuiObjectRef gas) {
        this.gas = gas;
    }

    public InputObjectKind[] getInputObjects() {
        return inputObjects;
    }

    public void setInputObjects(InputObjectKind[] inputObjects) {
        this.inputObjects = inputObjects;
    }

    @Override
    public String toString() {
        return "TransactionBytes{" +
                "txBytes='" + txBytes + '\'' +
                ", gas=" + gas +
                ", inputObjects=" + Arrays.toString(inputObjects) +
                '}';
    }
}
