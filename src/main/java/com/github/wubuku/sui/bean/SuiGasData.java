package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, PartialEq, Eq)]
 * #[serde(rename = "GasData", rename_all = "camelCase")]
 * pub struct SuiGasData {
 *     pub payment: Vec<SuiObjectRef>,
 *     pub owner: SuiAddress,
 *     pub price: u64,
 *     pub budget: u64,
 * }
 * </pre>
 */
public class SuiGasData {
    private SuiObjectRef[] payment;
    private String owner;
    private Long price;
    private Long budget;

    public SuiGasData() {
    }

    public SuiObjectRef[] getPayment() {
        return payment;
    }

    public void setPayment(SuiObjectRef[] payment) {
        this.payment = payment;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getBudget() {
        return budget;
    }

    public void setBudget(Long budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "SuiGasData{" +
                "payment=" + payment +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                ", budget=" + budget +
                '}';
    }
}
