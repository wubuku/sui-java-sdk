package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveNormalizedField {
 *     pub name: String,
 *     pub type_: SuiMoveNormalizedType,
 * }
 * </pre>
 */
public class SuiMoveNormalizedField {
    private String name;
    @JsonProperty("type_")
    private SuiMoveNormalizedType type;

    public SuiMoveNormalizedField() {
    }

    public SuiMoveNormalizedField(String name, SuiMoveNormalizedType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuiMoveNormalizedType getType() {
        return type;
    }

    public void setType(SuiMoveNormalizedType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "SuiMoveNormalizedField{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
