package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

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

    @JsonProperty("signers_map")
    private int[] signersMap;

    public AuthorityQuorumSignInfo() {
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

    public int[] getSignersMap() {
        return signersMap;
    }

    public void setSignersMap(int[] signersMap) {
        this.signersMap = signersMap;
    }

    @Override
    public String toString() {
        return "AuthorityQuorumSignInfo{" +
                "epoch=" + epoch +
                ", signature=" + signature +
                ", signersMap=" + Arrays.toString(signersMap) +
                '}';
    }
}
