package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * pub enum EventFilter {
 *     /// Query by sender address.
 *     Sender(SuiAddress),
 *     /// Return events emitted by the given transaction.
 *     Transaction(
 *         ///digest of the transaction, as base-64 encoded string
 *         TransactionDigest,
 *     ),
 *     /// Return events emitted in a specified Package.
 *     Package(ObjectID),
 *     /// Return events emitted in a specified Move module.
 *     MoveModule {
 *         /// the Move package ID
 *         package: ObjectID,
 *         /// the module name
 *         #[schemars(with = "String")]
 *         #[serde_as(as = "DisplayFromStr")]
 *         module: Identifier,
 *     },
 *     /// Return events with the given move event struct name
 *     MoveEventType(
 *         #[schemars(with = "String")]
 *         #[serde_as(as = "SuiStructTag")]
 *         StructTag,
 *     ),
 *     MoveEventField {
 *         path: String,
 *         value: Value,
 *     },
 *     /// Return events emitted in [start_time, end_time] interval
 *     #[serde(rename_all = "camelCase")]
 *     TimeRange {
 *         /// left endpoint of time interval, milliseconds since epoch, inclusive
 *         start_time: u64,
 *         /// right endpoint of time interval, milliseconds since epoch, exclusive
 *         end_time: u64,
 *     },
 *
 *     All(Vec<EventFilter>),
 *     Any(Vec<EventFilter>),
 *     And(Box<EventFilter>, Box<EventFilter>),
 *     Or(Box<EventFilter>, Box<EventFilter>),
 * }
 */
public interface SuiEventFilter {

    class Sender implements SuiEventFilter {
        @JsonProperty("Sender")
        private String sender;

        public Sender() {
        }

        public Sender(String senderAddress) {
            this.sender = senderAddress;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.Sender{" +
                    "sender='" + sender + '\'' +
                    '}';
        }
    }

    class Transaction implements SuiEventFilter {
        @JsonProperty("Transaction")
        private String transaction;

        public Transaction() {
        }

        public Transaction(String transaction) {
            this.transaction = transaction;
        }

        public String getTransaction() {
            return transaction;
        }

        public void setTransaction(String transaction) {
            this.transaction = transaction;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "transaction='" + transaction + '\'' +
                    '}';
        }
    }

    class Package implements SuiEventFilter {
        @JsonProperty("Package")
        private String package_;

        public Package() {
        }

        public Package(String package_) {
            this.package_ = package_;
        }

        public String getPackage_() {
            return package_;
        }

        public void setPackage_(String package_) {
            this.package_ = package_;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.Package{" +
                    "package_=" + package_ +
                    '}';
        }
    }

    class MoveModule implements SuiEventFilter {
        @JsonProperty("Module")
        private String[] packageAndModule;

        public MoveModule() {
        }

        public MoveModule(String package_, String module) {
            this.packageAndModule = new String[]{package_, module};
        }

        public String[] getPackageAndModule() {
            return packageAndModule;
        }

        public void setPackageAndModule(String[] packageAndModule) {
            this.packageAndModule = packageAndModule;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.Module{" +
                    "module=" + Arrays.toString(packageAndModule) +
                    '}';
        }
    }

    class MoveEventType implements SuiEventFilter {
        @JsonProperty("MoveEventType")
        private String moveEventType;

        public MoveEventType() {
        }

        public MoveEventType(String moveEventType) {
            this.moveEventType = moveEventType;
        }

        public String getMoveEventType() {
            return moveEventType;
        }

        public void setMoveEventType(String moveEventType) {
            this.moveEventType = moveEventType;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.MoveEventType{" +
                    "moveEventType=" + moveEventType +
                    '}';
        }
    }

    class MoveEventField implements SuiEventFilter {
        @JsonProperty("MoveEventField")
        private com.github.wubuku.sui.bean.MoveEventField moveEventField;

        public MoveEventField() {
        }

        public MoveEventField(com.github.wubuku.sui.bean.MoveEventField moveEventField) {
            this.moveEventField = moveEventField;
        }

        public com.github.wubuku.sui.bean.MoveEventField getMoveEventField() {
            return moveEventField;
        }

