package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 *
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct StakeSubsidy {
 *     pub epoch_counter: u64,
 *     pub balance: Balance,
 *     pub current_epoch_amount: u64,
 * }
 * </pre>
 */
public class StakeSubsidy {
    @JsonProperty("epoch_counter")
    private BigInteger epochCounter;
    @JsonProperty("balance")
    private Balance balance;
    @JsonProperty("current_epoch_amount")
    private BigInteger currentEpochAmount;

    public StakeSubsidy() {
    }

    public StakeSubsidy(BigInteger epochCounter, Balance balance, BigInteger currentEpochAmount) {
        this.epochCounter = epochCounter;
        this.balance = balance;
        this.currentEpochAmount = currentEpochAmount;
    }

    public BigInteger getEpochCounter() {
        return epochCounter;
    }

    public void setEpochCounter(BigInteger epochCounter) {
        this.epochCounter = epochCounter;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public BigInteger getCurrentEpochAmount() {
        return currentEpochAmount;
    }

    public void setCurrentEpochAmount(BigInteger currentEpochAmount) {
        this.currentEpochAmount = currentEpochAmount;
    }

    @Override
    public String toString() {
        return "StakeSubsidy{" +
                "epochCounter=" + epochCounter +
                ", balance=" + balance +
                ", currentEpochAmount=" + currentEpochAmount +
                '}';
    }
}
