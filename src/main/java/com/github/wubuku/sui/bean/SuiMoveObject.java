package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 *     export type SuiMoveObject = {
 *         // Move type (e.g., "0x2::coin::Coin<0x2::sui::SUI>")
 *         type: string;
 *         // Fields and values stored inside the Move object
 *         fields: ObjectContentFields;
 *         has_public_transfer?: boolean;
 *     };
 * </pre>
 */
public class SuiMoveObject {
    private String type;
    private ObjectContentFields fields;
    @JsonProperty("has_public_transfer")
    private Boolean hasPublicTransfer;

    public SuiMoveObject() {
    }

    public SuiMoveObject(String type, ObjectContentFields fields, Boolean hasPublicTransfer) {
        this.type = type;
        this.fields = fields;
        this.hasPublicTransfer = hasPublicTransfer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectContentFields getFields() {
        return fields;
    }

    public void setFields(ObjectContentFields fields) {
        this.fields = fields;
    }

    public Boolean getHasPublicTransfer() {
        return hasPublicTransfer;
    }

    public void setHasPublicTransfer(Boolean hasPublicTransfer) {
        this.hasPublicTransfer = hasPublicTransfer;
    }

    @Override
    public String toString() {
        return "SuiMoveObject{" +
                "type='" + type + '\'' +
                ", fields=" + fields +
                ", hasPublicTransfer=" + hasPublicTransfer +
                '}';
    }
}
