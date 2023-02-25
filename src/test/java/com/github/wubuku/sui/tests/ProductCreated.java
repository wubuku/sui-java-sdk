package com.github.wubuku.sui.tests;

import java.math.BigInteger;

public class ProductCreated {
    public String id;//: object::ID,
    public String product_id;//: String,
    public String name;//: String,
    public BigInteger unit_price;//: u128,

    @Override
    public String toString() {
        return "ProductCreated{" +
                "id='" + id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", name='" + name + '\'' +
                ", unit_price=" + unit_price +
                '}';
    }
}
