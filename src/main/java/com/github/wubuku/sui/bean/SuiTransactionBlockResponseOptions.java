package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema, Eq, PartialEq, Default)]
 * #[serde(
 *     rename_all = "camelCase",
 *     rename = "TransactionBlockResponseOptions",
 *     default
 * )]
 * pub struct SuiTransactionBlockResponseOptions {
 *     /// Whether to show transaction input data. Default to be False
 *     pub show_input: bool,
 *     /// Whether to show bcs-encoded transaction input data
 *     pub show_raw_input: bool,
 *     /// Whether to show transaction effects. Default to be False
 *     pub show_effects: bool,
 *     /// Whether to show transaction events. Default to be False
 *     pub show_events: bool,
 *     /// Whether to show object_changes. Default to be False
 *     pub show_object_changes: bool,
 *     /// Whether to show balance_changes. Default to be False
 *     pub show_balance_changes: bool,
 * }
 * </pre>
 */
public class SuiTransactionBlockResponseOptions {
    private boolean showInput;
    private boolean showRawInput;
    private boolean showEffects;
    private boolean showEvents;
    private boolean showObjectChanges;
    private boolean showBalanceChanges;

    public SuiTransactionBlockResponseOptions() {
    }

    public SuiTransactionBlockResponseOptions(boolean showInput, boolean showRawInput, boolean showEffects, boolean showEvents, boolean showObjectChanges, boolean showBalanceChanges) {
        this.showInput = showInput;
        this.showRawInput = showRawInput;
        this.showEffects = showEffects;
        this.showEvents = showEvents;
        this.showObjectChanges = showObjectChanges;
        this.showBalanceChanges = showBalanceChanges;
    }

    public boolean isShowInput() {
        return showInput;
    }

    public void setShowInput(boolean showInput) {
        this.showInput = showInput;
    }

    public boolean isShowRawInput() {
        return showRawInput;
    }

    public void setShowRawInput(boolean showRawInput) {
        this.showRawInput = showRawInput;
    }

    public boolean isShowEffects() {
        return showEffects;
    }

    public void setShowEffects(boolean showEffects) {
        this.showEffects = showEffects;
    }

    public boolean isShowEvents() {
        return showEvents;
    }

    public void setShowEvents(boolean showEvents) {
        this.showEvents = showEvents;
    }

    public boolean isShowObjectChanges() {
        return showObjectChanges;
    }

    public void setShowObjectChanges(boolean showObjectChanges) {
        this.showObjectChanges = showObjectChanges;
    }

    public boolean isShowBalanceChanges() {
        return showBalanceChanges;
    }

    public void setShowBalanceChanges(boolean showBalanceChanges) {
        this.showBalanceChanges = showBalanceChanges;
    }

    @Override
    public String toString() {
        return "SuiTransactionBlockResponseOptions{" +
                "showInput=" + showInput +
                ", showRawInput=" + showRawInput +
                ", showEffects=" + showEffects +
                ", showEvents=" + showEvents +
                ", showObjectChanges=" + showObjectChanges +
                ", showBalanceChanges=" + showBalanceChanges +
                '}';
    }
}
