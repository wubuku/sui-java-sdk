package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type EpochId = number;
 *
 * export type AuthorityQuorumSignInfo = {
 *   epoch: EpochId;
 *   signature: GenericAuthoritySignature;
 * };
 * </pre>
 */
public class AuthorityQuorumSignInfo {
    private Long epoch;
    private GenericAuthoritySignature signature;

    public AuthorityQuorumSignInfo() {
    }

    public AuthorityQuorumSignInfo(Long epoch, GenericAuthoritySignature signature) {
        this.epoch = epoch;
        this.signature = signature;
    }

    public Long getEpoch() {
        return epoch;
    }

    public void setEpoch(Long epoch) {
        this.epoch = epoch;
    }

    public GenericAuthoritySignature getSignature() {
        return signature;
    }

    public void setSignature(GenericAuthoritySignature signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "AuthorityQuorumSignInfo{" +
                "epoch=" + epoch +
                ", signature=" + signature +
                '}';
    }
}
