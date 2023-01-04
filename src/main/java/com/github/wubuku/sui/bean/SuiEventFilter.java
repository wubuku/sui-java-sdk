package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * // mirrors sui_json_rpc_types::SuiEventFilter
 * export type SuiEventFilter =
 *   | { Package: ObjectId }
 *   | { Module: string }
 *   | { MoveEventType: string }
 *   | { MoveEventField: MoveEventField }
 *   | { SenderAddress: SuiAddress }
 *   | { EventType: EventType }
 *   | { All: SuiEventFilter[] }
 *   | { Any: SuiEventFilter[] }
 *   | { And: [SuiEventFilter, SuiEventFilter] }
 *   | { Or: [SuiEventFilter, SuiEventFilter] };
 * </pre>
 */
public interface SuiEventFilter {
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
            return "Package{" +
                    "package_=" + package_ +
                    '}';
        }
    }

    class Module implements SuiEventFilter {
        @JsonProperty("Module")
        private String module;

        public Module() {
        }

        public Module(String module) {
            this.module = module;
        }

        public String getModule() {
            return module;
        }

        public void setModule(String module) {
            this.module = module;
        }

        @Override
        public String toString() {
            return "Module{" +
                    "module=" + module +
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
            return "MoveEventType{" +
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
            return "MoveEventField{" +
                    "moveEventField=" + moveEventField +
                    '}';
        }
    }

    class SenderAddress implements SuiEventFilter {
        @JsonProperty("SenderAddress")
        private String senderAddress;

        public SenderAddress() {
        }

        public SenderAddress(String senderAddress) {
            this.senderAddress = senderAddress;
        }

        public String getSenderAddress() {
            return senderAddress;
        }

        public void setSenderAddress(String senderAddress) {
            this.senderAddress = senderAddress;
        }

        @Override
        public String toString() {
            return "Sender{" +
                    "sender='" + senderAddress + '\'' +
                    '}';
        }
    }

    class EventType implements SuiEventFilter {
        @JsonProperty("EventType")
        private String eventType;

        public EventType() {
        }

        public EventType(String eventType) {
            this.eventType = eventType;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        @Override
        public String toString() {
            return "EventType{" +
                    "eventType='" + eventType + '\'' +
                    '}';
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
            return "All{" +
                    "all=" + all +
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
            return "Any{" +
                    "any=" + any +
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

        public SuiEventFilter[] getAnd() {
            return and;
        }

        public void setAnd(SuiEventFilter[] and) {
            this.and = and;
        }

        @Override
        public String toString() {
            return "And{" +
                    "and=" + and +
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

        public SuiEventFilter[] getOr() {
            return or;
        }

        public void setOr(SuiEventFilter[] or) {
            this.or = or;
        }

        @Override
        public String toString() {
            return "Or{" +
                    "or=" + or +
                    '}';
        }
    }
}
