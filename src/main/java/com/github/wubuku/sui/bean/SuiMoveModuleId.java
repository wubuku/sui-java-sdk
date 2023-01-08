package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub struct SuiMoveModuleId {
 *     address: String,
 *     name: String,
 * }
 * </pre>
 */
public class SuiMoveModuleId {
    private String address;
    private String name;

    public SuiMoveModuleId() {
    }

    public SuiMoveModuleId(String address, String name) {
        this.address = address;
        this.name = name;
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

    @Override
    public String toString() {
        return "SuiMoveModuleId{" +
                "address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
