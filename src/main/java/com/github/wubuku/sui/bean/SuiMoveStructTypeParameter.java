package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 *
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveStructTypeParameter {
 *     pub constraints: SuiMoveAbilitySet,
 *     pub is_phantom: bool,
 * }
 * </pre>
 */
public class SuiMoveStructTypeParameter {
    private SuiMoveAbilitySet constraints;
    @JsonProperty("is_phantom")
    private Boolean isPhantom;

    public SuiMoveStructTypeParameter() {
    }

    public SuiMoveStructTypeParameter(SuiMoveAbilitySet constraints, Boolean isPhantom) {
        this.constraints = constraints;
        this.isPhantom = isPhantom;
    }

    public SuiMoveAbilitySet getConstraints() {
        return constraints;
    }

    public void setConstraints(SuiMoveAbilitySet constraints) {
        this.constraints = constraints;
    }

    public Boolean getPhantom() {
        return isPhantom;
    }

    public void setPhantom(Boolean phantom) {
        isPhantom = phantom;
    }

    @Override
    public String toString() {
        return "SuiMoveStructTypeParameter{" +
                "constraints=" + constraints +
                ", isPhantom=" + isPhantom +
                '}';
    }
}
