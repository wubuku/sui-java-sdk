package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema, Clone)]
 * #[serde(tag = "status", content = "details", rename = "ObjectRead")]
 * pub enum SuiPastObjectRead<T: SuiData> {
 *     /// The object exists and is found with this version
 *     VersionFound(SuiObject<T>),
 *     /// The object does not exist
 *     ObjectNotExists(ObjectID),
 *     /// The object is found to be deleted with this version
 *     ObjectDeleted(SuiObjectRef),
 *     /// The object exists but not found with this version
 *     VersionNotFound(ObjectID, SequenceNumber),
 *     /// The asked object version is higher than the latest
 *     VersionTooHigh {
 *         object_id: ObjectID,
 *         asked_version: SequenceNumber,
 *         latest_version: SequenceNumber,
 *     },
 * }
 * </pre>
 */
public class SuiPastObjectRead {
    private SuiPastObjectReadStatus status;
    private Details details;

    public SuiPastObjectRead() {
    }

    public SuiPastObjectRead(SuiPastObjectReadStatus status, Details details) {
        this.status = status;
        this.details = details;
    }

    public SuiPastObjectReadStatus getStatus() {
        return status;
    }

    public void setStatus(SuiPastObjectReadStatus status) {
        this.status = status;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "SuiPastObjectRead{" +
                "status=" + status +
                ", details=" + details +
                '}';
    }

    public interface Details {
        //todo
    }
}
