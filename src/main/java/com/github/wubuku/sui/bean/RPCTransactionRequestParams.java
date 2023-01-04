package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, JsonSchema)]
 * #[serde(rename_all = "camelCase")]
 * pub enum RPCTransactionRequestParams {
 *     TransferObjectRequestParams(TransferObjectParams),
 *     MoveCallRequestParams(MoveCallParams),
 * }
 * </pre>
 */
public interface RPCTransactionRequestParams {

    class TransferObjectRequestParams implements RPCTransactionRequestParams {
        private TransferObjectParams transferObjectRequestParams;

        public TransferObjectRequestParams() {
        }

        public TransferObjectRequestParams(TransferObjectParams transferObjectRequestParams) {
            this.transferObjectRequestParams = transferObjectRequestParams;
        }

        public TransferObjectParams getTransferObjectRequestParams() {
            return transferObjectRequestParams;
        }

        public void setTransferObjectRequestParams(TransferObjectParams transferObjectRequestParams) {
            this.transferObjectRequestParams = transferObjectRequestParams;
        }

        @Override
        public String toString() {
            return "TransferObjectRequestParams{" +
                    "transferObjectRequestParams=" + transferObjectRequestParams +
                    '}';
        }
    }

    class MoveCallRequestParams implements RPCTransactionRequestParams {
        private MoveCallParams moveCallRequestParams;

        public MoveCallRequestParams() {
        }

        public MoveCallRequestParams(MoveCallParams moveCallRequestParams) {
            this.moveCallRequestParams = moveCallRequestParams;
        }

        public MoveCallParams getMoveCallRequestParams() {
            return moveCallRequestParams;
        }

        public void setMoveCallRequestParams(MoveCallParams moveCallRequestParams) {
            this.moveCallRequestParams = moveCallRequestParams;
        }

        @Override
        public String toString() {
            return "MoveCallRequestParams{" +
                    "moveCallRequestParams=" + moveCallRequestParams +
                    '}';
        }
    }

}
