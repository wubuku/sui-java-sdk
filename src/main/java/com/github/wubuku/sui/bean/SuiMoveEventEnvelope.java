package com.github.wubuku.sui.bean;

/**
 * @param <F> the type of 'fields' of MoveEvent.
 */
public class SuiMoveEventEnvelope<F> extends AbstractSuiEventEnvelope<SuiMoveEventEnvelope.MoveEvent<F>> {
    public SuiMoveEventEnvelope() {
    }

    public SuiMoveEventEnvelope(Long timestamp, String txDigest, EventId id, MoveEvent<F> event) {
        super(timestamp, txDigest, id, event);
    }

    @Override
    public String toString() {
        return "SuiMoveEventEnvelope{{" +
                "timestamp=" + getTimestamp() +
                ", txDigest='" + getTxDigest() + '\'' +
                ", id=" + getId() +
                ", event=" + getEvent() +
                '}';
    }


    /**
     * @param <F> the type of 'fields' of MoveEvent.
     */
    public static class MoveEvent<F> {
        private com.github.wubuku.sui.bean.MoveEvent<F> moveEvent;

        public MoveEvent() {
        }

        public MoveEvent(com.github.wubuku.sui.bean.MoveEvent<F> moveEvent) {
            this.moveEvent = moveEvent;
        }

        public com.github.wubuku.sui.bean.MoveEvent<F> getMoveEvent() {
            return moveEvent;
        }

        public void setMoveEvent(com.github.wubuku.sui.bean.MoveEvent<F> moveEvent) {
            this.moveEvent = moveEvent;
        }

        @Override
        public String toString() {
            return "SuiMoveEventEnvelope.MoveEvent{" +
                    "moveEvent='" + moveEvent + '\'' +
                    '}';
        }
    }

}
