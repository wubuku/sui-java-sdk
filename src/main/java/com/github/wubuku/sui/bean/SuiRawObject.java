package com.github.wubuku.sui.bean;


public class SuiRawObject extends AbstractSuiObject<SuiRawData> {

    public SuiRawObject() {
    }

    public SuiRawObject(SuiRawData data,
                        ObjectOwner owner,
                        String previousTransaction,
                        Long storageRebate,
                        SuiObjectRef reference
    ) {
        super(data, owner, previousTransaction, storageRebate, reference);
    }

    @Override
    public String toString() {
        return "SuiRawObject{" +
                "data=" + getData() +
                ", owner=" + getOwner() +
                ", previousTransaction='" + getPreviousTransaction() + '\'' +
                ", storageRebate=" + getStorageRebate() +
                ", reference=" + getReference() +
                '}';
    }
}
