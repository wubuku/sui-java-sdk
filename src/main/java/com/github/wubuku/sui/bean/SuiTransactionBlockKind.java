package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigInteger;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * #[serde(rename = "TransactionBlockKind", tag = "kind")]
 * pub enum SuiTransactionBlockKind {
 *     /// A system transaction that will update epoch information on-chain.
 *     ChangeEpoch(SuiChangeEpoch),
 *     /// A system transaction used for initializing the initial state of the chain.
 *     Genesis(SuiGenesisTransaction),
 *     /// A system transaction marking the start of a series of transactions scheduled as part of a
 *     /// checkpoint
 *     ConsensusCommitPrologue(SuiConsensusCommitPrologue),
 *     /// A series of transactions where the results of one transaction can be used in future
 *     /// transactions
 *     ProgrammableTransaction(SuiProgrammableTransactionBlock),
 *     // .. more transaction types go here
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiTransactionBlockKindDeserializer.class)
public interface SuiTransactionBlockKind {

    String getKind();

    class ChangeEpoch extends SuiChangeEpoch implements SuiTransactionBlockKind {
        public ChangeEpoch() {
        }

        public ChangeEpoch(BigInteger epoch, Long storageCharge, Long computationCharge, Long storageRebate, Long epochStartTimestampMs) {
            super(epoch, storageCharge, computationCharge, storageRebate, epochStartTimestampMs);
        }

        @Override
        public String getKind() {
            return "ChangeEpoch";
        }

    }

    class Genesis extends SuiGenesisTransaction implements SuiTransactionBlockKind {
        public Genesis() {
        }

        public Genesis(String[] objects) {
            super(objects);
        }

        @Override
        public String getKind() {
            return "Genesis";
        }
    }

    class ConsensusCommitPrologue extends SuiConsensusCommitPrologue implements SuiTransactionBlockKind {
        public ConsensusCommitPrologue() {
        }

        public ConsensusCommitPrologue(BigInteger epoch, BigInteger round, BigInteger commitTimestampMS) {
            super(epoch, round, commitTimestampMS);
        }

        @Override
        public String getKind() {
            return "ConsensusCommitPrologue";
        }

    }

    class ProgrammableTransaction extends SuiProgrammableTransactionBlock implements SuiTransactionBlockKind {
        public ProgrammableTransaction() {
        }

        public ProgrammableTransaction(SuiCallArg[] inputs, Object[] transactions) {
            super(inputs, transactions);
        }

        @Override
        public String getKind() {
            return "ProgrammableTransaction";
        }

    }

}
