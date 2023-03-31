package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(
 *     rename = "TransactionBlockEffectsModifiedAtVersions",
 *     rename_all = "camelCase"
 * )]
 * pub struct SuiTransactionBlockEffectsModifiedAtVersions {
 *     object_id: ObjectID,
 *     sequence_number: SequenceNumber,
 * }
 * </pre>
 */
public class SuiTransactionBlockEffectsModifiedAtVersions {
    private String objectId;
    private BigInteger sequenceNumber;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public BigInteger getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(BigInteger sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        return "SuiTransactionBlockEffectsModifiedAtVersions{" +
                "objectId='" + objectId + '\'' +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}
