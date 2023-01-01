package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type BalanceChangeType = "Gas" | "Pay" | "Receive"
 * </pre>
 */
@JsonDeserialize(using = BalanceChangeTypeDeserializer.class)
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
