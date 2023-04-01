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
public class SuiObject extends AbstractSuiObject<SuiParsedData> {

    public SuiObject() {
    }

    public SuiObject(SuiParsedData data,
                     ObjectOwner owner,
                     String previousTransaction,
                     Long storageRebate,
                     SuiObjectRef reference
    ) {
        super(data, owner, previousTransaction, storageRebate, reference);
    }

    @Override
    public String toString() {
        return "SuiObject{" +
                "data=" + getData() +
                ", owner=" + getOwner() +
                ", previousTransaction='" + getPreviousTransaction() + '\'' +
                ", storageRebate=" + getStorageRebate() +
                ", reference=" + getReference() +
                '}';
    }
}
