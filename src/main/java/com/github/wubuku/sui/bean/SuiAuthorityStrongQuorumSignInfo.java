package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * pub struct SuiAuthorityStrongQuorumSignInfo {
 *     pub epoch: EpochId,
 *     pub signature: AggregateAuthoritySignatureAsBytes,
 *     #[schemars(with = "Base64")]
 *     #[serde_as(as = "SuiBitmap")]
 *     pub signers_map: RoaringBitmap,
 * }
 * </pre>
 */
public class SuiAuthorityStrongQuorumSignInfo {
    private BigInteger epoch;
    private String signature;
    @JsonProperty("signers_map")
    private int[] signersMap;

    public BigInteger getEpoch() {
        return epoch;
    }

    public void setEpoch(BigInteger epoch) {
        this.epoch = epoch;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
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
        return "SuiAuthorityStrongQuorumSignInfo{" +
                "epoch=" + epoch +
                ", signature='" + signature + '\'' +
                ", signersMap=" + Arrays.toString(signersMap) +
                '}';
    }
}
