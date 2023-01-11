package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiParsedTransactionResponse =
 *   | {
 *       SplitCoin: SuiParsedSplitCoinResponse;
 *     }
 *   | {
 *       MergeCoin: SuiParsedMergeCoinResponse;
 *     }
 *   | {
 *       Publish: SuiParsedPublishResponse;
 *     };
 * </pre>
 */
@JsonDeserialize(using = SuiParsedTransactionResponseDeserializer.class)
public interface SuiParsedTransactionResponse {

    class SplitCoin implements SuiParsedTransactionResponse {
        @JsonProperty("SplitCoin")
        private SuiParsedSplitCoinResponse splitCoin;

        public SplitCoin() {
        }

        public SplitCoin(SuiParsedSplitCoinResponse splitCoin) {
            this.splitCoin = splitCoin;
        }

        public SuiParsedSplitCoinResponse getSplitCoin() {
            return splitCoin;
        }

        public void setSplitCoin(SuiParsedSplitCoinResponse splitCoin) {
            this.splitCoin = splitCoin;
        }

        @Override
        public String toString() {
            return "SuiParsedTransactionResponse.SplitCoin{" +
                    "splitCoin=" + splitCoin +
                    '}';
        }
    }

    class MergeCoin implements SuiParsedTransactionResponse {
        @JsonProperty("MergeCoin")
        private SuiParsedMergeCoinResponse mergeCoin;

        public MergeCoin() {
        }

        public MergeCoin(SuiParsedMergeCoinResponse mergeCoin) {
            this.mergeCoin = mergeCoin;
        }

        public SuiParsedMergeCoinResponse getMergeCoin() {
            return mergeCoin;
        }

        public void setMergeCoin(SuiParsedMergeCoinResponse mergeCoin) {
            this.mergeCoin = mergeCoin;
        }

        @Override
        public String toString() {
            return "SuiParsedTransactionResponse.MergeCoin{" +
                    "mergeCoin=" + mergeCoin +
                    '}';
        }
    }

    class Publish implements SuiParsedTransactionResponse {
        @JsonProperty("Publish")
        private SuiParsedPublishResponse publish;

        public Publish() {
        }

        public Publish(SuiParsedPublishResponse publish) {
            this.publish = publish;
        }

        public SuiParsedPublishResponse getPublish() {
            return publish;
        }

        public void setPublish(SuiParsedPublishResponse publish) {
            this.publish = publish;
        }

        @Override
        public String toString() {
            return "SuiParsedTransactionResponse.Publish{" +
                    "publish=" + publish +
                    '}';
        }
    }

}
