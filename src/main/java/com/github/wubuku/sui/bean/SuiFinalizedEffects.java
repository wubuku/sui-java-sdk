package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "FinalizedEffects", rename_all = "camelCase")]
 * pub struct SuiFinalizedEffects {
 *     pub transaction_effects_digest: TransactionEffectsDigest,
 *     pub effects: SuiTransactionEffects,
 *     pub finality_info: SuiEffectsFinalityInfo,
 * }
 * </pre>
 */
public class SuiFinalizedEffects {
    private String transactionEffectsDigest;
    private SuiTransactionEffects effects;
    private SuiEffectsFinalityInfo finalityInfo;

    public String getTransactionEffectsDigest() {
        return transactionEffectsDigest;
    }

    public void setTransactionEffectsDigest(String transactionEffectsDigest) {
        this.transactionEffectsDigest = transactionEffectsDigest;
    }

    public SuiTransactionEffects getEffects() {
        return effects;
    }

    public void setEffects(SuiTransactionEffects effects) {
        this.effects = effects;
    }

    public SuiEffectsFinalityInfo getFinalityInfo() {
        return finalityInfo;
    }

    public void setFinalityInfo(SuiEffectsFinalityInfo finalityInfo) {
        this.finalityInfo = finalityInfo;
    }

    @Override
    public String toString() {
        return "SuiFinalizedEffects{" +
                "transactionEffectsDigest='" + transactionEffectsDigest + '\'' +
                ", effects=" + effects +
                ", finalityInfo=" + finalityInfo +
                '}';
    }
}
