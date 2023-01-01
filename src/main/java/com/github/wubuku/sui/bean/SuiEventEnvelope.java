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
public class SuiEventEnvelope {
    private Long timestamp;
    private String txDigest;
    private EventId id;
    private SuiEvent event;

    public SuiEventEnvelope() {
    }

    public SuiEventEnvelope(Long timestamp, String txDigest, EventId id, SuiEvent event) {
        this.timestamp = timestamp;
        this.txDigest = txDigest;
        this.id = id;
        this.event = event;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxDigest() {
        return txDigest;
    }

    public void setTxDigest(String txDigest) {
        this.txDigest = txDigest;
    }

    public EventId getId() {
        return id;
    }

    public void setId(EventId id) {
        this.id = id;
    }

    public SuiEvent getEvent() {
        return event;
    }

    public void setEvent(SuiEvent event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "SuiEventEnvelope{" +
                "timestamp=" + timestamp +
                ", txDigest='" + txDigest + '\'' +
                ", id=" + id +
                ", event=" + event +
                '}';
    }
}
