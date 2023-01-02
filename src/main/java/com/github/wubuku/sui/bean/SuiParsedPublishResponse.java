package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiParsedPublishResponse = {
 *   createdObjects: SuiObject[];
 *   package: SuiPackage;
 *   updatedGas: SuiObject;
 * };
 * </pre>
 */
public class SuiParsedPublishResponse {
    private SuiObject[] createdObjects;
    private SuiPackage suiPackage;
    private SuiObject updatedGas;

    public SuiParsedPublishResponse() {
    }

    public SuiParsedPublishResponse(SuiObject[] createdObjects, SuiPackage suiPackage, SuiObject updatedGas) {
        this.createdObjects = createdObjects;
        this.suiPackage = suiPackage;
        this.updatedGas = updatedGas;
    }

    public SuiObject[] getCreatedObjects() {
        return createdObjects;
    }

    public void setCreatedObjects(SuiObject[] createdObjects) {
        this.createdObjects = createdObjects;
    }

    public SuiPackage getSuiPackage() {
        return suiPackage;
    }

    public void setSuiPackage(SuiPackage suiPackage) {
        this.suiPackage = suiPackage;
    }

    public SuiObject getUpdatedGas() {
        return updatedGas;
    }

    public void setUpdatedGas(SuiObject updatedGas) {
        this.updatedGas = updatedGas;
    }

    @Override
    public String toString() {
        return "SuiParsedPublishResponse{" +
                "createdObjects=" + Arrays.toString(createdObjects) +
                ", suiPackage=" + suiPackage +
                ", updatedGas=" + updatedGas +
                '}';
    }
}
