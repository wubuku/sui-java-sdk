package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * pub enum SuiTransactionBuilderMode {
 *     /// Regular Sui Transactions that are committed on chain
 *     Commit,
 *     /// Simulated transaction that allows calling any Move function with
 *     /// arbitrary values.
 *     DevInspect,
 * }
 * </pre>
 */
public class SuiTransactionBuilderMode {
    public static final String COMMIT = "Commit";
    public static final String DEV_INSPECT = "DevInspect";

    private SuiTransactionBuilderMode() {
    }
}
