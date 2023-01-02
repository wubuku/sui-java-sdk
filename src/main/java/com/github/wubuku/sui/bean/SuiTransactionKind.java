package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiTransactionKind =
 *   | { TransferObject: TransferObject }
 *   | { Publish: SuiMovePackage }
 *   | { Call: MoveCall }
 *   | { TransferSui: SuiTransferSui }
 *   | { ChangeEpoch: SuiChangeEpoch }
 *   | { Pay: Pay }
 *   | { PaySui: PaySui }
 *   | { PayAllSui: PayAllSui };
 * </pre>
 */
@JsonDeserialize(using = SuiTransactionKindDeserializer.class)
public interface SuiTransactionKind {

    class TransferObject implements SuiTransactionKind {
        @JsonProperty("TransferObject")
        private com.github.wubuku.sui.bean.TransferObject transferObject;

        public TransferObject() {
        }

        public TransferObject(com.github.wubuku.sui.bean.TransferObject transferObject) {
            this.transferObject = transferObject;
        }

        public com.github.wubuku.sui.bean.TransferObject getTransferObject() {
            return transferObject;
        }

        public void setTransferObject(com.github.wubuku.sui.bean.TransferObject transferObject) {
            this.transferObject = transferObject;
        }

        @Override
        public String toString() {
            return "TransferObject{" +
                    "transferObject=" + transferObject +
                    '}';
        }
    }

    class Publish implements SuiTransactionKind {
        @JsonProperty("Publish")
        private com.github.wubuku.sui.bean.SuiMovePackage publish;

        public Publish() {
        }

        public Publish(com.github.wubuku.sui.bean.SuiMovePackage publish) {
            this.publish = publish;
        }

        public com.github.wubuku.sui.bean.SuiMovePackage getPublish() {
            return publish;
        }

        public void setPublish(com.github.wubuku.sui.bean.SuiMovePackage publish) {
            this.publish = publish;
        }

        @Override
        public String toString() {
            return "Publish{" +
                    "publish=" + publish +
                    '}';
        }
    }

    class Call implements SuiTransactionKind {
        @JsonProperty("Call")
        private com.github.wubuku.sui.bean.MoveCall call;

        public Call() {
        }

        public Call(com.github.wubuku.sui.bean.MoveCall call) {
            this.call = call;
        }

        public com.github.wubuku.sui.bean.MoveCall getCall() {
            return call;
        }

        public void setCall(com.github.wubuku.sui.bean.MoveCall call) {
            this.call = call;
        }

        @Override
        public String toString() {
            return "Call{" +
                    "call=" + call +
                    '}';
        }
    }

    class TransferSui implements SuiTransactionKind {
        @JsonProperty("TransferSui")
        private com.github.wubuku.sui.bean.SuiTransferSui transferSui;

        public TransferSui() {
        }

        public TransferSui(com.github.wubuku.sui.bean.SuiTransferSui transferSui) {
            this.transferSui = transferSui;
        }

        public com.github.wubuku.sui.bean.SuiTransferSui getTransferSui() {
            return transferSui;
        }

        public void setTransferSui(com.github.wubuku.sui.bean.SuiTransferSui transferSui) {
            this.transferSui = transferSui;
        }

        @Override
        public String toString() {
            return "TransferSui{" +
                    "transferSui=" + transferSui +
                    '}';
        }
    }

    class ChangeEpoch implements SuiTransactionKind {
        @JsonProperty("ChangeEpoch")
        private com.github.wubuku.sui.bean.SuiChangeEpoch changeEpoch;

        public ChangeEpoch() {
        }

        public ChangeEpoch(com.github.wubuku.sui.bean.SuiChangeEpoch changeEpoch) {
            this.changeEpoch = changeEpoch;
        }

        public com.github.wubuku.sui.bean.SuiChangeEpoch getChangeEpoch() {
            return changeEpoch;
        }

        public void setChangeEpoch(com.github.wubuku.sui.bean.SuiChangeEpoch changeEpoch) {
            this.changeEpoch = changeEpoch;
        }

        @Override
        public String toString() {
            return "ChangeEpoch{" +
                    "changeEpoch=" + changeEpoch +
                    '}';
        }
    }

    class Pay implements SuiTransactionKind {
        @JsonProperty("Pay")
        private com.github.wubuku.sui.bean.Pay pay;

        public Pay() {
        }

        public Pay(com.github.wubuku.sui.bean.Pay pay) {
            this.pay = pay;
        }

        public com.github.wubuku.sui.bean.Pay getPay() {
            return pay;
        }

        public void setPay(com.github.wubuku.sui.bean.Pay pay) {
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "Pay{" +
                    "pay=" + pay +
                    '}';
        }
    }

    class PaySui implements SuiTransactionKind {
        @JsonProperty("PaySui")
        private com.github.wubuku.sui.bean.PaySui paySui;

        public PaySui() {
        }

        public PaySui(com.github.wubuku.sui.bean.PaySui paySui) {
            this.paySui = paySui;
        }

        public com.github.wubuku.sui.bean.PaySui getPaySui() {
            return paySui;
        }

        public void setPaySui(com.github.wubuku.sui.bean.PaySui paySui) {
            this.paySui = paySui;
        }

        @Override
        public String toString() {
            return "PaySui{" +
                    "paySui=" + paySui +
                    '}';
        }
    }

    class PayAllSui implements SuiTransactionKind {
        @JsonProperty("PayAllSui")
        private com.github.wubuku.sui.bean.PayAllSui payAllSui;

        public PayAllSui() {
        }

        public PayAllSui(com.github.wubuku.sui.bean.PayAllSui payAllSui) {
            this.payAllSui = payAllSui;
        }

        public com.github.wubuku.sui.bean.PayAllSui getPayAllSui() {
            return payAllSui;
        }

        public void setPayAllSui(com.github.wubuku.sui.bean.PayAllSui payAllSui) {
            this.payAllSui = payAllSui;
        }

        @Override
        public String toString() {
            return "PayAllSui{" +
                    "payAllSui=" + payAllSui +
                    '}';
        }
    }
}
