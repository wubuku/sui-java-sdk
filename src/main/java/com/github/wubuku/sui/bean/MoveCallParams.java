package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub struct MoveCallParams {
 *     pub package_object_id: ObjectID,
 *     pub module: String,
 *     pub function: String,
 *     #[serde(default)]
 *     pub type_arguments: Vec<SuiTypeTag>,
 *     pub arguments: Vec<SuiJsonValue>,
 * }
 * </pre>
 */
public class MoveCallParams {
    private String packageObjectId;
    private String module;
    private String function;
    private String[] typeArguments;
    private SuiJsonValue[] arguments;

    public MoveCallParams() {
    }

    public MoveCallParams(String packageObjectId, String module, String function, String[] typeArguments, SuiJsonValue[] arguments) {
        this.packageObjectId = packageObjectId;
        this.module = module;
        this.function = function;
        this.typeArguments = typeArguments;
        this.arguments = arguments;
    }

    public String getPackageObjectId() {
        return packageObjectId;
    }

    public void setPackageObjectId(String packageObjectId) {
        this.packageObjectId = packageObjectId;
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
        return "MoveCallParams{" +
                "packageObjectId='" + packageObjectId + '\'' +
                ", module='" + module + '\'' +
                ", function='" + function + '\'' +
                ", typeArguments=" + Arrays.toString(typeArguments) +
                ", arguments=" + Arrays.toString(arguments) +
                '}';
    }
}
