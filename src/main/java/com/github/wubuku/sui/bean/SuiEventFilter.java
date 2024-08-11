package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 *
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
 *     /// If the event is defined in Module A but emitted in a tx with Module B,
 *     /// query `MoveModule` by module B returns the event.
 *     /// Query `MoveEventModule` by module A returns the event too.
 *     MoveModule {
 *         /// the Move package ID
 *         package: ObjectID,
 *         /// the module name
 *         #[schemars(with = "String")]
 *         #[serde_as(as = "DisplayFromStr")]
 *         module: Identifier,
 *     },
 *     /// Return events with the given Move event struct name (struct tag).
 *     /// For example, if the event is defined in `0xabcd::MyModule`, and named
 *     /// `Foo`, then the struct tag is `0xabcd::MyModule::Foo`.
 *     MoveEventType(
 *         #[schemars(with = "String")]
 *         #[serde_as(as = "SuiStructTag")]
 *         StructTag,
 *     ),
 *     /// Return events with the given Move module name where the event struct is defined.
 *     /// If the event is defined in Module A but emitted in a tx with Module B,
 *     /// query `MoveEventModule` by module A returns the event.
 *     /// Query `MoveModule` by module B returns the event too.
 *     MoveEventModule {
 *         /// the Move package ID
 *         package: ObjectID,
 *         /// the module name
 *         #[schemars(with = "String")]
 *         #[serde_as(as = "DisplayFromStr")]
 *         module: Identifier,
 *     },
 *     MoveEventField {
 *         path: String,
 *         value: Value,
 *     },
 *     /// Return events emitted in [start_time, end_time] interval
 *     #[serde(rename_all = "camelCase")]
 *     TimeRange {
 *         /// left endpoint of time interval, milliseconds since epoch, inclusive
 *         #[schemars(with = "BigInt<u64>")]
 *         #[serde_as(as = "BigInt<u64>")]
 *         start_time: u64,
 *         /// right endpoint of time interval, milliseconds since epoch, exclusive
 *         #[schemars(with = "BigInt<u64>")]
 *         #[serde_as(as = "BigInt<u64>")]
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
        @JsonProperty("MoveModule")
        private MoveModuleProperties moveModuleProperties;

        public MoveModule() {
        }

        public MoveModule(String package_, String module) {
            this.moveModuleProperties = new MoveModuleProperties(package_, module);
        }

        public MoveModuleProperties getMoveModuleProperties() {
            return moveModuleProperties;
        }

        public void setMoveModuleProperties(MoveModuleProperties moveModuleProperties) {
            this.moveModuleProperties = moveModuleProperties;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.MoveModule{" +
                    "moveModuleProperties=" + moveModuleProperties +
                    '}';
        }
    }


    class MoveEventModule implements SuiEventFilter {
        @JsonProperty("MoveEventModule")
        private MoveModuleProperties moveModuleProperties;

        public MoveEventModule() {
        }

        public MoveEventModule(String package_, String module) {
            this.moveModuleProperties = new MoveModuleProperties(package_, module);
        }

        public MoveModuleProperties getMoveModuleProperties() {
            return moveModuleProperties;
        }

        public void setMoveModuleProperties(MoveModuleProperties moveModuleProperties) {
            this.moveModuleProperties = moveModuleProperties;
        }

        @Override
        public String toString() {
            return "SuiEventFilter.MoveEventModule{" +
                    "moveModuleProperties=" + moveModuleProperties +
                    '}';
        }
    }

    class MoveModuleProperties {
        @JsonProperty("package")
        private String package_;
        @JsonProperty("module")
        private String module;

        public MoveModuleProperties() {
        }

        public MoveModuleProperties(String package_, String module) {
            this.package_ = package_;
            this.module = module;
        }

        public String getPackage_() {
            return package_;
        }

        public void setPackage_(String package_) {
            this.package_ = package_;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        public String toString() {
            return "MoveModuleProperties{" +
                    "package_=" + package_ +
                    ", module=" + module +
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
            @JsonProperty("startTime")
            private Long startTime;
            @JsonProperty("endTime")
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
            if (and == null || and.length != 2) {
                throw new IllegalArgumentException("'And' filter must have exactly 2 items");
            }
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
            if (or == null || or.length != 2) {
                throw new IllegalArgumentException("'Or' filter must have exactly 2 items");
            }
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
