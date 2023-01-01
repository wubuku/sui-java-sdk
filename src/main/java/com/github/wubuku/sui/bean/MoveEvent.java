package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type MoveEvent = {
 * packageId: ObjectId;
 * transactionModule: string;
 * sender: SuiAddress;
 * type: string;
 * fields?: { [key: string]: any };
 * bcs: string;
 * };
 * </pre>
 */
public class MoveEvent<F> {
    private String packageId;
    private String transactionModule;
    private String sender;
    private String type;
    /**
     * For example:
     * <p>
     * <pre>
     * "fields" : {
     * "creator" : "0x62526c18d088b7c8557d57deede9362b91e8b4d3",
     * "name" : "Suiet NFT",
     * "object_id" : "0xe6d7719e65454323762f597c7d140ea4f1905e65"
     * },
     * </pre>
     */
    private F fields;
    private String bcs;

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getTransactionModule() {
        return transactionModule;
    }

    public void setTransactionModule(String transactionModule) {
        this.transactionModule = transactionModule;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public F getFields() {
        return fields;
    }

    public void setFields(F fields) {
        this.fields = fields;
    }

    public String getBcs() {
        return bcs;
    }

    public void setBcs(String bcs) {
        this.bcs = bcs;
    }

    @Override
    public String toString() {
        return "MoveEvent{" +
                "packageId='" + packageId + '\'' +
                ", transactionModule='" + transactionModule + '\'' +
                ", sender='" + sender + '\'' +
                ", type='" + type + '\'' +
                ", fields=" + fields +
                ", bcs='" + bcs + '\'' +
                '}';
    }
}
