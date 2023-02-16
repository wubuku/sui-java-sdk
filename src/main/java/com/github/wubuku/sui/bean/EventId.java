package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, PartialEq, Eq, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub struct EventID {
 *     pub tx_digest: TransactionDigest,
 *     pub event_seq: i64,
 * }
 * </pre>
 */
public class EventId {
    private String txDigest;
    private Long eventSeq;

    public EventId() {
    }

    public EventId(String txDigest, Long eventSeq) {
        this.txDigest = txDigest;
        this.eventSeq = eventSeq;
    }

    public String getTxDigest() {
        return txDigest;
    }

    public void setTxDigest(String txDigest) {
        this.txDigest = txDigest;
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
                "txDigest='" + txDigest + '\'' +
                ", eventSeq=" + eventSeq +
                '}';
    }
}
