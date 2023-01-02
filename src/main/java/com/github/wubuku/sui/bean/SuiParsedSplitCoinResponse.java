package com.github.wubuku.sui.bean;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SuiParsedSplitCoinResponse = {
 *   updatedCoin: SuiObject;
 *   newCoins: SuiObject[];
 *   updatedGas: SuiObject;
 * };
 * </pre>
 */
public class SuiParsedSplitCoinResponse {
    private SuiObject updatedCoin;
    private SuiObject[] newCoins;
    private SuiObject updatedGas;

    public SuiParsedSplitCoinResponse() {
    }

    public SuiParsedSplitCoinResponse(SuiObject updatedCoin, SuiObject[] newCoins, SuiObject updatedGas) {
        this.updatedCoin = updatedCoin;
        this.newCoins = newCoins;
        this.updatedGas = updatedGas;
    }

    public SuiObject getUpdatedCoin() {
        return updatedCoin;
    }

    public void setUpdatedCoin(SuiObject updatedCoin) {
        this.updatedCoin = updatedCoin;
    }

    public SuiObject[] getNewCoins() {
        return newCoins;
    }

    public void setNewCoins(SuiObject[] newCoins) {
        this.newCoins = newCoins;
    }

    public SuiObject getUpdatedGas() {
        return updatedGas;
    }

    public void setUpdatedGas(SuiObject updatedGas) {
        this.updatedGas = updatedGas;
    }

    @Override
    public String toString() {
        return "SuiParsedSplitCoinResponse{" +
                "updatedCoin=" + updatedCoin +
                ", newCoins=" + Arrays.toString(newCoins) +
                ", updatedGas=" + updatedGas +
                '}';
    }
}
