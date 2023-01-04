package com.github.wubuku.sui.bean;

public class EventType {
    public static final String MOVE_EVENT = "MoveEvent";
    public static final String PUBLISH = "Publish";
    public static final String TRANSFER_OBJECT = "TransferObject";
    public static final String MUTATE_OBJECT = "MutateObject";
    public static final String COIN_BALANCE_CHANGE = "CoinBalanceChange";
    public static final String DELETE_OBJECT = "DeleteObject";
    public static final String NEW_OBJECT = "NewObject";
    public static final String EPOCH_CHANGE = "EpochChange";
    public static final String CHECKPOINT = "Checkpoint";

    private EventType() {
    }

}
