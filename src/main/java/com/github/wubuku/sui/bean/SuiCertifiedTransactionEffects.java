package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * // TODO: this is likely to go away after https://github.com/MystenLabs/sui/issues/4207
 * export type SuiCertifiedTransactionEffects = {
 *   effects: TransactionEffects;
 * };
 * </pre>
 */
public class SuiCertifiedTransactionEffects {
    private TransactionEffects effects;

    public SuiCertifiedTransactionEffects() {
    }

    public SuiCertifiedTransactionEffects(TransactionEffects effects) {
        this.effects = effects;
    }

    public TransactionEffects getEffects() {
        return effects;
    }

    public void setEffects(TransactionEffects effects) {
        this.effects = effects;
    }

    @Override
    public String toString() {
        return "SuiCertifiedTransactionEffects{" +
                "effects=" + effects +
                '}';
    }
}
