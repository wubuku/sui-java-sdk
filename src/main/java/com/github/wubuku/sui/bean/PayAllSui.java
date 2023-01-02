package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type PayAllSui = {
 *   coins: SuiObjectRef[];
 *   recipient: SuiAddress;
 * };
 * </pre>
 */
public class PayAllSui {
    private SuiObjectRef[] coins;
    private String recipient;

    public PayAllSui() {
    }

    public PayAllSui(SuiObjectRef[] coins, String recipient) {
        this.coins = coins;
        this.recipient = recipient;
    }

    public SuiObjectRef[] getCoins() {
        return coins;
    }

    public void setCoins(SuiObjectRef[] coins) {
        this.coins = coins;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "PayAllSui{" +
                "coins=" + java.util.Arrays.toString(coins) +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
