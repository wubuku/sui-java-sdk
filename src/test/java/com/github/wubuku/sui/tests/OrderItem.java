package com.github.wubuku.sui.tests;

public class OrderItem {
    public String product_id;
    public Long quantity;
    public Long item_amount;

    @Override
    public String toString() {
        return "OrderItem{" +
                "product_id='" + product_id + '\'' +
                ", quantity=" + quantity +
                ", item_amount=" + item_amount +
                '}';
    }
}
