package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 *  #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema, Default)]
 * #[serde(rename_all = "camelCase", rename = "ObjectResponseQuery", default)]
 * pub struct SuiObjectResponseQuery {
 *     /// If None, no filter will be applied
 *     pub filter: Option<SuiObjectDataFilter>,
 *     /// config which fields to include in the response, by default only digest is included
 *     pub options: Option<SuiObjectDataOptions>,
 * }
 * </pre>
 */
public class SuiObjectResponseQuery {
    private SuiObjectDataFilter filter;
    private SuiObjectDataOptions options;

    public SuiObjectResponseQuery(SuiObjectDataFilter filter, SuiObjectDataOptions options) {
        this.filter = filter;
        this.options = options;
    }

    public SuiObjectResponseQuery() {
    }

    public SuiObjectDataFilter getFilter() {
        return filter;
    }

    public void setFilter(SuiObjectDataFilter filter) {
        this.filter = filter;
    }

    public SuiObjectDataOptions getOptions() {
        return options;
    }

    public void setOptions(SuiObjectDataOptions options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "SuiObjectResponseQuery{" +
                "filter=" + filter +
                ", options=" + options +
                '}';
    }
}
