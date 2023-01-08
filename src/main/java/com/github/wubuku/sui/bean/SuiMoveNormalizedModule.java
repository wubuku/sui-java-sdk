package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.Map;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveNormalizedModule {
 *     pub file_format_version: u32,
 *     pub address: String,
 *     pub name: String,
 *     pub friends: Vec<SuiMoveModuleId>,
 *     pub structs: BTreeMap<String, SuiMoveNormalizedStruct>,
 *     pub exposed_functions: BTreeMap<String, SuiMoveNormalizedFunction>,
 * }
 * </pre>
 */
public class SuiMoveNormalizedModule {
    @JsonProperty("file_format_version")
    private Long fileFormatVersion;
    private String address;
    private String name;
    private SuiMoveModuleId[] friends;
    private Map<String, SuiMoveNormalizedStruct> structs;
    @JsonProperty("exposed_functions")
    private Map<String, SuiMoveNormalizedFunction> exposedFunctions;

    public SuiMoveNormalizedModule() {
    }

    public Long getFileFormatVersion() {
        return fileFormatVersion;
    }

    public void setFileFormatVersion(Long fileFormatVersion) {
        this.fileFormatVersion = fileFormatVersion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SuiMoveModuleId[] getFriends() {
        return friends;
    }

    public void setFriends(SuiMoveModuleId[] friends) {
        this.friends = friends;
    }

    public Map<String, SuiMoveNormalizedStruct> getStructs() {
        return structs;
    }

    public void setStructs(Map<String, SuiMoveNormalizedStruct> structs) {
        this.structs = structs;
    }

    public Map<String, SuiMoveNormalizedFunction> getExposedFunctions() {
        return exposedFunctions;
    }

    public void setExposedFunctions(Map<String, SuiMoveNormalizedFunction> exposedFunctions) {
        this.exposedFunctions = exposedFunctions;
    }

    @Override
    public String toString() {
        return "SuiMoveNormalizedModule{" +
                "fileFormatVersion=" + fileFormatVersion +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", friends=" + Arrays.toString(friends) +
                ", structs=" + structs +
                ", exposedFunctions=" + exposedFunctions +
                '}';
    }
}
