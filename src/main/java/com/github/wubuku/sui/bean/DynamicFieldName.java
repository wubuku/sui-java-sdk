package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Clone, Serialize, Deserialize, JsonSchema, Debug)]
 * #[serde(rename_all = "camelCase")]
 * pub struct DynamicFieldName {
 *     #[schemars(with = "String")]
 *     #[serde_as(as = "Readable<SuiTypeTag, _>")]
 *     pub type_: TypeTag,
 *     // Bincode does not like serde_json::Value, rocksdb will not insert the value without serializing value as string.
 *     // TODO: investigate if this can be removed after switch to BCS.
 *     #[schemars(with = "Value")]
 *     #[serde_as(as = "Readable<_, DisplayFromStr>")]
 *     pub value: Value,
 * }
 * </pre>
 */
public class DynamicFieldName {
    private String type;
    private String value;

    public DynamicFieldName() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DynamicFieldName{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
