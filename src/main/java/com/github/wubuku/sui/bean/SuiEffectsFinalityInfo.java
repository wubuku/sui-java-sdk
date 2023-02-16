package com.github.wubuku.sui.bean;

import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "EffectsFinalityInfo", rename_all = "camelCase")]
 * pub enum SuiEffectsFinalityInfo {
 *     Certified(SuiAuthorityStrongQuorumSignInfo),
 *     Checkpointed(EpochId, CheckpointSequenceNumber),
 * }
 * </pre>
 */
public class SuiEffectsFinalityInfo { //todo let's make SuiEffectsFinalityInfo an interface and have two implementations
    private SuiAuthorityStrongQuorumSignInfo certified;
    private java.util.List<Object> checkpointed;

    public SuiAuthorityStrongQuorumSignInfo getCertified() {
        return certified;
    }

    public void setCertified(SuiAuthorityStrongQuorumSignInfo certified) {
        this.certified = certified;
    }

    public List<Object> getCheckpointed() {
        return checkpointed;
    }

    public void setCheckpointed(List<Object> checkpointed) {
        this.checkpointed = checkpointed;
    }
}
