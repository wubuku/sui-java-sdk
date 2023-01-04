package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiExecuteTransactionResponse =
 *   | {
 *       ImmediateReturn: {
 *         tx_digest: string;
 *       };
 *     }
 *   | { TxCert: { certificate: CertifiedTransaction } }
 *   | {
 *       EffectsCert: {
 *         certificate: CertifiedTransaction;
 *         effects: SuiCertifiedTransactionEffects;
 *       };
 *     };
 * </pre>
 */
@JsonDeserialize(using = SuiExecuteTransactionResponseDeserializer.class)
public interface SuiExecuteTransactionResponse {
    class ImmediateReturn implements SuiExecuteTransactionResponse {
        @JsonProperty("ImmediateReturn")
        private ImmediateReturnProperties immediateReturn;

        public ImmediateReturn() {
        }
        public ImmediateReturn(ImmediateReturnProperties immediateReturn) {
            this.immediateReturn = immediateReturn;
        }

        public ImmediateReturnProperties getImmediateReturn() {
            return immediateReturn;
        }

        public void setImmediateReturn(ImmediateReturnProperties immediateReturn) {
            this.immediateReturn = immediateReturn;
        }

        @Override
        public String toString() {
            return "ImmediateReturn{" +
                    "immediateReturn=" + immediateReturn +
                    '}';
        }

        public static class ImmediateReturnProperties {
            @JsonProperty("tx_digest")
            private String txDigest;

            public ImmediateReturnProperties() {
            }

            public ImmediateReturnProperties(String txDigest) {
                this.txDigest = txDigest;
            }

            public String getTxDigest() {
                return txDigest;
            }

            public void setTxDigest(String txDigest) {
                this.txDigest = txDigest;
            }

            @Override
            public String toString() {
                return "ImmediateReturn{" +
                        "tx_digest='" + txDigest + '\'' +
                        '}';
            }
        }
    }

    class TxCert implements SuiExecuteTransactionResponse {
        @JsonProperty("TxCert")
        private TxCertProperties txCert;

        public TxCert() {
        }
        public TxCert(TxCertProperties txCert) {
            this.txCert = txCert;
        }

        public TxCertProperties getTxCert() {
            return txCert;
        }

        public void setTxCert(TxCertProperties txCert) {
            this.txCert = txCert;
        }

        @Override
        public String toString() {
            return "TxCert{" +
                    "txCert=" + txCert +
                    '}';
        }

        public static class TxCertProperties {
            @JsonProperty("certificate")
            private CertifiedTransaction certificate;

            public TxCertProperties() {
            }

            public TxCertProperties(CertifiedTransaction certificate) {
                this.certificate = certificate;
            }

            public CertifiedTransaction getCertificate() {
                return certificate;
            }

            public void setCertificate(CertifiedTransaction certificate) {
                this.certificate = certificate;
            }

            @Override
            public String toString() {
                return "TxCertProperties{" +
                        "certificate=" + certificate +
                        '}';
            }
        }
    }

    class EffectsCert implements SuiExecuteTransactionResponse {
        @JsonProperty("EffectsCert")
        private EffectsCertProperties effectsCert;

        public EffectsCert() {
        }
        public EffectsCert(EffectsCertProperties effectsCert) {
            this.effectsCert = effectsCert;
        }

        public EffectsCertProperties getEffectsCert() {
            return effectsCert;
        }

        public void setEffectsCert(EffectsCertProperties effectsCert) {
            this.effectsCert = effectsCert;
        }

        @Override
        public String toString() {
            return "EffectsCert{" +
                    "effectsCert=" + effectsCert +
                    '}';
        }

        public static class EffectsCertProperties {
            @JsonProperty("certificate")
            private CertifiedTransaction certificate;
            @JsonProperty("effects")
            private SuiCertifiedTransactionEffects effects;

            public EffectsCertProperties() {
            }

            public EffectsCertProperties(CertifiedTransaction certificate, SuiCertifiedTransactionEffects effects) {
                this.certificate = certificate;
                this.effects = effects;
            }

            public CertifiedTransaction getCertificate() {
                return certificate;
            }

            public void setCertificate(CertifiedTransaction certificate) {
                this.certificate = certificate;
            }

            public SuiCertifiedTransactionEffects getEffects() {
                return effects;
            }

            public void setEffects(SuiCertifiedTransactionEffects effects) {
                this.effects = effects;
            }

            @Override
            public String toString() {
                return "EffectsCertProperties{" +
                        "certificate=" + certificate +
                        ", effects=" + effects +
                        '}';
            }
        }
    }
}
