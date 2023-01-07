package com.github.wubuku.sui.bean;

import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// The response from processing a dev inspect transaction
 * #[derive(Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "DevInspectResults", rename_all = "camelCase")]
 * pub struct DevInspectResults {
 *     /// Summary of effects that likely would be generated if the transaction is actually run.
 *     /// Note however, that not all dev-inspect transactions are actually usable as transactions so
 *     /// it might not be possible actually generate these effects from a normal transaction.
 *     pub effects: SuiTransactionEffects,
 *     /// Execution results (including return values) from executing the transactions
 *     /// Currently contains only return values from Move calls
 *     pub results: Result<Vec<(usize, SuiExecutionResult)>, String>,
 * }
 * </pre>
 */
public class DevInspectResults {
    private TransactionEffects effects;
    private Result<List<UnsignedIntAndSuiExecutionResultTuple>, String> results;

    public DevInspectResults() {
    }

    public DevInspectResults(TransactionEffects effects, Result<List<UnsignedIntAndSuiExecutionResultTuple>,
            String> results) {
        this.effects = effects;
        this.results = results;
    }

    public TransactionEffects getEffects() {
        return effects;
    }

    public void setEffects(TransactionEffects effects) {
        this.effects = effects;
    }

    public Result<List<UnsignedIntAndSuiExecutionResultTuple>, String> getResults() {
        return results;
    }

    public void setResults(Result<List<UnsignedIntAndSuiExecutionResultTuple>, String> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "DevInspectResults{" +
                "effects=" + effects +
                ", results=" + results +
                '}';
    }
}
