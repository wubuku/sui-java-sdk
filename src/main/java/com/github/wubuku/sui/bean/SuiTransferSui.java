package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiTransferSui = {
 *   recipient: SuiAddress;
 *   amount: number | null;
 * };
 * </pre>
 */
public class SuiTransferSui {
    private String recipient;
    private Long amount;

    public SuiTransferSui() {
    }

    public SuiTransferSui(String recipient, Long amount) {
        this.recipient = recipient;
        this.amount = amount;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SuiTransferSui{" +
                "recipient='" + recipient + '\'' +
                ", amount=" + amount +
                '}';
    }
}
