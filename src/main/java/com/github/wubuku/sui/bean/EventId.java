package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type EventId = {
 * txSeq: number,
 * eventSeq: number,
 * }
 * </pre>
 */
public class EventId {
    private Long txSeq;
    private Long eventSeq;

    public EventId() {
    }

    public EventId(Long txSeq, Long eventSeq) {
        this.txSeq = txSeq;
        this.eventSeq = eventSeq;
    }

    public Long getTxSeq() {
        return txSeq;
    }

    public void setTxSeq(Long txSeq) {
        this.txSeq = txSeq;
    }

    public Long getEventSeq() {
        return eventSeq;
    }

    public void setEventSeq(Long eventSeq) {
        this.eventSeq = eventSeq;
    }

    @Override
    public String toString() {
        return "EventId{" +
                "txSeq=" + txSeq +
                ", eventSeq=" + eventSeq +
                '}';
    }
}
