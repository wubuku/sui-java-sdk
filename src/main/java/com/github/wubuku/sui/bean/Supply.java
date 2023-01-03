package com.github.wubuku.sui.bean;

import java.math.BigInteger;

public class Supply {
    private BigInteger value;

    public Supply() {
    }

    public Supply(BigInteger value) {
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
        return "Supply{" +
                "value=" + value +
                '}';
    }
}
