package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "SuiExecutionResult", rename_all = "camelCase")]
 * pub struct SuiExecutionResult {
 *     /// The value of any arguments that were mutably borrowed.
 *     /// Non-mut borrowed values are not included
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub mutable_reference_outputs: Vec<(u8, Vec<u8>, SuiTypeTag)>,
 *     /// The return values from the function
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub return_values: Vec<(Vec<u8>, SuiTypeTag)>,
 * }
 * </pre>
 */
public class SuiExecutionResult {
    private Object[] mutableReferenceOutputs;//todo Vec<(u8, Vec<u8>, SuiTypeTag)>
    private Object[] returnValues;//todo Vec<(Vec<u8>, SuiTypeTag)>

    public SuiExecutionResult() {
    }

    public SuiExecutionResult(Object[] mutableReferenceOutputs, Object[] returnValues) {
        this.mutableReferenceOutputs = mutableReferenceOutputs;
        this.returnValues = returnValues;
    }

    public Object[] getMutableReferenceOutputs() {
        return mutableReferenceOutputs;
    }

    public void setMutableReferenceOutputs(Object[] mutableReferenceOutputs) {
        this.mutableReferenceOutputs = mutableReferenceOutputs;
    }

    public Object[] getReturnValues() {
        return returnValues;
    }

    public void setReturnValues(Object[] returnValues) {
        this.returnValues = returnValues;
    }

    @Override
    public String toString() {
        return "SuiExecutionResult{" +
                "mutableReferenceOutputs=" + Arrays.toString(mutableReferenceOutputs) +
                ", returnValues=" + Arrays.toString(returnValues) +
                '}';
    }
}
