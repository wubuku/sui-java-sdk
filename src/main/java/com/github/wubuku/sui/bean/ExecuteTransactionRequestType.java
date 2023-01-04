package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type ExecuteTransactionRequestType =
 *   | 'ImmediateReturn'
 *   | 'WaitForTxCert'
 *   | 'WaitForEffectsCert'
 *   | 'WaitForLocalExecution';
 * </pre>
 */
public class ExecuteTransactionRequestType {

    public static final String IMMEDIATE_RETURN = "ImmediateReturn";
    public static final String WAIT_FOR_TX_CERT = "WaitForTxCert";
    /**
     * 1. WaitForEffectsCert: waits for TransactionEffectsCert and then return to client.
     * This mode is a proxy for transaction finality.
     */
    public static final String WAIT_FOR_EFFECTS_CERT = "WaitForEffectsCert";
    /**
     * 2. WaitForLocalExecution: waits for TransactionEffectsCert and make sure the node executed the transaction locally before returning the client.
     * The local execution makes sure this node is aware of this transaction when client fires subsequent queries.
     * However, if the node fails to execute the transaction locally in a timely manner, a bool type in the response is set to false to indicated the case.
     */
    public static final String WAIT_FOR_LOCAL_EXECUTION = "WaitForLocalExecution";

    private ExecuteTransactionRequestType() {
    }
}
