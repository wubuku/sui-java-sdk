package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::vec_set::VecSet type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct VecSet<T> {
 *     contents: Vec<T>,
 * }
 * </pre>
 *
 * @param <T>
 */
public class VecSet<T> {
    private T[] contents;

    public VecSet() {
    }

    public VecSet(T[] contents) {
        this.contents = contents;
    }

    public T[] getContents() {
        return contents;
    }

    public void setContents(T[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "VecSet{" +
                "contents=" + Arrays.toString(contents) +
                '}';
    }
}
