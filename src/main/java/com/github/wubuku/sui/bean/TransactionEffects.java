//package com.github.wubuku.sui.bean;
//
//
//import java.util.Arrays;
//
///**
// * From TypeScript definition:
// * <p>
// * <pre>
// * export type TransactionEffects = {
// *     // The status of the execution
// *     status: ExecutionStatus;
// *     gasUsed: GasCostSummary;
// *     // The object references of the shared objects used in this transaction. Empty if no shared objects were used.
// *     sharedObjects?: SuiObjectRef[];
// *     // The transaction digest
// *     transactionDigest: TransactionDigest;
// *     // ObjectRef and owner of new objects created
// *     created?: OwnedObjectRef[];
// *     // ObjectRef and owner of mutated objects, including gas object
// *     mutated?: OwnedObjectRef[];
// *      // ObjectRef and owner of objects that are unwrapped in this transaction.
// *      // Unwrapped objects are objects that were wrapped into other objects in the past,
// *      // and just got extracted out.
// *     unwrapped?: OwnedObjectRef[];
// *     // Object Refs of objects now deleted (the old refs)
// *     deleted?: SuiObjectRef[];
// *     // Object refs of objects now wrapped in other objects
// *     wrapped?: SuiObjectRef[];
// *      // The updated gas object reference. Have a dedicated field for convenient access.
// *      // It's also included in mutated.
// *     gasObject: OwnedObjectRef;
// *     // The events emitted during execution. Note that only successful transactions emit events
// *     events?: SuiEvent[];
// *     // The set of transaction digests this transaction depends on
// *     dependencies?: TransactionDigest[];
// * };
// * </pre>
// */
//public class TransactionEffects {
//
//    private ExecutionStatus status;
//    private GasCostSummary gasUsed;
//    private SuiObjectRef[] sharedObjects;
//    private String transactionDigest;
//    private OwnedObjectRef[] created;
//    private OwnedObjectRef[] mutated;
//    private OwnedObjectRef[] unwrapped;
//    private SuiObjectRef[] deleted;
//    private SuiObjectRef[] wrapped;
//    private OwnedObjectRef gasObject;
//    private SuiEvent[] events;
//    private String[] dependencies;
//
//    public TransactionEffects() {
//    }
//
//    public ExecutionStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(ExecutionStatus status) {
//        this.status = status;
//    }
//
//    public GasCostSummary getGasUsed() {
//        return gasUsed;
//    }
//
//    public void setGasUsed(GasCostSummary gasUsed) {
//        this.gasUsed = gasUsed;
//    }
//
//    public SuiObjectRef[] getSharedObjects() {
//        return sharedObjects;
//    }
//
//    public void setSharedObjects(SuiObjectRef[] sharedObjects) {
//        this.sharedObjects = sharedObjects;
//    }
//
//    public String getTransactionDigest() {
//        return transactionDigest;
//    }
//
//    public void setTransactionDigest(String transactionDigest) {
//        this.transactionDigest = transactionDigest;
//    }
//
//    public OwnedObjectRef[] getCreated() {
//        return created;
//    }
//
//    public void setCreated(OwnedObjectRef[] created) {
//        this.created = created;
//    }
//
//    public OwnedObjectRef[] getMutated() {
//        return mutated;
//    }
//
//    public void setMutated(OwnedObjectRef[] mutated) {
//        this.mutated = mutated;
//    }
//
//    public OwnedObjectRef[] getUnwrapped() {
//        return unwrapped;
//    }
//
//    public void setUnwrapped(OwnedObjectRef[] unwrapped) {
//        this.unwrapped = unwrapped;
//    }
//
//    public SuiObjectRef[] getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(SuiObjectRef[] deleted) {
//        this.deleted = deleted;
//    }
//
//    public SuiObjectRef[] getWrapped() {
//        return wrapped;
//    }
//
//    public void setWrapped(SuiObjectRef[] wrapped) {
//        this.wrapped = wrapped;
//    }
//
//    public OwnedObjectRef getGasObject() {
//        return gasObject;
//    }
//
//    public void setGasObject(OwnedObjectRef gasObject) {
//        this.gasObject = gasObject;
//    }
//
//    public SuiEvent[] getEvents() {
//        return events;
//    }
//
//    public void setEvents(SuiEvent[] events) {
//        this.events = events;
//    }
//
//    public String[] getDependencies() {
//        return dependencies;
//    }
//
//    public void setDependencies(String[] dependencies) {
//        this.dependencies = dependencies;
//    }
//
//    @Override
//    public String toString() {
//        return "TransactionEffects{" +
//                "status=" + status +
//                ", gasUsed=" + gasUsed +
//                ", sharedObjects=" + Arrays.toString(sharedObjects) +
//                ", transactionDigest='" + transactionDigest + '\'' +
//                ", created=" + Arrays.toString(created) +
//                ", mutated=" + Arrays.toString(mutated) +
//                ", unwrapped=" + Arrays.toString(unwrapped) +
//                ", deleted=" + Arrays.toString(deleted) +
//                ", wrapped=" + Arrays.toString(wrapped) +
//                ", gasObject=" + gasObject +
//                ", events=" + Arrays.toString(events) +
//                ", dependencies=" + Arrays.toString(dependencies) +
//                '}';
//    }
//}
