package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Deserialize, Serialize, JsonSchema, Clone, PartialEq, Eq)]
 * #[enum_dispatch(SuiTransactionBlockEffectsAPI)]
 * #[serde(
 *     rename = "TransactionBlockEffects",
 *     rename_all = "camelCase",
 *     tag = "messageVersion"
 * )]
 * pub enum SuiTransactionBlockEffects {
 *     V1(SuiTransactionBlockEffectsV1),
 * }
 * </pre>
 */
@JsonDeserialize(as = SuiTransactionBlockEffects.SuiTransactionBlockEffectsV1.class)
public abstract class SuiTransactionBlockEffects {
    private String messageVersion;

    public String getMessageVersion() {
        return messageVersion;
    }

    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    /**
     * From Rust definition:
     * <p>
     * <pre>
     * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
     * #[serde(rename = "TransactionBlockEffectsV1", rename_all = "camelCase")]
     * pub struct SuiTransactionBlockEffectsV1 {
     *     /// The status of the execution
     *     pub status: SuiExecutionStatus,
     *     /// The epoch when this transaction was executed.
     *     pub executed_epoch: SuiEpochId,
     *     pub gas_used: SuiGasCostSummary,
     *     /// The version that every modified (mutated or deleted) object had before it was modified by
     *     /// this transaction.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub modified_at_versions: Vec<SuiTransactionBlockEffectsModifiedAtVersions>,
     *     /// The object references of the shared objects used in this transaction. Empty if no shared objects were used.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub shared_objects: Vec<SuiObjectRef>,
     *     /// The transaction digest
     *     pub transaction_digest: TransactionDigest,
     *     /// ObjectRef and owner of new objects created.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub created: Vec<OwnedObjectRef>,
     *     /// ObjectRef and owner of mutated objects, including gas object.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub mutated: Vec<OwnedObjectRef>,
     *     /// ObjectRef and owner of objects that are unwrapped in this transaction.
     *     /// Unwrapped objects are objects that were wrapped into other objects in the past,
     *     /// and just got extracted out.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub unwrapped: Vec<OwnedObjectRef>,
     *     /// Object Refs of objects now deleted (the old refs).
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub deleted: Vec<SuiObjectRef>,
     *     /// Object refs of objects previously wrapped in other objects but now deleted.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub unwrapped_then_deleted: Vec<SuiObjectRef>,
     *     /// Object refs of objects now wrapped in other objects.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub wrapped: Vec<SuiObjectRef>,
     *     /// The updated gas object reference. Have a dedicated field for convenient access.
     *     /// It's also included in mutated.
     *     pub gas_object: OwnedObjectRef,
     *     /// The digest of the events emitted during execution,
     *     /// can be None if the transaction does not emit any event.
     *     #[serde(skip_serializing_if = "Option::is_none")]
     *     pub events_digest: Option<TransactionEventsDigest>,
     *     /// The set of transaction digests this transaction depends on.
     *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
     *     pub dependencies: Vec<TransactionDigest>,
     * }
     * </pre>
     */
    public static class SuiTransactionBlockEffectsV1 extends SuiTransactionBlockEffects {
        private SuiExecutionStatusEnvelope status;
        private BigInteger executedEpoch;
        private SuiGasCostSummary gasUsed;
        private SuiTransactionBlockEffectsModifiedAtVersions[] modifiedAtVersions;
        private SuiObjectRef[] sharedObjects;
        private String transactionDigest;
        private OwnedObjectRef[] created;
        private OwnedObjectRef[] mutated;
        private OwnedObjectRef[] unwrapped;
        private SuiObjectRef[] deleted;
        private SuiObjectRef[] unwrappedThenDeleted;
        private SuiObjectRef[] wrapped;
        private OwnedObjectRef gasObject;
        private String eventsDigest;
        private String[] dependencies;

        public SuiExecutionStatusEnvelope getStatus() {
            return status;
        }

