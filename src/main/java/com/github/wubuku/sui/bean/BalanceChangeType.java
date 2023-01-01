package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type BalanceChangeType = "Gas" | "Pay" | "Receive"
 * </pre>
 */
public enum BalanceChangeType {
    GAS {
        @Override
        public String getCode() {
            return "Gas";
        }
    },
    PAY {
        @Override
        public String getCode() {
            return "Pay";
        }
    },
    RECEIVE {
        @Override
        public String getCode() {
            return "Receive";
        }
    };

    public abstract String getCode();
}
