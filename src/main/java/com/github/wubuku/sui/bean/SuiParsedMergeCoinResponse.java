package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiParsedMergeCoinResponse = {
 *   updatedCoin: SuiObject;
 *   updatedGas: SuiObject;
 * };
 * </pre>
 */
public class SuiParsedMergeCoinResponse {
    private SuiObject updatedCoin;
    private SuiObject updatedGas;

    public SuiParsedMergeCoinResponse() {
    }

    public SuiParsedMergeCoinResponse(SuiObject updatedCoin, SuiObject updatedGas) {
        this.updatedCoin = updatedCoin;
        this.updatedGas = updatedGas;
    }

    public SuiObject getUpdatedCoin() {
        return updatedCoin;
    }

    public void setUpdatedCoin(SuiObject updatedCoin) {
        this.updatedCoin = updatedCoin;
    }

    public SuiObject getUpdatedGas() {
        return updatedGas;
    }

    public void setUpdatedGas(SuiObject updatedGas) {
        this.updatedGas = updatedGas;
    }

    @Override
    public String toString() {
        return "SuiParsedMergeCoinResponse{" +
                "updatedCoin=" + updatedCoin +
                ", updatedGas=" + updatedGas +
                '}';
    }
}
