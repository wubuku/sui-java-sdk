package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 *    export type SuiObject = {
 *         // The meat of the object
 *         data: SuiData;
 *         // The owner of the object
 *         owner: ObjectOwner;
 *         // The digest of the transaction that created or last mutated this object
 *         previousTransaction: TransactionDigest;
 *          // The amount of SUI we would rebate if this object gets deleted.
 *          // This number is re-calculated each time the object is mutated based on
 *          // the present storage gas price.
 *         storageRebate: number;
 *         reference: SuiObjectRef;
 *     };
 * </pre>
 */
public class SuiObject {
    private SuiData data;
    private ObjectOwner owner;
    private String previousTransaction;
    private Long storageRebate;
    private SuiObjectRef reference;

    public SuiObject() {
    }

    public SuiObject(SuiData data,
                     ObjectOwner owner,
                     String previousTransaction,
                     Long storageRebate,
                     SuiObjectRef reference
    ) {
        this.data = data;
        this.owner = owner;
        this.previousTransaction = previousTransaction;
        this.storageRebate = storageRebate;
        this.reference = reference;
    }

    public SuiData getData() {
        return data;
    }

    public void setData(SuiData data) {
        this.data = data;
    }

    public ObjectOwner getOwner() {
        return owner;
    }

    public void setOwner(ObjectOwner owner) {
        this.owner = owner;
    }

    public String getPreviousTransaction() {
        return previousTransaction;
    }

    public void setPreviousTransaction(String previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    public Long getStorageRebate() {
        return storageRebate;
    }

    public void setStorageRebate(Long storageRebate) {
        this.storageRebate = storageRebate;
    }

    public SuiObjectRef getReference() {
        return reference;
    }

    public void setReference(SuiObjectRef reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "SuiObject{" +
                "data=" + data +
                ", owner=" + owner +
                ", previousTransaction='" + previousTransaction + '\'' +
                ", storageRebate=" + storageRebate +
                ", reference=" + reference +
                '}';
    }
}
