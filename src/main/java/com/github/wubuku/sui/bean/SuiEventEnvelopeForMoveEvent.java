package com.github.wubuku.sui.bean;

/**
 * @param <F> the type of 'fields' of MoveEvent.
 */
public class SuiEventEnvelopeForMoveEvent<F> extends AbstractSuiEventEnvelope<SuiEvent.MoveEvent<F>> {
    public SuiEventEnvelopeForMoveEvent() {
    }

    public SuiEventEnvelopeForMoveEvent(Long timestamp, String txDigest, EventId id, SuiEvent.MoveEvent<F> event) {
        super(timestamp, txDigest, id, event);
    }

    @Override
    public String toString() {
        return "SuiEventEnvelopeForMoveEvent{{" +
                "timestamp=" + getTimestamp() +
                ", txDigest='" + getTxDigest() + '\'' +
                ", id=" + getId() +
                ", event=" + getEvent() +
                '}';
    }
}
