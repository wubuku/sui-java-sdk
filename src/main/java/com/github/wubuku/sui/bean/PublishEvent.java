package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type PublishEvent = {
 *   sender: SuiAddress;
 *   packageId: ObjectId;
 * };
 * </pre>
 */
public class PublishEvent {
    private String sender;
    private String packageId;

    public PublishEvent() {
    }

    public PublishEvent(String sender, String packageId) {
        this.sender = sender;
        this.packageId = packageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        return "PublishEvent{" +
                "sender='" + sender + '\'' +
                ", packageId='" + packageId + '\'' +
                '}';
    }
}
