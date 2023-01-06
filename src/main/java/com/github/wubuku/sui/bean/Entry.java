package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::vec_map::Entry type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct Entry<K, V> {
 *     key: K,
 *     value: V,
 * }
 * </pre>
 * @param <K> key type
 * @param <V> value type
 */
public class Entry<K, V> {
    private K key;
    private V value;

    public Entry() {
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
