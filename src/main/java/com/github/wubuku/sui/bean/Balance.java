package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Serialize, Deserialize, Clone, JsonSchema, Eq, PartialEq)]
 * pub struct Balance {
 *     value: u64,
 * }
 * </pre>
 */
public class Balance {
    private BigInteger value;

    public Balance() {
    }

    public Balance(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "value=" + value +
                '}';
    }
}
