package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type TransactionKindName =
 *   | 'TransferObject'
 *   | 'Publish'
 *   | 'Call'
 *   | 'TransferSui'
 *   | 'ChangeEpoch'
 *   | 'Pay'
 *   | 'PaySui'
 *   | 'PayAllSui';
 * </pre>
 */
public class TransactionKindName {
    public static final String TRANSFER_OBJECT = "TransferObject";
    public static final String PUBLISH = "Publish";
    public static final String CALL = "Call";
    public static final String TRANSFER_SUI = "TransferSui";
    public static final String CHANGE_EPOCH = "ChangeEpoch";
    public static final String PAY = "Pay";
    public static final String PAY_SUI = "PaySui";
    public static final String PAY_ALL_SUI = "PayAllSui";

    private TransactionKindName() {
    }
}
