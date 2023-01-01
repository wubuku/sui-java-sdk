package com.github.wubuku.sui.bean;

public abstract class AbstractSuiEventEnvelope<E> {
    private Long timestamp;
    private String txDigest;
    private EventId id;
    private E event;

    public AbstractSuiEventEnvelope() {
    }

    public AbstractSuiEventEnvelope(Long timestamp, String txDigest, EventId id, E event) {
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

    public E getEvent() {
        return event;
    }

    public void setEvent(E event) {
        this.event = event;
    }


}
