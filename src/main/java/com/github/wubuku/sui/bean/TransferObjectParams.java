package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub struct TransferObjectParams {
 *     pub recipient: SuiAddress,
 *     pub object_id: ObjectID,
 * }
 * </pre>
 */
public class TransferObjectParams {
    private String recipient;
    private String objectId;

    public TransferObjectParams() {
    }

    public TransferObjectParams(String recipient, String objectId) {
        this.recipient = recipient;
        this.objectId = objectId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "TransferObjectParams{" +
                "recipient='" + recipient + '\'' +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
