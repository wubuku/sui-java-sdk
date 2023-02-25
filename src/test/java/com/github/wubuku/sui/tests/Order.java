package com.github.wubuku.sui.tests;

import com.github.wubuku.sui.bean.DynamicField;
import com.github.wubuku.sui.bean.Table;
import com.github.wubuku.sui.bean.UID;

public class Order {
    public UID id;
    public Long total_amount;
    public Long version;
    public Table items; //OrderItem table

    @Override
    public String toString() {
        return "TestOrder{" +
                "id=" + id +
                ", total_amount=" + total_amount +
                ", version=" + version +
                ", items=" + items +
                '}';
    }

}
