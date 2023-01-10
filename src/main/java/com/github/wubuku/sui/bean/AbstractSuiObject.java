package com.github.wubuku.sui.bean;

public abstract class AbstractSuiObject<T> {
    private T data;
    private ObjectOwner owner;
    private String previousTransaction;
    private Long storageRebate;
    private SuiObjectRef reference;

    public AbstractSuiObject() {
    }

    public AbstractSuiObject(T data,
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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
        return "AbstractSuiObject{" +
                "data=" + data +
                ", owner=" + owner +
                ", previousTransaction='" + previousTransaction + '\'' +
                ", storageRebate=" + storageRebate +
                ", reference=" + reference +
                '}';
    }
}
