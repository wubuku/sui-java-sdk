package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 *  pub struct SuiProgrammableMoveCall {
 *  /// The package containing the module and function.
 *  pub package: ObjectID,
 *  /// The specific module in the package containing the function.
 *  pub module: String,
 *  /// The function to be called.
 *  pub function: String,
 *  #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *  /// The type arguments to the function.
 *  pub type_arguments: Vec<String>,
 *  #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *  /// The arguments to the function.
 *  pub arguments: Vec<SuiArgument>,
 *  }
 * </pre>
 */
public class SuiProgrammableMoveCall {
    @JsonProperty("package")
    private String package_;
    private String module;
    private String function;
    @JsonProperty("type_arguments")
    private String[] typeArguments;
    private SuiArgument[] arguments;

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

    public SuiArgument[] getArguments() {
        return arguments;
    }

    public void setArguments(SuiArgument[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "SuiProgrammableMoveCall{" +
                "package_='" + package_ + '\'' +
                ", module='" + module + '\'' +
                ", function='" + function + '\'' +
                ", typeArguments=" + Arrays.toString(typeArguments) +
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
