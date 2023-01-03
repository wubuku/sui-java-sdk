package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * // TODO: change the tuple to struct from the server end
 * export type OwnedObjectRef = {
 *   owner: ObjectOwner;
 *   reference: SuiObjectRef;
 * };
 * </pre>
 */
public class OwnedObjectRef {
    private ObjectOwner owner;
    private SuiObjectRef reference;

    public OwnedObjectRef() {
    }

    public OwnedObjectRef(ObjectOwner owner, SuiObjectRef reference) {
        this.owner = owner;
        this.reference = reference;
    }

    public ObjectOwner getOwner() {
        return owner;
    }

    public void setOwner(ObjectOwner owner) {
        this.owner = owner;
    }

    public SuiObjectRef getReference() {
        return reference;
    }

    public void setReference(SuiObjectRef reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "OwnedObjectRef{" +
                "owner=" + owner +
                ", reference=" + reference +
                '}';
    }
}
