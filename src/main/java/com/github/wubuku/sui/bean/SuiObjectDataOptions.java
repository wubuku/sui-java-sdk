package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema, Eq, PartialEq, Default)]
 * #[serde(rename_all = "camelCase", rename = "ObjectDataOptions", default)]
 * pub struct SuiObjectDataOptions {
 *     /// Whether to show the type of the object. Default to be False
 *     pub show_type: bool,
 *     /// Whether to show the owner of the object. Default to be False
 *     pub show_owner: bool,
 *     /// Whether to show the previous transaction digest of the object. Default to be False
 *     pub show_previous_transaction: bool,
 *     /// Whether to show the Display metadata of the object for frontend rendering. Default to be False
 *     pub show_display: bool,
 *     /// Whether to show the content(i.e., package content or Move struct content) of the object.
 *     /// Default to be False
 *     pub show_content: bool,
 *     /// Whether to show the content in BCS format. Default to be False
 *     pub show_bcs: bool,
 *     /// Whether to show the storage rebate of the object. Default to be False
 *     pub show_storage_rebate: bool,
 * }
 * </pre>
 */
public class SuiObjectDataOptions {
    private boolean showType;
    private boolean showOwner;
    private boolean showPreviousTransaction;
    private boolean showDisplay;
    private boolean showContent;
    private boolean showBcs;
    private boolean showStorageRebate;

    public SuiObjectDataOptions() {
    }

    public SuiObjectDataOptions(boolean showType, boolean showOwner, boolean showPreviousTransaction, boolean showDisplay, boolean showContent, boolean showBcs, boolean showStorageRebate) {
        this.showType = showType;
        this.showOwner = showOwner;
        this.showPreviousTransaction = showPreviousTransaction;
        this.showDisplay = showDisplay;
        this.showContent = showContent;
        this.showBcs = showBcs;
        this.showStorageRebate = showStorageRebate;
    }

    public boolean isShowType() {
        return showType;
    }

    public void setShowType(boolean showType) {
        this.showType = showType;
    }

    public boolean isShowOwner() {
        return showOwner;
    }

    public void setShowOwner(boolean showOwner) {
        this.showOwner = showOwner;
    }

    public boolean isShowPreviousTransaction() {
        return showPreviousTransaction;
    }

    public void setShowPreviousTransaction(boolean showPreviousTransaction) {
        this.showPreviousTransaction = showPreviousTransaction;
    }

    public boolean isShowDisplay() {
        return showDisplay;
    }

    public void setShowDisplay(boolean showDisplay) {
        this.showDisplay = showDisplay;
    }

    public boolean isShowContent() {
        return showContent;
    }

    public void setShowContent(boolean showContent) {
        this.showContent = showContent;
    }

    public boolean isShowBcs() {
        return showBcs;
    }

    public void setShowBcs(boolean showBcs) {
        this.showBcs = showBcs;
    }

    public boolean isShowStorageRebate() {
        return showStorageRebate;
    }

    public void setShowStorageRebate(boolean showStorageRebate) {
        this.showStorageRebate = showStorageRebate;
    }

    @Override
    public String toString() {
        return "SuiObjectDataOptions{" +
                "showType=" + showType +
                ", showOwner=" + showOwner +
                ", showPreviousTransaction=" + showPreviousTransaction +
                ", showDisplay=" + showDisplay +
                ", showContent=" + showContent +
                ", showBcs=" + showBcs +
                ", showStorageRebate=" + showStorageRebate +
                '}';
    }
}
