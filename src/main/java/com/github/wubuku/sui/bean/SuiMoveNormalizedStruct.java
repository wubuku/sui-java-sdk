package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveNormalizedStruct {
 *     pub abilities: SuiMoveAbilitySet,
 *     pub type_parameters: Vec<SuiMoveStructTypeParameter>,
 *     pub fields: Vec<SuiMoveNormalizedField>,
 * }
 * </pre>
 */
public class SuiMoveNormalizedStruct {
    private SuiMoveAbilitySet abilities;
    @JsonProperty("type_parameters")
    private List<SuiMoveStructTypeParameter> typeParameters;
    private List<SuiMoveNormalizedField> fields;

    public SuiMoveNormalizedStruct() {
    }

    public SuiMoveNormalizedStruct(SuiMoveAbilitySet abilities, List<SuiMoveStructTypeParameter> typeParameters, List<SuiMoveNormalizedField> fields) {
        this.abilities = abilities;
        this.typeParameters = typeParameters;
        this.fields = fields;
    }

    public SuiMoveAbilitySet getAbilities() {
        return abilities;
    }

    public void setAbilities(SuiMoveAbilitySet abilities) {
        this.abilities = abilities;
    }

    public List<SuiMoveStructTypeParameter> getTypeParameters() {
        return typeParameters;
    }

    public void setTypeParameters(List<SuiMoveStructTypeParameter> typeParameters) {
        this.typeParameters = typeParameters;
    }

    public List<SuiMoveNormalizedField> getFields() {
        return fields;
    }

    public void setFields(List<SuiMoveNormalizedField> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "SuiMoveNormalizedStruct{" +
                "abilities=" + abilities +
                ", typeParameters=" + typeParameters +
                ", fields=" + fields +
                '}';
    }
}
