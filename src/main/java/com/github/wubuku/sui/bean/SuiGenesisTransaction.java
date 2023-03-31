package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * pub struct SuiGenesisTransaction {
 *     pub objects: Vec<ObjectID>,
 * }
 * </pre>
 */
public class SuiGenesisTransaction {
    private String[] objects;

    public String[] getObjects() {
        return objects;
    }

    public void setObjects(String[] objects) {
        this.objects = objects;
    }

    public SuiGenesisTransaction() {
    }

    public SuiGenesisTransaction(String[] objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return "SuiGenesisTransaction{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}
