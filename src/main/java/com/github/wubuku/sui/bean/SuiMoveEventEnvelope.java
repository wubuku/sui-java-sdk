package com.github.wubuku.sui.bean;

public class SuiMoveEventEnvelope<E> extends AbstractSuiEventEnvelope<E> {
    //todo rename to SuiMoveEvent???

    public SuiMoveEventEnvelope() {
    }

    @Override
    public String toString() {
        return "SuiMoveEventEnvelope{" +
                "id=" + getId() +
                ", packageId='" + getPackageId() + '\'' +
                ", transactionModule='" + getTransactionModule() + '\'' +
                ", sender='" + getSender() + '\'' +
                ", type='" + getType() + '\'' +
                ", bcs='" + getBcs() + '\'' +
                ", timestampMs=" + getTimestampMs() +
                ", parsedJson=" + getParsedJson() +
                '}';
    }


//    public static class MoveEvent<F> {
//        private com.github.wubuku.sui.bean.MoveEvent<F> moveEvent;
//
//        public MoveEvent() {
//        }
//
//        public MoveEvent(com.github.wubuku.sui.bean.MoveEvent<F> moveEvent) {
//            this.moveEvent = moveEvent;
//        }
//
//        public com.github.wubuku.sui.bean.MoveEvent<F> getMoveEvent() {
//            return moveEvent;
//        }
//
//        public void setMoveEvent(com.github.wubuku.sui.bean.MoveEvent<F> moveEvent) {
//            this.moveEvent = moveEvent;
//        }
//
//        @Override
//        public String toString() {
//            return "SuiMoveEventEnvelope.MoveEvent{" +
//                    "moveEvent='" + moveEvent + '\'' +
//                    '}';
//        }
//    }

}
