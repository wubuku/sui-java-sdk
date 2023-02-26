package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "TransactionEffects", rename_all = "camelCase")]
 * pub struct SuiTransactionEffects {
 *     // The status of the execution
 *     pub status: SuiExecutionStatus,
 *     /// The epoch when this transaction was executed.
 *     pub executed_epoch: EpochId,
 *     pub gas_used: SuiGasCostSummary,
 *     // The object references of the shared objects used in this transaction. Empty if no shared objects were used.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub shared_objects: Vec<SuiObjectRef>,
 *     // The transaction digest
 *     pub transaction_digest: TransactionDigest,
 *     // ObjectRef and owner of new objects created.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub created: Vec<OwnedObjectRef>,
 *     // ObjectRef and owner of mutated objects, including gas object.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub mutated: Vec<OwnedObjectRef>,
 *     // ObjectRef and owner of objects that are unwrapped in this transaction.
 *     // Unwrapped objects are objects that were wrapped into other objects in the past,
 *     // and just got extracted out.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub unwrapped: Vec<OwnedObjectRef>,
 *     // Object Refs of objects now deleted (the old refs).
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub deleted: Vec<SuiObjectRef>,
 *     /// Object refs of objects previously wrapped in other objects but now deleted.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub unwrapped_then_deleted: Vec<SuiObjectRef>,
 *     // Object refs of objects now wrapped in other objects.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub wrapped: Vec<SuiObjectRef>,
 *     // The updated gas object reference. Have a dedicated field for convenient access.
 *     // It's also included in mutated.
 *     pub gas_object: OwnedObjectRef,
 *     /// The events emitted during execution. Note that only successful transactions emit events
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub events: Vec<SuiEvent>,
 *     /// The set of transaction digests this transaction depends on.
 *     #[serde(default, skip_serializing_if = "Vec::is_empty")]
 *     pub dependencies: Vec<TransactionDigest>,
 * }
 * </pre>
 */
public class SuiTransactionEffects {
    private SuiExecutionStatusEnvelope status;
    private String executedEpoch;
    private SuiGasCostSummary gasUsed;
    private SuiObjectRef[] sharedObjects;
    private String transactionDigest;
    private OwnedObjectRef[] created;
    private OwnedObjectRef[] mutated;
    private OwnedObjectRef[] unwrapped;
    private SuiObjectRef[] deleted;
    private SuiObjectRef[] wrapped;
    private OwnedObjectRef gasObject;
    private SuiEvent[] events;
    private String[] dependencies;


    public SuiExecutionStatusEnvelope getStatus() {
        return status;
    }

    public void setStatus(SuiExecutionStatusEnvelope status) {
        this.status = status;
    }

    public String getExecutedEpoch() {
        return executedEpoch;
    }

    public void setExecutedEpoch(String executedEpoch) {
        this.executedEpoch = executedEpoch;
    }

    public SuiGasCostSummary getGasUsed() {
        return gasUsed;
    }

    public void setGasUsed(SuiGasCostSummary gasUsed) {
        this.gasUsed = gasUsed;
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

    public SuiEvent[] getEvents() {
        return events;
    }

    public void setEvents(SuiEvent[] events) {
        this.events = events;
    }

    public String[] getDependencies() {
        return dependencies;
    }

    public void setDependencies(String[] dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public String toString() {
        return "SuiTransactionEffects{" +
                "status=" + status +
                ", executedEpoch='" + executedEpoch + '\'' +
                ", gasUsed=" + gasUsed +
                ", sharedObjects=" + Arrays.toString(sharedObjects) +
                ", transactionDigest='" + transactionDigest + '\'' +
                ", created=" + Arrays.toString(created) +
                ", mutated=" + Arrays.toString(mutated) +
                ", unwrapped=" + Arrays.toString(unwrapped) +
                ", deleted=" + Arrays.toString(deleted) +
                ", wrapped=" + Arrays.toString(wrapped) +
                ", gasObject=" + gasObject +
                ", events=" + Arrays.toString(events) +
                ", dependencies=" + Arrays.toString(dependencies) +
                '}';
    }

    public static class SuiExecutionStatusEnvelope {
        private SuiExecutionStatus status;

        public SuiExecutionStatus getStatus() {
            return status;
        }

        public void setStatus(SuiExecutionStatus status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "SuiExecutionStatusEnvelope{" +
                    "status=" + status +
                    '}';
        }
    }
}
