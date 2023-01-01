package com.github.wubuku.sui.bean;

import java.math.BigInteger;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiEvent =
 * | { moveEvent: MoveEvent }
 * | { publish: PublishEvent }
 * | { coinBalanceChange: CoinBalanceChangeEvent }
 * | { transferObject: TransferObjectEvent }
 * | { mutateObject: MutateObjectEvent }
 * | { deleteObject: DeleteObjectEvent }
 * | { newObject: NewObjectEvent }
 * | { epochChange: bigint }
 * | { checkpoint: bigint };
 * </pre>
 */
public interface SuiEvent {

    class MoveEvent implements SuiEvent {
        private com.github.wubuku.sui.bean.MoveEvent moveEvent;

        public MoveEvent() {
        }

        public MoveEvent(com.github.wubuku.sui.bean.MoveEvent moveEvent) {
            this.moveEvent = moveEvent;
        }

        public com.github.wubuku.sui.bean.MoveEvent getMoveEvent() {
            return moveEvent;
        }

        public void setMoveEvent(com.github.wubuku.sui.bean.MoveEvent moveEvent) {
            this.moveEvent = moveEvent;
        }

        @Override
        public String toString() {
            return "MoveEvent{" +
                    "moveEvent='" + moveEvent + '\'' +
                    '}';
        }
    }

    class Publish implements SuiEvent {
        private com.github.wubuku.sui.bean.PublishEvent publish;

        public Publish() {
        }

        public Publish(com.github.wubuku.sui.bean.PublishEvent publish) {
            this.publish = publish;
        }

        public com.github.wubuku.sui.bean.PublishEvent getPublish() {
            return publish;
        }

        public void setPublish(com.github.wubuku.sui.bean.PublishEvent publish) {
            this.publish = publish;
        }

        @Override
        public String toString() {
            return "Publish{" +
                    "publish=" + publish +
                    '}';
        }
    }

    class CoinBalanceChange implements SuiEvent {
        private com.github.wubuku.sui.bean.CoinBalanceChangeEvent coinBalanceChange;

        public CoinBalanceChange() {
        }

        public CoinBalanceChange(com.github.wubuku.sui.bean.CoinBalanceChangeEvent coinBalanceChange) {
            this.coinBalanceChange = coinBalanceChange;
        }

        public com.github.wubuku.sui.bean.CoinBalanceChangeEvent getCoinBalanceChange() {
            return coinBalanceChange;
        }

        public void setCoinBalanceChange(com.github.wubuku.sui.bean.CoinBalanceChangeEvent coinBalanceChange) {
            this.coinBalanceChange = coinBalanceChange;
        }

        @Override
        public String toString() {
            return "CoinBalanceChange{" +
                    "coinBalanceChange=" + coinBalanceChange +
                    '}';
        }
    }

    class TransferObject implements SuiEvent {
        private com.github.wubuku.sui.bean.TransferObjectEvent transferObject;

        public TransferObject() {
        }

        public TransferObject(com.github.wubuku.sui.bean.TransferObjectEvent transferObject) {
            this.transferObject = transferObject;
        }

        public com.github.wubuku.sui.bean.TransferObjectEvent getTransferObject() {
            return transferObject;
        }

        public void setTransferObject(com.github.wubuku.sui.bean.TransferObjectEvent transferObject) {
            this.transferObject = transferObject;
        }

        @Override
        public String toString() {
            return "TransferObject{" +
                    "transferObject=" + transferObject +
                    '}';
        }
    }

    class MutateObject implements SuiEvent {
        private com.github.wubuku.sui.bean.MutateObjectEvent mutateObject;

        public MutateObject() {
        }

        public MutateObject(com.github.wubuku.sui.bean.MutateObjectEvent mutateObject) {
            this.mutateObject = mutateObject;
        }

        public com.github.wubuku.sui.bean.MutateObjectEvent getMutateObject() {
            return mutateObject;
        }

        public void setMutateObject(com.github.wubuku.sui.bean.MutateObjectEvent mutateObject) {
            this.mutateObject = mutateObject;
        }

        @Override
        public String toString() {
            return "MutateObject{" +
                    "mutateObject=" + mutateObject +
                    '}';
        }
    }

    class DeleteObject implements SuiEvent {
        private com.github.wubuku.sui.bean.DeleteObjectEvent deleteObject;

        public DeleteObject() {
        }

        public DeleteObject(com.github.wubuku.sui.bean.DeleteObjectEvent deleteObject) {
            this.deleteObject = deleteObject;
        }

        public com.github.wubuku.sui.bean.DeleteObjectEvent getDeleteObject() {
            return deleteObject;
        }

        public void setDeleteObject(com.github.wubuku.sui.bean.DeleteObjectEvent deleteObject) {
            this.deleteObject = deleteObject;
        }

        @Override
        public String toString() {
            return "DeleteObject{" +
                    "deleteObject=" + deleteObject +
                    '}';
        }
    }

    class NewObject implements SuiEvent {
        private com.github.wubuku.sui.bean.NewObjectEvent newObject;

        public NewObject() {
        }

        public NewObject(com.github.wubuku.sui.bean.NewObjectEvent newObject) {
            this.newObject = newObject;
        }

        public com.github.wubuku.sui.bean.NewObjectEvent getNewObject() {
            return newObject;
        }

        public void setNewObject(com.github.wubuku.sui.bean.NewObjectEvent newObject) {
            this.newObject = newObject;
        }

        @Override
        public String toString() {
            return "NewObject{" +
                    "newObject=" + newObject +
                    '}';
        }
    }

    class EpochChange implements SuiEvent {
        private BigInteger epochChange;

        public EpochChange() {
        }

        public EpochChange(BigInteger epochChange) {
            this.epochChange = epochChange;
        }

        public BigInteger getEpochChange() {
            return epochChange;
        }

        public void setEpochChange(BigInteger epochChange) {
            this.epochChange = epochChange;
        }

        @Override
        public String toString() {
            return "EpochChange{" +
                    "epochChange=" + epochChange +
                    '}';
        }
    }

    class Checkpoint implements SuiEvent {
        private BigInteger checkpoint;

        public Checkpoint() {
        }

        public Checkpoint(BigInteger checkpoint) {
            this.checkpoint = checkpoint;
        }

        public BigInteger getCheckpoint() {
            return checkpoint;
        }

        public void setCheckpoint(BigInteger checkpoint) {
            this.checkpoint = checkpoint;
        }

        @Override
        public String toString() {
            return "Checkpoint{" +
                    "checkpoint=" + checkpoint +
                    '}';
        }
    }
}
