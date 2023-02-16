package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "MoveCall", rename_all = "camelCase")]
 * pub struct SuiMoveCall {
 *     pub package: ObjectID,
 *     pub module: String,
 *     pub function: String,
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub type_arguments: Vec<String>,
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub arguments: Vec<SuiJsonValue>,
 * }
 * </pre>
 */
public class MoveCall {
    @JsonProperty("package")
    private String package_;
    private String module;
    private String function;
    private String[] typeArguments;
    private SuiJsonValue[] arguments;

    public MoveCall() {
    }

    public MoveCall(String package_, String module, String function, String[] typeArguments, SuiJsonValue[] arguments) {
        this.package_ = package_;
        this.module = module;
        this.function = function;
        this.typeArguments = typeArguments;
        this.arguments = arguments;
    }

    public String getPackage_() {
        return package_;
    }

    public void setPackage_(String package_) {
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
