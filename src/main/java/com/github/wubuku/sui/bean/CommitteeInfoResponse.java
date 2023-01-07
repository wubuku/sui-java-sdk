package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Clone, schemars::JsonSchema, Debug)]
 * pub struct CommitteeInfoResponse {
 *     pub epoch: EpochId,
 *     pub committee_info: Option<Vec<(AuthorityName, StakeUnit)>>,
 *     // TODO: We could also return the certified checkpoint that contains this committee.
 *     // This would allows a client to verify the authenticity of the committee.
 * }
 * </pre>
 */
public class CommitteeInfoResponse {
    private BigInteger epoch;
    @JsonProperty("committee_info")
    private List<StringAndU64Tuple> committeeInfo;

    public CommitteeInfoResponse() {
    }

    public CommitteeInfoResponse(BigInteger epoch, List<StringAndU64Tuple> committeeInfo) {
        this.epoch = epoch;
        this.committeeInfo = committeeInfo;
    }

    public BigInteger getEpoch() {
        return epoch;
    }

    public void setEpoch(BigInteger epoch) {
        this.epoch = epoch;
    }

    public List<StringAndU64Tuple> getCommitteeInfo() {
        return committeeInfo;
    }

    public void setCommitteeInfo(List<StringAndU64Tuple> committeeInfo) {
        this.committeeInfo = committeeInfo;
    }

    @Override
    public String toString() {
        return "CommitteeInfoResponse{" +
                "epoch=" + epoch +
                ", committeeInfo=" + committeeInfo +
                '}';
    }
}
