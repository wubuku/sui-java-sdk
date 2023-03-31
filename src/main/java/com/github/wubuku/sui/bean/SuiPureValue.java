package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Eq, PartialEq, Debug, Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub struct SuiPureValue {
 *     #[schemars(with = "Option<String>")]
 *     #[serde_as(as = "Option<AsSuiTypeTag>")]
 *     value_type: Option<TypeTag>,
 *     value: SuiJsonValue,
 * }
 * </pre>
 */
public class SuiPureValue {
    private String valueType;
    private SuiJsonValue value;

    public SuiPureValue() {
    }

    public SuiPureValue(String valueType, SuiJsonValue value) {
        this.valueType = valueType;
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public SuiJsonValue getValue() {
        return value;
    }

    public void setValue(SuiJsonValue value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SuiPureValue{" +
                "valueType='" + valueType + '\'' +
                ", value=" + value +
                '}';
    }
}