        public void setMoveEventField(com.github.wubuku.sui.bean.MoveEventField moveEventField) {
            this.moveEventField = moveEventField;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.MoveEventField{" +
                    "moveEventField=" + moveEventField +
                    '}';
        }
    }


    class TimeRange implements SuiEventFilter {
        @JsonProperty("TimeRange")
        private TimeRange.TimeRangeProperties timeRange;

        public TimeRange() {
        }

        public TimeRange(Long startTime, Long endTime) {
            this.timeRange = new TimeRange.TimeRangeProperties(startTime, endTime);
        }

        public TimeRange.TimeRangeProperties getTimeRange() {
            return timeRange;
        }

        public void setTimeRange(TimeRange.TimeRangeProperties timeRange) {
            this.timeRange = timeRange;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.TimeRange{" +
                    "timeRange=" + timeRange +
                    '}';
        }

        public static class TimeRangeProperties {
            @JsonProperty("start_time")
            private Long startTime;
            @JsonProperty("end_time")
            private Long endTime;

            public TimeRangeProperties() {
            }

            public TimeRangeProperties(Long startTime, Long endTime) {
                this.startTime = startTime;
                this.endTime = endTime;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(Long startTime) {
                this.startTime = startTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(Long endTime) {
                this.endTime = endTime;
            }

            @Override
            public String toString() {
                return "SuiEventFilter.TimeRange.TimeRangeProperties{" +
                        "startTime=" + startTime +
                        ", endTime=" + endTime +
                        '}';
            }
        }
    }

    class All implements SuiEventFilter {
        @JsonProperty("All")
        private SuiEventFilter[] all;

        public All() {
        }

        public All(SuiEventFilter[] all) {
            this.all = all;
        }

        public SuiEventFilter[] getAll() {
            return all;
        }

        public void setAll(SuiEventFilter[] all) {
            this.all = all;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.All{" +
                    "all=" + Arrays.toString(all) +
                    '}';
        }
    }

    class Any implements SuiEventFilter {
        @JsonProperty("Any")
        private SuiEventFilter[] any;

        public Any() {
        }

        public Any(SuiEventFilter[] any) {
            this.any = any;
        }

        public SuiEventFilter[] getAny() {
            return any;
        }

        public void setAny(SuiEventFilter[] any) {
            this.any = any;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.Any{" +
                    "any=" + Arrays.toString(any) +
                    '}';
        }
    }

    class And implements SuiEventFilter {
        @JsonProperty("And")
        private SuiEventFilter[] and;

        public And() {
        }

        public And(SuiEventFilter[] and) {
            this.and = and;
        }

        public And(SuiEventFilter item1, SuiEventFilter item2) {
            this.and = new SuiEventFilter[]{item1, item2};
        }

        public SuiEventFilter[] getAnd() {
            return and;
        }

        public void setAnd(SuiEventFilter[] and) {
            this.and = and;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.And{" +
                    "and=" + Arrays.toString(and) +
                    '}';
        }
    }

    class Or implements SuiEventFilter {
        @JsonProperty("Or")
        private SuiEventFilter[] or;

        public Or() {
        }

        public Or(SuiEventFilter[] or) {
            this.or = or;
        }

        public Or(SuiEventFilter item1, SuiEventFilter item2) {
            this.or = new SuiEventFilter[]{item1, item2};
        }

        public SuiEventFilter[] getOr() {
            return or;
        }

        public void setOr(SuiEventFilter[] or) {
            this.or = or;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.Or{" +
                    "or=" + Arrays.toString(or) +
                    '}';
        }
    }

}

//    class EventType implements SuiEventFilter {
//        @JsonProperty("EventType")
//        private String eventType;
//
//        public EventType() {
//        }
//
//        public EventType(String eventType) {
//            this.eventType = eventType;
//        }
//
//        public String getEventType() {
//            return eventType;
//        }
//
//        public void setEventType(String eventType) {
//            this.eventType = eventType;
//        }
//
//        @Override
//        public String toString() {
//            return "SuiEventFilter.EventType{" +
//                    "eventType='" + eventType + '\'' +
//                    '}';
//        }
//    }
