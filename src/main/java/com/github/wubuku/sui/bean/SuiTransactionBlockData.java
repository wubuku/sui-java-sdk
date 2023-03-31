package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, PartialEq, Eq)]
 * #[enum_dispatch(SuiTransactionBlockDataAPI)]
 * #[serde(
 *     rename = "TransactionBlockData",
 *     rename_all = "camelCase",
 *     tag = "messageVersion"
 * )]
 * pub enum SuiTransactionBlockData {
 *     V1(SuiTransactionBlockDataV1),
 * }
 * </pre>
 */
@JsonDeserialize(as = SuiTransactionBlockData.SuiTransactionBlockDataV1.class)
public abstract class SuiTransactionBlockData {
    private String messageVersion;

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    /**
     * From Rust definition:
     * <p>
     * <pre>
     * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, PartialEq, Eq)]
     * #[serde(rename = "TransactionBlockDataV1", rename_all = "camelCase")]
     * pub struct SuiTransactionBlockDataV1 {
     *     pub transaction: SuiTransactionBlockKind,
     *     pub sender: SuiAddress,
     *     pub gas_data: SuiGasData,
     * }
     * </pre>
     */
    public static class SuiTransactionBlockDataV1 extends SuiTransactionBlockData {
        private SuiTransactionBlockKind transaction;
        private String sender;
        private SuiGasData gasData;

        public SuiTransactionBlockKind getTransaction() {
            return transaction;
        }

        public void setTransaction(SuiTransactionBlockKind transaction) {
            this.transaction = transaction;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public SuiGasData getGasData() {
            return gasData;
        }

        public void setGasData(SuiGasData gasData) {
            this.gasData = gasData;
        }

        @Override
        public String toString() {
            return "SuiTransactionBlockDataV1{" +
                    "messageVersion=" + getMessageVersion() +
                    ", transaction=" + transaction +
                    ", sender='" + sender + '\'' +
                    ", gasData=" + gasData +
                    '}';
        }
    }
}
