package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiEventEnvelope = {
 *   timestamp: number;
 *   txDigest: TransactionDigest;
 *   id: EventId;  // tx_seq_num:event_seq
 *   event: SuiEvent;
 * };
 * </pre>
 */
public class SuiEventEnvelope extends AbstractSuiEventEnvelope<SuiEvent> {

    public SuiEventEnvelope() {
    }

    public SuiEventEnvelope(Long timestamp, String txDigest, EventId id, SuiEvent event) {
        super(timestamp, txDigest, id, event);
    }

    @Override
    public String toString() {
        return "SuiEventEnvelope{" +
                "timestamp=" + getTimestamp() +
                ", txDigest='" + getTxDigest() + '\'' +
                ", id=" + getId() +
                ", event=" + getEvent() +
                '}';
    }
}
