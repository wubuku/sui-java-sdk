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
    public static final String WAIT_FOR_EFFECTS_CERT = "WaitForEffectsCert";
    public static final String WAIT_FOR_LOCAL_EXECUTION = "WaitForLocalExecution";

    private ExecuteTransactionRequestType() {
    }
}
