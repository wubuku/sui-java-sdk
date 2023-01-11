package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Serialize, Deserialize, JsonSchema, Ord, PartialOrd, Eq, PartialEq, Debug)]
 * pub enum DynamicFieldType {
 *     #[serde(rename_all = "camelCase")]
 *     DynamicField,
 *     DynamicObject,
 * }
 * </pre>
 */
public class DynamicFieldType {
    public static final String DYNAMIC_FIELD = "DynamicField";
    public static final String DYNAMIC_OBJECT = "DynamicObject";

    private DynamicFieldType() {
    }
}
