package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::staking_pool::PendingWithdrawEntry type.
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct PendingWithdrawEntry {
 *     delegator: SuiAddress,
 *     principal_withdraw_amount: u64,
 *     withdrawn_pool_tokens: Balance,
 * }
 * </pre>
 */
public class PendingWithdrawEntry {
    private String delegator;
    @JsonProperty("principal_withdraw_amount")
    private BigInteger principalWithdrawAmount;
    @JsonProperty("withdrawn_pool_tokens")
    private Balance withdrawnPoolTokens;

    public PendingWithdrawEntry() {
    }

    public PendingWithdrawEntry(String delegator, BigInteger principalWithdrawAmount, Balance withdrawnPoolTokens) {
        this.delegator = delegator;
        this.principalWithdrawAmount = principalWithdrawAmount;
        this.withdrawnPoolTokens = withdrawnPoolTokens;
    }

    public String getDelegator() {
        return delegator;
    }

    public void setDelegator(String delegator) {
        this.delegator = delegator;
    }

    public BigInteger getPrincipalWithdrawAmount() {
        return principalWithdrawAmount;
    }

    public void setPrincipalWithdrawAmount(BigInteger principalWithdrawAmount) {
        this.principalWithdrawAmount = principalWithdrawAmount;
    }

    public Balance getWithdrawnPoolTokens() {
        return withdrawnPoolTokens;
    }

    public void setWithdrawnPoolTokens(Balance withdrawnPoolTokens) {
        this.withdrawnPoolTokens = withdrawnPoolTokens;
    }

    @Override
    public String toString() {
        return "PendingWithdrawEntry{" +
                "delegator='" + delegator + '\'' +
                ", principalWithdrawAmount=" + principalWithdrawAmount +
                ", withdrawnPoolTokens=" + withdrawnPoolTokens +
                '}';
    }
}
