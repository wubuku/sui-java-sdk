package com.github.wubuku.sui.bean;


import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveAbilitySet {
 *     pub abilities: Vec<SuiMoveAbility>,
 * }
 * </pre>
 */
public class SuiMoveAbilitySet {
    private SuiMoveAbility[] abilities;

    public SuiMoveAbilitySet() {
    }

    public SuiMoveAbilitySet(SuiMoveAbility[] abilities) {
        this.abilities = abilities;
    }

    public SuiMoveAbility[] getAbilities() {
        return abilities;
    }

    public void setAbilities(SuiMoveAbility[] abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "SuiMoveAbilitySet{" +
                "abilities=" + Arrays.toString(abilities) +
                '}';
    }
}
