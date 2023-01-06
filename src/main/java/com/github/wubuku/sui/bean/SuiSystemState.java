package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::sui_system::SuiSystemState type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct SuiSystemState {
 *     pub info: UID,
 *     pub chain_id: ChainId,
 *     pub epoch: u64,
 *     pub validators: ValidatorSet,
 *     pub treasury_cap: Supply,
 *     pub storage_fund: Balance,
 *     pub parameters: SystemParameters,
 *     pub reference_gas_price: u64,
 *     pub validator_report_records: VecMap<SuiAddress, VecSet<SuiAddress>>,
 * }
 * </pre>
 */
public class SuiSystemState {
    private UID info;
    @JsonProperty("chain_id")
    private Integer chainId;
    private BigInteger epoch;
    private ValidatorSet validators;
    @JsonProperty("treasury_cap")
    private Supply treasuryCap;
    @JsonProperty("storage_fund")
    private Balance storageFund;
    private SystemParameters parameters;
    @JsonProperty("reference_gas_price")
    private BigInteger referenceGasPrice;
    @JsonProperty("validator_report_records")
    private ValidatorReportRecords validatorReportRecords;
    @JsonProperty("stake_subsidy")
    private StakeSubsidy stakeSubsidy;

    public SuiSystemState() {
    }

    public UID getInfo() {
        return info;
    }

    public void setInfo(UID info) {
        this.info = info;
    }

    public Integer getChainId() {
        return chainId;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public BigInteger getEpoch() {
        return epoch;
    }

    public void setEpoch(BigInteger epoch) {
        this.epoch = epoch;
    }

    public ValidatorSet getValidators() {
        return validators;
    }

    public void setValidators(ValidatorSet validators) {
        this.validators = validators;
    }

    public Supply getTreasuryCap() {
        return treasuryCap;
    }

    public void setTreasuryCap(Supply treasuryCap) {
        this.treasuryCap = treasuryCap;
    }

    public Balance getStorageFund() {
        return storageFund;
    }

    public void setStorageFund(Balance storageFund) {
        this.storageFund = storageFund;
    }

    public SystemParameters getParameters() {
        return parameters;
    }

    public void setParameters(SystemParameters parameters) {
        this.parameters = parameters;
    }

    public BigInteger getReferenceGasPrice() {
        return referenceGasPrice;
    }

    public void setReferenceGasPrice(BigInteger referenceGasPrice) {
        this.referenceGasPrice = referenceGasPrice;
    }

    public ValidatorReportRecords getValidatorReportRecords() {
        return validatorReportRecords;
    }

    public void setValidatorReportRecords(ValidatorReportRecords validatorReportRecords) {
        this.validatorReportRecords = validatorReportRecords;
    }

    public StakeSubsidy getStakeSubsidy() {
        return stakeSubsidy;
    }

    public void setStakeSubsidy(StakeSubsidy stakeSubsidy) {
        this.stakeSubsidy = stakeSubsidy;
    }

    @Override
    public String toString() {
        return "SuiSystemState{" +
                "info=" + info +
                ", chainId=" + chainId +
                ", epoch=" + epoch +
                ", validators=" + validators +
                ", treasuryCap=" + treasuryCap +
                ", storageFund=" + storageFund +
                ", parameters=" + parameters +
                ", referenceGasPrice=" + referenceGasPrice +
                ", validatorReportRecords=" + validatorReportRecords +
                ", stakeSubsidy=" + stakeSubsidy +
                '}';
    }

    public static class ValidatorReportRecords extends VecMap<String, VecSet<String>> {
        public ValidatorReportRecords() {
        }

        public ValidatorReportRecords(Entry<String, VecSet<String>>[] contents) {
            super(contents);
        }
    }
}
