package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type TransferObject = {
 *   recipient: SuiAddress;
 *   objectRef: SuiObjectRef;
 * };
 * </pre>
 */
public class TransferObject {
    private String recipient;
    private SuiObjectRef objectRef;

    public TransferObject() {
    }

    public TransferObject(String recipient, SuiObjectRef objectRef) {
        this.recipient = recipient;
        this.objectRef = objectRef;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public SuiObjectRef getObjectRef() {
        return objectRef;
    }

    public void setObjectRef(SuiObjectRef objectRef) {
        this.objectRef = objectRef;
    }

    @Override
    public String toString() {
        return "TransferObject{" +
                "recipient='" + recipient + '\'' +
                ", objectRef=" + objectRef +
                '}';
    }
}
