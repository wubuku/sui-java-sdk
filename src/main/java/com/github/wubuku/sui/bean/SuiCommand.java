package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Debug, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * #[serde(rename = "SuiTransaction")]
 * pub enum SuiCommand {
 *     /// A call to either an entry or a public Move function
 *     MoveCall(Box<SuiProgrammableMoveCall>),
 *     /// `(Vec<forall T:key+store. T>, address)`
 *     /// It sends n-objects to the specified address. These objects must have store
 *     /// (public transfer) and either the previous owner must be an address or the object must
 *     /// be newly created.
 *     TransferObjects(Vec<SuiArgument>, SuiArgument),
 *     /// `(&mut Coin<T>, Vec<u64>)` -> `Vec<Coin<T>>`
 *     /// It splits off some amounts into a new coins with those amounts
 *     SplitCoins(SuiArgument, Vec<SuiArgument>),
 *     /// `(&mut Coin<T>, Vec<Coin<T>>)`
 *     /// It merges n-coins into the first coin
 *     MergeCoins(SuiArgument, Vec<SuiArgument>),
 *     /// Publishes a Move package. It takes the package bytes and a list of the package's transitive
 *     /// dependencies to link against on-chain.
 *     Publish(SuiMovePackage, Vec<ObjectID>),
 *     /// Upgrades a Move package
 *     Upgrade(SuiMovePackage, Vec<ObjectID>, ObjectID, SuiArgument),
 *     /// `forall T: Vec<T> -> vector<T>`
 *     /// Given n-values of the same type, it constructs a vector. For non objects or an empty vector,
 *     /// the type tag must be specified.
 *     MakeMoveVec(Option<String>, Vec<SuiArgument>),
 * }
 * </pre>
 */
public interface SuiCommand {
    class MoveCall implements SuiCommand {
        @JsonProperty("MoveCall")
        private SuiProgrammableMoveCall moveCall;

        public SuiProgrammableMoveCall getMoveCall() {
            return moveCall;
        }

        public void setMoveCall(SuiProgrammableMoveCall moveCall) {
            this.moveCall = moveCall;
        }
    }

    /**
     * Example:
     * <pre>
     *               "TransferObjects": [
     *                 [
     *                   {
     *                     "Input": 1
     *                   }
     *                 ],
     *                 {
     *                   "Input": 0
     *                 }
     *               ]
     * </pre>
     */
    class TransferObjects implements SuiCommand {
        @JsonProperty("TransferObjects")
        private SuiArgumentVecOrSuiArgument[] transferObjects;

        //todo ...
    }

    interface SuiArgumentVecOrSuiArgument {
        class SuiArgumentVec extends ArrayList<com.github.wubuku.sui.bean.SuiArgument> implements SuiArgumentVecOrSuiArgument {
        }

        class SuiArgument implements com.github.wubuku.sui.bean.SuiArgument, SuiArgumentVecOrSuiArgument {
        }
    }
}
