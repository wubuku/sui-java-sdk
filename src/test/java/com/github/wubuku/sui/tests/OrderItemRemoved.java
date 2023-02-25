package com.github.wubuku.sui.tests;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * From Move Definition:
 * <p>
 * <pre>
 *     struct OrderItemRemoved has copy, drop {
 *         id: object::ID,
 *         version: u64,
 *         product_id: String,
 *     }
 * </pre>
 */
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class OrderItemRemoved {
    private String id;
    private Long version;
    private String productId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderItemRemoved{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", productId='" + productId + '\'' +
                '}';
    }
}
