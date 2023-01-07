package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigInteger;

@JsonDeserialize(using = StringAndU64TupleDeserializer.class)
@JsonSerialize(using = StringAndU64TupleSerializer.class)
public class StringAndU64Tuple {
    private String item1;
    private BigInteger item2;

    public StringAndU64Tuple() {
    }

    public StringAndU64Tuple(String item1, BigInteger item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public BigInteger getItem2() {
        return item2;
    }

    public void setItem2(BigInteger item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return "StringAndU64Tuple{" +
                "item1='" + item1 + '\'' +
                ", item2=" + item2 +
                '}';
    }
}
