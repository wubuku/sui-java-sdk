package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::vec_map::VecMap type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct VecMap<K, V> {
 *     pub contents: Vec<Entry<K, V>>,
 * }
 * </pre>
 * @param <K> key type
 * @param <V> value type
 */
public class VecMap<K, V> {
    private Entry<K, V>[] contents;

    public VecMap() {
    }

    public VecMap(Entry<K, V>[] contents) {
        this.contents = contents;
    }

    public Entry<K, V>[] getContents() {
        return contents;
    }

    public void setContents(Entry<K, V>[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "VecMap{" +
                "contents=" + Arrays.toString(contents) +
                '}';
    }
}
