package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, Eq, PartialEq)]
 * #[serde(rename = "RawMovePackage")]
 * pub struct SuiRawMovePackage {
 *     pub id: ObjectID,
 *     #[schemars(with = "BTreeMap<String, Base64>")]
 *     #[serde_as(as = "BTreeMap<_, Base64>")]
 *     pub module_map: BTreeMap<String, Vec<u8>>,
 * }
 * </pre>
 */
public class SuiRawMovePackage {
    private String id;
    @JsonProperty("module_map")
    private Map<String, String> moduleMap;

    public SuiRawMovePackage() {
    }

    public SuiRawMovePackage(String id, Map<String, String> moduleMap) {
        this.id = id;
        this.moduleMap = moduleMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getModuleMap() {
        return moduleMap;
    }

    public void setModuleMap(Map<String, String> moduleMap) {
        this.moduleMap = moduleMap;
    }

    @Override
    public String toString() {
        return "SuiRawMovePackage{" +
                "id='" + id + '\'' +
                ", moduleMap=" + moduleMap +
                '}';
    }
}
