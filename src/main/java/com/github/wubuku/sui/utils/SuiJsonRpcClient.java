package com.github.wubuku.sui.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.wubuku.sui.bean.*;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;
import org.starcoin.jsonrpc.client.JSONRPC2Session;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuiJsonRpcClient {
    private final JSONRPC2Session jsonrpc2Session;

    /**
     * @param url The JSON RPC server URL.
     */
    public SuiJsonRpcClient(String url) throws MalformedURLException {
        this.jsonrpc2Session = new JSONRPC2Session(new URL(url));
    }

    private static void assertSuccess(JSONRPC2Response<?> response) {
        if (!response.indicatesSuccess()) {
            throw new RuntimeException(response.getError().toString());
        }
    }

    protected JSONRPC2Session getJSONRPC2Session() {
        return jsonrpc2Session;
    }

    public SuiTransactionResponse getTransaction(String digest) {
        List<Object> params = new ArrayList<>();
        params.add(digest);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getTransaction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiTransactionResponse> jsonrpc2Response = getJSONRPC2Session().send(jsonrpc2Request,
                    SuiTransactionResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public TransactionsPage getTransactions(TransactionQuery query,
                                            String cursor,
                                            int limit,
                                            boolean descendingOrder) {
        List<Object> params = new ArrayList<>();
        params.add(query);
        params.add(cursor);
        params.add(limit);
        params.add(descendingOrder);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getTransactions", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<TransactionsPage> jsonrpc2Response = getJSONRPC2Session().send(jsonrpc2Request,
                    TransactionsPage.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getTransactionsInRange(long start, long end) {
        List<Object> params = new ArrayList<>();
        params.add(start);
        params.add(end);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getTransactionsInRange", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<String>> jsonrpc2Response = getJSONRPC2Session().send(jsonrpc2Request,
                    new TypeReference<List<String>>() {
                    });
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public <F> PaginatedMoveEvents<F> getMoveEvents(String moveEvent,
                                                    EventId cursor, int limit, boolean descendingOrder,
                                                    Class<F> moveEventFieldsType) {
        List<Object> params = new ArrayList<>();
        params.add(new EventQuery.MoveEvent(moveEvent));
        params.add(cursor);
        params.add(limit);
        params.add(descendingOrder);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getEvents", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<PaginatedMoveEvents<F>> jsonrpc2Response = getJSONRPC2Session()
                    .sendAndGetParametricTypeResult(jsonrpc2Request, PaginatedMoveEvents.class, moveEventFieldsType);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public PaginatedEvents getEvents(EventQuery query, EventId cursor, int limit, boolean descendingOrder) {
        List<Object> params = new ArrayList<>();
        params.add(query);
        params.add(cursor);
        params.add(limit);
        params.add(descendingOrder);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getEvents", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<PaginatedEvents> jsonrpc2Response = getJSONRPC2Session().send(jsonrpc2Request,
                    new TypeReference<PaginatedEvents>() {
                    });
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuiObjectInfo> getObjectsOwnedByAddress(String address) {
        List<Object> params = new ArrayList<>();
        params.add(address);
        return getObjects("sui_getObjectsOwnedByAddress", params);
    }

    /**
     * @param objectId the ID of the owner object
     */
    public List<SuiObjectInfo> getObjectsOwnedByObject(String objectId) {
        List<Object> params = new ArrayList<>();
        params.add(objectId);
        return getObjects("sui_getObjectsOwnedByObject", params);
    }

    private List<SuiObjectInfo> getObjects(String method, List<Object> params) {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request(method, params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<SuiObjectInfo>> jsonrpc2Response = jsonrpc2Session.sendAndGetListResult(
                    jsonrpc2Request, SuiObjectInfo.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public GetObjectDataResponse getObject(String objectId) {
        List<Object> params = new ArrayList<>();
        params.add(objectId);
        return getObject("sui_getObject", params);
    }

    public GetObjectDataResponse getDynamicFieldObject(String parentObjectId, String field) {
        List<Object> params = new ArrayList<>();
        params.add(parentObjectId);
        params.add(field);
        return getObject("sui_getDynamicFieldObject", params);
    }

    private GetObjectDataResponse getObject(String method, List<Object> params) {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request(method, params, System.currentTimeMillis());
        try {
            JSONRPC2Response<GetObjectDataResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    GetObjectDataResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public GetRawObjectDataResponse getRawObject(String objectId) {
        List<Object> params = new ArrayList<>();
        params.add(objectId);
        return getRawObject("sui_getRawObject", params);
    }

    private GetRawObjectDataResponse getRawObject(String method, List<Object> params) {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request(method, params, System.currentTimeMillis());
        try {
            JSONRPC2Response<GetRawObjectDataResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    GetRawObjectDataResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public GetPastObjectDataResponse tryGetPastObject(String objectId, Long version) {
        List<Object> params = new ArrayList<>();
        params.add(objectId);
        params.add(version);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_tryGetPastObject", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<GetPastObjectDataResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    GetPastObjectDataResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public CoinPage getCoins(String owner, String coinType, String cursor, int limit) {
        List<Object> params = new ArrayList<>();
        params.add(owner);
        params.add(coinType);
        params.add(cursor);
        params.add(limit);
        return getCoins("sui_getCoins", params);
    }

    public CoinPage getAllCoins(String owner, String cursor, int limit) {
        List<Object> params = new ArrayList<>();
        params.add(owner);
        params.add(cursor);
        params.add(limit);
        return getCoins("sui_getAllCoins", params);
    }

    private CoinPage getCoins(String method, List<Object> params) {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request(method, params, System.currentTimeMillis());
        try {
            JSONRPC2Response<CoinPage> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request, CoinPage.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiCoinMetadata getCoinMetadata(String coinType) {
        List<Object> params = new ArrayList<>();
        params.add(coinType);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getCoinMetadata", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiCoinMetadata> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiCoinMetadata.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public Supply getTotalSupply(String coinType) {
        List<Object> params = new ArrayList<>();
        params.add(coinType);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getTotalSupply", params, System.currentTimeMillis());
        try {
            JSONRPC2Response<Supply> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request, Supply.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public CoinBalance getBalance(String owner, String coinType) {
        List<Object> params = new ArrayList<>();
        params.add(owner);
        params.add(coinType);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getBalance", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<CoinBalance> jsonrpc2Response = jsonrpc2Session
                    .send(jsonrpc2Request, CoinBalance.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CoinBalance> getAllBalances(String owner) {
        List<Object> params = new ArrayList<>();
        params.add(owner);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getAllBalances", params, System.currentTimeMillis());
        try {
            JSONRPC2Response<List<CoinBalance>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetListResult(jsonrpc2Request, CoinBalance.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Create an unsigned transaction to execute a Move call on the network, by calling the specified function in the module of a given package.
     *
     * @param signerAddress   the transaction signer's Sui address
     * @param packageObjectId the Move package ID, e.g. `0x2`
     * @param module          the Move module name, e.g. `devnet_nft`
     * @param function        the move function name, e.g. `mint`
     * @param typeArguments   the type arguments of the Move function
     * @param arguments       the arguments to be passed into the Move function, in <a href="https://docs.sui.io/build/sui-json">SuiJson</a> format
     * @param gasPayment      gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget       the gas budget, the transaction will fail if the gas cost exceed the budget
     * @param executionMode   Whether this is a Normal transaction or a Dev Inspect Transaction. Default to be `SuiTransactionBuilderMode::Commit` when it's None.
     */
    public TransactionBytes moveCall(String signerAddress,
                                     String packageObjectId, String module, String function,
                                     String[] typeArguments, // TypeTag[] typeArguments,
                                     SuiJsonValue[] arguments,
                                     String gasPayment, long gasBudget,
                                     String executionMode
    ) {
        List<Object> params = new ArrayList<>();
        params.add(signerAddress);
        params.add(packageObjectId);
        params.add(module);
        params.add(function);
        params.add(typeArguments);
        params.add(arguments);
        params.add(gasPayment);
        params.add(gasBudget);
        if (executionMode != null) {
            params.add(executionMode);
        }
        return moveCall(params);
    }

    private TransactionBytes moveCall(List<Object> params) {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_moveCall", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<TransactionBytes> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    TransactionBytes.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Create an unsigned transaction to send SUI coin object to a Sui address. The SUI object is also used as the gas object.
     *
     * @param signer      the transaction signer's Sui address
     * @param suiObjectId the Sui coin object to be used in this transaction
     * @param gasBudget   the gas budget, the transaction will fail if the gas cost exceed the budget
     * @param recipient   the recipient's Sui address
     * @param amount      the amount to be split out and transferred
     */
    public TransactionBytes transferSui(
            String signer,
            String suiObjectId,
            long gasBudget,
            String recipient,
            long amount
    ) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(suiObjectId);
        params.add(gasBudget);
        params.add(recipient);
        params.add(amount);

        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_transferSui", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<TransactionBytes> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    TransactionBytes.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param signer                       the transaction signer's Sui address
     * @param transactionRequestParamsList list of transaction request parameters
     * @param gas                          gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget                    the gas budget, the transaction will fail if the gas cost exceed the budget
     * @param txnBuilderMode               Whether this is a regular transaction or a Dev Inspect Transaction
     */
    public TransactionBytes batchTransaction(
            String signer,
            RPCTransactionRequestParams[] transactionRequestParamsList,
            String gas,
            long gasBudget,
            String txnBuilderMode
    ) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(transactionRequestParamsList);
        params.add(gas);
        params.add(gasBudget);
        if (txnBuilderMode != null) {
            params.add(txnBuilderMode);
        }
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_batchTransaction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<TransactionBytes> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    TransactionBytes.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param txBytes     BCS serialized transaction data bytes without its type tag, as base-64 encoded string.
     * @param sigScheme   Flag of the signature scheme that is used.
     * @param signature   Signature committed to the intent message of the transaction data, as base-64 encoded string.
     * @param pubKey      Signer's public key, as base-64 encoded string.
     * @param requestType The request type.
     */
    public SuiExecuteTransactionResponse executeTransaction(
            String txBytes,
            String sigScheme,
            String signature,
            String pubKey,
            String requestType
    ) {
        List<Object> params = new ArrayList<>();
        params.add(txBytes);
        params.add(sigScheme);
        params.add(signature);
        params.add(pubKey);
        params.add(requestType);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_executeTransaction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiExecuteTransactionResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiExecuteTransactionResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public TransactionEffects dryRunTransaction(
            String txBytes
    ) {
        List<Object> params = new ArrayList<>();
        params.add(txBytes);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_dryRunTransaction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<TransactionEffects> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    TransactionEffects.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public DevInspectResults devInspectTransaction(String txBytes) {
        List<Object> params = new ArrayList<>();
        params.add(txBytes);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_devInspectTransaction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<DevInspectResults> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    DevInspectResults.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public Long getTotalTransactionNumber() {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getTotalTransactionNumber", Collections.emptyList(),
                System.currentTimeMillis());
        try {
            JSONRPC2Response<Long> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    Long.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public CommitteeInfoResponse getCommitteeInfo(Long epoch) {
        List<Object> params = new ArrayList<>();
        params.add(epoch);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getCommitteeInfo", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<CommitteeInfoResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    CommitteeInfoResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiSystemState getSuiSystemState() {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getSuiSystemState", Collections.emptyList(),
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiSystemState> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiSystemState.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

}
