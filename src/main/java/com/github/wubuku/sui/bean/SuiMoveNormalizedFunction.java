package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveNormalizedFunction {
 *     pub visibility: SuiMoveVisibility,
 *     pub is_entry: bool,
 *     pub type_parameters: Vec<SuiMoveAbilitySet>,
 *     pub parameters: Vec<SuiMoveNormalizedType>,
 *     pub return_: Vec<SuiMoveNormalizedType>,
 * }
 * </pre>
 */
public class SuiMoveNormalizedFunction {
    private SuiMoveVisibility visibility;
    @JsonProperty("is_entry")
    private Boolean isEntry;
    @JsonProperty("type_parameters")
    private SuiMoveAbilitySet[] typeParameters;
    private SuiMoveNormalizedType[] parameters;
    @JsonProperty("return_")
    private SuiMoveNormalizedType[] return_;

    public SuiMoveNormalizedFunction() {
    }

    public SuiMoveNormalizedFunction(SuiMoveVisibility visibility,
                                     Boolean isEntry,
                                     SuiMoveAbilitySet[] typeParameters,
                                     SuiMoveNormalizedType[] parameters,
                                     SuiMoveNormalizedType[] return_) {
        this.visibility = visibility;
        this.isEntry = isEntry;
        this.typeParameters = typeParameters;
        this.parameters = parameters;
        this.return_ = return_;
    }

    public SuiMoveVisibility getVisibility() {
        return visibility;
    }

    public void setVisibility(SuiMoveVisibility visibility) {
        this.visibility = visibility;
    }

    public Boolean getIsEntry() {
        return isEntry;
    }

    public void setIsEntry(Boolean entry) {
        isEntry = entry;
    }

    public SuiMoveAbilitySet[] getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(SuiMoveAbilitySet[] typeParameters) {
        this.typeParameters = typeParameters;
    }

    public SuiMoveNormalizedType[] getParameters() {
        return parameters;
    }

    public void setParameters(SuiMoveNormalizedType[] parameters) {
        this.parameters = parameters;
    }

    public SuiMoveNormalizedType[] getReturn_() {
        return return_;
    }

    public void setReturn_(SuiMoveNormalizedType[] return_) {
        this.return_ = return_;
    }

    @Override
    public String toString() {
        return "SuiMoveNormalizedFunction{" +
                "visibility=" + visibility +
                ", isEntry=" + isEntry +
                ", typeParameters=" + Arrays.toString(typeParameters) +
                ", parameters=" + Arrays.toString(parameters) +
                ", return_=" + Arrays.toString(return_) +
                '}';
    }
}