        public void setStatus(SuiExecutionStatusEnvelope status) {
            this.status = status;
        }

        public BigInteger getExecutedEpoch() {
            return executedEpoch;
        }

        public void setExecutedEpoch(BigInteger executedEpoch) {
            this.executedEpoch = executedEpoch;
        }

        public SuiGasCostSummary getGasUsed() {
            return gasUsed;
        }

        public void setGasUsed(SuiGasCostSummary gasUsed) {
            this.gasUsed = gasUsed;
        }

        public SuiTransactionBlockEffectsModifiedAtVersions[] getModifiedAtVersions() {
            return modifiedAtVersions;
        }

        public void setModifiedAtVersions(SuiTransactionBlockEffectsModifiedAtVersions[] modifiedAtVersions) {
            this.modifiedAtVersions = modifiedAtVersions;
        }

        public SuiObjectRef[] getSharedObjects() {
            return sharedObjects;
        }

        public void setSharedObjects(SuiObjectRef[] sharedObjects) {
            this.sharedObjects = sharedObjects;
        }

        public String getTransactionDigest() {
            return transactionDigest;
        }

        public void setTransactionDigest(String transactionDigest) {
            this.transactionDigest = transactionDigest;
        }

        public OwnedObjectRef[] getCreated() {
            return created;
        }

        public void setCreated(OwnedObjectRef[] created) {
            this.created = created;
        }

        public OwnedObjectRef[] getMutated() {
            return mutated;
        }

        public void setMutated(OwnedObjectRef[] mutated) {
            this.mutated = mutated;
        }

        public OwnedObjectRef[] getUnwrapped() {
            return unwrapped;
        }

        public void setUnwrapped(OwnedObjectRef[] unwrapped) {
            this.unwrapped = unwrapped;
        }

        public SuiObjectRef[] getDeleted() {
            return deleted;
        }

        public void setDeleted(SuiObjectRef[] deleted) {
            this.deleted = deleted;
        }

        public SuiObjectRef[] getUnwrappedThenDeleted() {
            return unwrappedThenDeleted;
        }

        public void setUnwrappedThenDeleted(SuiObjectRef[] unwrappedThenDeleted) {
            this.unwrappedThenDeleted = unwrappedThenDeleted;
        }

        public SuiObjectRef[] getWrapped() {
            return wrapped;
        }

        public void setWrapped(SuiObjectRef[] wrapped) {
            this.wrapped = wrapped;
        }

        public OwnedObjectRef getGasObject() {
            return gasObject;
        }

        public void setGasObject(OwnedObjectRef gasObject) {
            this.gasObject = gasObject;
        }

        public String getEventsDigest() {
            return eventsDigest;
        }

        public void setEventsDigest(String eventsDigest) {
            this.eventsDigest = eventsDigest;
        }

        public String[] getDependencies() {
            return dependencies;
        }

        public void setDependencies(String[] dependencies) {
            this.dependencies = dependencies;
        }

        @Override
        public String toString() {
            return "SuiTransactionBlockEffectsV1{" +
                    "status=" + status +
                    ", executedEpoch=" + executedEpoch +
                    ", gasUsed=" + gasUsed +
                    ", modifiedAtVersions=" + Arrays.toString(modifiedAtVersions) +
                    ", sharedObjects=" + Arrays.toString(sharedObjects) +
                    ", transactionDigest='" + transactionDigest + '\'' +
                    ", created=" + Arrays.toString(created) +
                    ", mutated=" + Arrays.toString(mutated) +
                    ", unwrapped=" + Arrays.toString(unwrapped) +
                    ", deleted=" + Arrays.toString(deleted) +
                    ", unwrappedThenDeleted=" + Arrays.toString(unwrappedThenDeleted) +
                    ", wrapped=" + Arrays.toString(wrapped) +
                    ", gasObject=" + gasObject +
                    ", eventsDigest='" + eventsDigest + '\'' +
                    ", dependencies=" + Arrays.toString(dependencies) +
                    '}';
        }
    }
}
