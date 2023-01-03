package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type StructTag = {
 *   address: string;
 *   module: string;
 *   name: string;
 *   typeParams: TypeTag[];
 * };
 * </pre>
 */
public class StructTag {
    private String address;
    private String module;
    private String name;
    private TypeTag[] typeParams;

    public StructTag() {
    }

    public StructTag(String address, String module, String name, TypeTag[] typeParams) {
        this.address = address;
        this.module = module;
        this.name = name;
        this.typeParams = typeParams;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeTag[] getTypeParams() {
        return typeParams;
    }

    public void setTypeParams(TypeTag[] typeParams) {
        this.typeParams = typeParams;
    }

    @Override
    public String toString() {
        return "StructTag{" +
                "address='" + address + '\'' +
                ", module='" + module + '\'' +
                ", name='" + name + '\'' +
                ", typeParams=" + Arrays.toString(typeParams) +
                '}';
    }
}
