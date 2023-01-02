package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type MoveCall = {
 *   package: SuiObjectRef;
 *   module: string;
 *   function: string;
 *   typeArguments?: string[];
 *   arguments?: SuiJsonValue[];
 * };
 * </pre>
 */
public class MoveCall {
    @JsonProperty("package")
    private SuiObjectRef package_;
    private String module;
    private String function;
    private String[] typeArguments;
    private SuiJsonValue[] arguments;

    public MoveCall() {
    }

    public MoveCall(SuiObjectRef package_, String module, String function, String[] typeArguments, SuiJsonValue[] arguments) {
        this.package_ = package_;
        this.module = module;
        this.function = function;
        this.typeArguments = typeArguments;
        this.arguments = arguments;
    }

    public SuiObjectRef getPackage_() {
        return package_;
    }

    public void setPackage_(SuiObjectRef package_) {
        this.package_ = package_;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String[] getTypeArguments() {
        return typeArguments;
    }

    public void setTypeArguments(String[] typeArguments) {
        this.typeArguments = typeArguments;
    }

    public SuiJsonValue[] getArguments() {
        return arguments;
    }

    public void setArguments(SuiJsonValue[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "MoveCall{" +
                "package_=" + package_ +
                ", module='" + module + '\'' +
                ", function='" + function + '\'' +
                ", typeArguments=" + Arrays.toString(typeArguments) +
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
