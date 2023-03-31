package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * pub struct SuiProgrammableTransactionBlock {
 *     /// Input objects or primitive values
 *     pub inputs: Vec<SuiCallArg>,
 *     #[serde(rename = "transactions")]
 *     /// The transactions to be executed sequentially. A failure in any transaction will
 *     /// result in the failure of the entire programmable transaction block.
 *     pub commands: Vec<SuiCommand>,
 * }
 * </pre>
 */
public class SuiProgrammableTransactionBlock {
    private SuiCallArg[] inputs;
    private Object[] transactions; //todo SuiCommand[]

    public SuiProgrammableTransactionBlock() {
    }

    public SuiProgrammableTransactionBlock(SuiCallArg[] inputs, Object[] transactions) {
        this.inputs = inputs;
        this.transactions = transactions;
    }

    public SuiCallArg[] getInputs() {
        return inputs;
    }

    public void setInputs(SuiCallArg[] inputs) {
        this.inputs = inputs;
    }

    public Object[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Object[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "SuiProgrammableTransactionBlock{" +
                "inputs=" + Arrays.toString(inputs) +
                ", transactions=" + Arrays.toString(transactions) +
                '}';
    }
}
