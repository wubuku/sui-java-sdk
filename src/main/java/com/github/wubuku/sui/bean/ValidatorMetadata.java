package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct ValidatorMetadata {
 *     pub sui_address: SuiAddress,
 *     pub pubkey_bytes: Vec<u8>,
 *     pub network_pubkey_bytes: Vec<u8>,
 *     pub proof_of_possession_bytes: Vec<u8>,
 *     pub name: Vec<u8>,
 *     pub net_address: Vec<u8>,
 *     pub next_epoch_stake: u64,
 *     pub next_epoch_delegation: u64,
 *     pub next_epoch_gas_price: u64,
 *     pub next_epoch_commission_rate: u64,
 * }
 * </pre>
 */
public class ValidatorMetadata {
    @JsonProperty("sui_address")
    private String suiAddress;
    @JsonProperty("pubkey_bytes")
    private int[] pubkeyBytes;
    @JsonProperty("network_pubkey_bytes")
    private int[] networkPubkeyBytes;
    @JsonProperty("worker_pubkey_bytes")
    private int[] workerPubkeyBytes;
    @JsonProperty("proof_of_possession_bytes")
    private int[] proofOfPossessionBytes;
    private int[] name;
    @JsonProperty("net_address")
    private int[] netAddress;
    @JsonProperty("consensus_address")
    private int[] consensusAddress;
    @JsonProperty("worker_address")
    private int[] workerAddress;
    @JsonProperty("next_epoch_stake")
    private BigInteger nextEpochStake;
    @JsonProperty("next_epoch_delegation")
    private BigInteger nextEpochDelegation;
    @JsonProperty("next_epoch_gas_price")
    private BigInteger nextEpochGasPrice;
    @JsonProperty("next_epoch_commission_rate")
    private BigInteger nextEpochCommissionRate;

    public String getSuiAddress() {
        return suiAddress;
    }

    public void setSuiAddress(String suiAddress) {
        this.suiAddress = suiAddress;
    }

    public int[] getPubkeyBytes() {
        return pubkeyBytes;
    }

    public void setPubkeyBytes(int[] pubkeyBytes) {
        this.pubkeyBytes = pubkeyBytes;
    }

    public int[] getNetworkPubkeyBytes() {
        return networkPubkeyBytes;
    }

    public void setNetworkPubkeyBytes(int[] networkPubkeyBytes) {
        this.networkPubkeyBytes = networkPubkeyBytes;
    }

    public int[] getProofOfPossessionBytes() {
        return proofOfPossessionBytes;
    }

    public void setProofOfPossessionBytes(int[] proofOfPossessionBytes) {
        this.proofOfPossessionBytes = proofOfPossessionBytes;
    }

    public int[] getName() {
        return name;
    }

    public void setName(int[] name) {
        this.name = name;
    }

    public int[] getNetAddress() {
        return netAddress;
    }

    public void setNetAddress(int[] netAddress) {
        this.netAddress = netAddress;
    }

    public BigInteger getNextEpochStake() {
        return nextEpochStake;
    }

    public void setNextEpochStake(BigInteger nextEpochStake) {
        this.nextEpochStake = nextEpochStake;
    }

    public BigInteger getNextEpochDelegation() {
        return nextEpochDelegation;
    }

    public void setNextEpochDelegation(BigInteger nextEpochDelegation) {
        this.nextEpochDelegation = nextEpochDelegation;
    }

    public BigInteger getNextEpochGasPrice() {
        return nextEpochGasPrice;
    }

    public void setNextEpochGasPrice(BigInteger nextEpochGasPrice) {
        this.nextEpochGasPrice = nextEpochGasPrice;
    }

    public BigInteger getNextEpochCommissionRate() {
        return nextEpochCommissionRate;
    }

    public void setNextEpochCommissionRate(BigInteger nextEpochCommissionRate) {
        this.nextEpochCommissionRate = nextEpochCommissionRate;
    }

    public int[] getWorkerPubkeyBytes() {
        return workerPubkeyBytes;
    }

    public void setWorkerPubkeyBytes(int[] workerPubkeyBytes) {
        this.workerPubkeyBytes = workerPubkeyBytes;
    }

    public int[] getConsensusAddress() {
        return consensusAddress;
    }

    public void setConsensusAddress(int[] consensusAddress) {
        this.consensusAddress = consensusAddress;
    }

    public int[] getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(int[] workerAddress) {
        this.workerAddress = workerAddress;
    }

    @Override
    public String toString() {
        return "ValidatorMetadata{" +
                "suiAddress='" + suiAddress + '\'' +
                ", pubkeyBytes=" + Arrays.toString(pubkeyBytes) +
                ", networkPubkeyBytes=" + Arrays.toString(networkPubkeyBytes) +
                ", workerPubkeyBytes=" + Arrays.toString(workerPubkeyBytes) +
                ", proofOfPossessionBytes=" + Arrays.toString(proofOfPossessionBytes) +
                ", name=" + Arrays.toString(name) +
                ", netAddress=" + Arrays.toString(netAddress) +
                ", consensusAddress=" + Arrays.toString(consensusAddress) +
                ", workerAddress=" + Arrays.toString(workerAddress) +
                ", nextEpochStake=" + nextEpochStake +
                ", nextEpochDelegation=" + nextEpochDelegation +
                ", nextEpochGasPrice=" + nextEpochGasPrice +
                ", nextEpochCommissionRate=" + nextEpochCommissionRate +
                '}';
    }
}
