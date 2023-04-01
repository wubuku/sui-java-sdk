package com.github.wubuku.sui.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.wubuku.sui.bean.*;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;
import org.starcoin.jsonrpc.client.JSONRPC2Session;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    public SuiTransactionBlockResponse getTransactionBlock(String digest, SuiTransactionBlockResponseOptions options) {
        List<Object> params = new ArrayList<>();
        params.add(digest);
        params.add(options);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getTransactionBlock", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiTransactionBlockResponse> jsonrpc2Response = getJSONRPC2Session().send(jsonrpc2Request,
                    SuiTransactionBlockResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiTransactionResponse getTransaction(String digest) { //todo remove this method
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

    public <F> PaginatedMoveEvents<F> queryMoveEvents(String moveEvent,
                                                      EventId cursor, int limit, boolean descendingOrder,
                                                      Class<F> moveEventFieldsType) {
        List<Object> params = new ArrayList<>();
        params.add(new SuiEventFilter.MoveEventType(moveEvent));
        params.add(cursor);
        params.add(limit);
        params.add(descendingOrder);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("suix_queryEvents", params,
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

    public PaginatedEvents queryEvents(SuiEventFilter query, EventId cursor, int limit, boolean descendingOrder) {
        List<Object> params = new ArrayList<>();
        params.add(query);
        params.add(cursor);
        params.add(limit);
        params.add(descendingOrder);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("suix_queryEvents", params,
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

//    /**
//     * @param objectId the ID of the owner object
//     */
//    public List<SuiObjectInfo> getObjectsOwnedByObject(String objectId) {
//        List<Object> params = new ArrayList<>();
//        params.add(objectId);
//        return getObjects("sui_getObjectsOwnedByObject", params);
//    }

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

    public <T> SuiMoveObjectResponse<T> getMoveObject(String objectId, SuiObjectDataOptions options, Class<T> objectType) {
        options.setShowContent(true);// set showContent to true to get the parsed JSON content
        List<Object> params = new ArrayList<>();
        params.add(objectId);
        params.add(options);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getObject", params, System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiMoveObjectResponse<T>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetParametricTypeResult(jsonrpc2Request, SuiMoveObjectResponse.class, objectType);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiObjectResponse getObject(String objectId, SuiObjectDataOptions options) {
        List<Object> params = new ArrayList<>();
        params.add(objectId);
        params.add(options);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getObject", params, System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiObjectResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiObjectResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * suix_getDynamicFieldObject
     * <p>
     * Extended API.
     * Return the dynamic field object information for a specified object
     * <p>
     *
     * @param parentObjectId
     * @param name
     * @return
     */
    public SuiObjectResponse getDynamicFieldObject(String parentObjectId,
                                                   Object name // DynamicFieldName
    ) {
        List<Object> params = new ArrayList<>();
        params.add(parentObjectId);
        params.add(name);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("suix_getDynamicFieldObject", params, System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiObjectResponse> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiObjectResponse.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }


    public <T> SuiMoveObjectResponse<T> getDynamicFieldMoveObject(String parentObjectId,
                                                                  Object name, // DynamicFieldName
                                                                  Class<T> objectType) {
        // have been changed to 'suix_getDynamicFieldObject'
        List<Object> params = new ArrayList<>();
        params.add(parentObjectId);
        params.add(name);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getDynamicFieldObject", params, System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiMoveObjectResponse<T>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetParametricTypeResult(jsonrpc2Request, GetMoveObjectDataResponse.class, objectType);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return the list of dynamic field objects owned by an object.
     *
     * @param parentObjectId The ID of the parent object
     * @param cursor         Optional paging cursor
     * @param limit          Maximum item returned per page, default to [QUERY_MAX_RESULT_LIMIT] if not specified.
     */
    public DynamicFieldPage getDynamicFields(
            String parentObjectId, String cursor, Integer limit
    ) {
        List<Object> params = new ArrayList<>();
        params.add(parentObjectId);
        params.add(cursor);
        params.add(limit);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getDynamicFields", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<DynamicFieldPage> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    DynamicFieldPage.class);
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
     * Create an unsigned transaction to split a coin object into multiple coins.
     *
     * @param signer       the transaction signer's Sui address
     * @param coinObjectId the coin object to be spilt
     * @param splitAmounts the amounts to split out from the coin
     * @param gas          gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget    the gas budget, the transaction will fail if the gas cost exceed the budget
     */
    public TransactionBytes splitCoin(String signer,
                                      String coinObjectId,
                                      BigInteger[] splitAmounts,
                                      String gas,
                                      long gasBudget) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(coinObjectId);
        params.add(splitAmounts);
        params.add(gas);
        params.add(gasBudget);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_splitCoin", params,
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
     * Create an unsigned transaction to merge multiple coins into one coin.
     *
     * @param signer      the transaction signer's Sui address
     * @param primaryCoin the coin object to merge into, this coin will remain after the transaction
     * @param coinToMerge - the coin object to be merged, this coin will be destroyed, the balance will be added to `primary_coin`
     * @param gas         gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget   the gas budget, the transaction will fail if the gas cost exceed the budget
     */
    public TransactionBytes mergeCoins(String signer,
                                       String primaryCoin,
                                       String coinToMerge,
                                       String gas,
                                       long gasBudget) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(primaryCoin);
        params.add(coinToMerge);
        params.add(gas);
        params.add(gasBudget);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_mergeCoins", params,
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
     * Send SUI coins to a list of addresses, following a list of amounts.
     * This is for SUI coin only and does not require a separate gas coin object.
     *
     * @param signer     the transaction signer's Sui address
     * @param inputCoins the Sui coins to be used in this transaction, including the coin for gas payment.
     * @param recipients the recipients' addresses, the length of this vector must be the same as amounts.
     * @param amounts    the amounts to be transferred to recipients, following the same order
     * @param gasBudget  the gas budget, the transaction will fail if the gas cost exceed the budget
     */
    public TransactionBytes paySui(String signer,
                                   String[] inputCoins,
                                   String[] recipients,
                                   BigInteger[] amounts,
                                   long gasBudget) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(inputCoins);
        params.add(recipients);
        params.add(amounts);
        params.add(gasBudget);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_paySui", params,
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
     * Send all SUI coins to one recipient. This is for SUI coin only and does not require a separate gas coin object.
     *
     * @param signer     the transaction signer's Sui address
     * @param inputCoins the Sui coins to be used in this transaction, including the coin for gas payment.
     * @param recipient  the recipient address,
     * @param gasBudget  the gas budget, the transaction will fail if the gas cost exceed the budget
     */
    public TransactionBytes payAllSui(String signer,
                                      String[] inputCoins,
                                      String recipient,
                                      long gasBudget) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(inputCoins);
        params.add(recipient);
        params.add(gasBudget);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_payAllSui", params,
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
     * Send Coin&lt;T> to a list of addresses, where `T` can be any coin type, following a list of amounts.
     * The object specified in the `gas` field will be used to pay the gas fee for the transaction.
     * The gas object can not appear in `input_coins`.
     * If the gas object is not specified, the RPC server will auto-select one.
     *
     * @param signer     the transaction signer's Sui address
     * @param inputCoins the Sui coins to be used in this transaction
     * @param recipients the recipients' addresses, the length of this vector must be the same as amounts.
     * @param amounts    the amounts to be transferred to recipients, following the same order
     * @param gas        gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget  the gas budget, the transaction will fail if the gas cost exceed the budget
     */
    public TransactionBytes pay(String signer,
                                String[] inputCoins,
                                String[] recipients,
                                BigInteger[] amounts,
                                String gas,
                                long gasBudget) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(inputCoins);
        params.add(recipients);
        params.add(amounts);
        params.add(gas);
        params.add(gasBudget);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_pay", params,
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
     * @param signer    the transaction signer's Sui address
     * @param objectId  the ID of the object to be transferred
     * @param gas       gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget the gas budget, the transaction will fail if the gas cost exceed the budget
     * @param recipient the recipient's Sui address
     */
    public TransactionBytes transferObject(
            String signer,
            String objectId,
            String gas,
            long gasBudget,
            String recipient
    ) {
        List<Object> params = new ArrayList<>();
        params.add(signer);
        params.add(objectId);
        params.add(gas);
        params.add(gasBudget);
        params.add(recipient);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_transferObject", params,
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
     * Create an unsigned transaction to publish Move module.
     *
     * @param sender          the transaction signer's Sui address
     * @param compiledModules the compiled bytes of a move module, the
     * @param gas             gas object to be used in this transaction, node will pick one from the signer's possession if not provided
     * @param gasBudget       the gas budget, the transaction will fail if the gas cost exceed the budget
     */
    public TransactionBytes publish(String sender,
                                    String[] compiledModules,
                                    String gas,
                                    long gasBudget
    ) {

        List<Object> params = new ArrayList<>();
        params.add(sender);
        params.add(compiledModules);
        params.add(gas);
        params.add(gasBudget);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_publish", params,
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
     * @param signature   `flag || signature || pubkey` bytes, as base-64 encoded string, signature is committed to the intent message of the transaction data, as base-64 encoded string.
     * @param requestType The request type.
     */
    public SuiExecuteTransactionResponse executeTransactionSerializedSig(
            String txBytes,
            String signature,
            String requestType
    ) {
        List<Object> params = new ArrayList<>();
        params.add(txBytes);
        params.add(signature);
        params.add(requestType);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_executeTransactionSerializedSig", params,
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

    public SuiTransactionEffects dryRunTransaction(
            String txBytes
    ) {
        List<Object> params = new ArrayList<>();
        params.add(txBytes);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_dryRunTransaction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiTransactionEffects> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiTransactionEffects.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiMoveNormalizedFunction getNormalizedMoveFunction(
            String package_,
            String moduleName,
            String functionName
    ) {
        List<Object> params = new ArrayList<>();
        params.add(package_);
        params.add(moduleName);
        params.add(functionName);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getNormalizedMoveFunction", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiMoveNormalizedFunction> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiMoveNormalizedFunction.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MoveFunctionArgType> getMoveFunctionArgTypes(
            String package_,
            String moduleName,
            String functionName
    ) {
        List<Object> params = new ArrayList<>();
        params.add(package_);
        params.add(moduleName);
        params.add(functionName);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getMoveFunctionArgTypes", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<List<MoveFunctionArgType>> jsonrpc2Response = jsonrpc2Session.sendAndGetListResult(
                    jsonrpc2Request, MoveFunctionArgType.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiMoveNormalizedStruct getNormalizedMoveStruct(
            String package_,
            String moduleName,
            String structName) {
        List<Object> params = new ArrayList<>();
        params.add(package_);
        params.add(moduleName);
        params.add(structName);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getNormalizedMoveStruct", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiMoveNormalizedStruct> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiMoveNormalizedStruct.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public SuiMoveNormalizedModule getNormalizedMoveModule(String package_, String moduleName) {
        List<Object> params = new ArrayList<>();
        params.add(package_);
        params.add(moduleName);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getNormalizedMoveModule", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<SuiMoveNormalizedModule> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    SuiMoveNormalizedModule.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public Map<String, SuiMoveNormalizedModule> getNormalizedMoveModulesByPackage(String package_) {
        List<Object> params = new ArrayList<>();
        params.add(package_);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getNormalizedMoveModulesByPackage", params,
                System.currentTimeMillis());
        try {
            JSONRPC2Response<Map<String, SuiMoveNormalizedModule>> jsonrpc2Response = jsonrpc2Session
                    .sendAndGetMapResult(jsonrpc2Request, String.class, SuiMoveNormalizedModule.class);
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

//    public List<ValidatorMetadata> getValidators() {
//        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getValidators", Collections.emptyList(),
//                System.currentTimeMillis());
//        try {
//            JSONRPC2Response<List<ValidatorMetadata>> jsonrpc2Response = jsonrpc2Session.sendAndGetListResult(
//                    jsonrpc2Request, ValidatorMetadata.class);
//            assertSuccess(jsonrpc2Response);
//            return jsonrpc2Response.getResult();
//        } catch (JSONRPC2SessionException e) {
//            throw new RuntimeException(e);
//        }
//    }

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

    public BigInteger getLatestCheckpointSequenceNumber() {
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getLatestCheckpointSequenceNumber",
                Collections.emptyList(), System.currentTimeMillis());
        try {
            JSONRPC2Response<BigInteger> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    BigInteger.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }
    }

    public CheckpointContents getCheckpointContentsBySequenceNumber(Long sequenceNumber) {
        List<Object> params = new ArrayList<>();
        params.add(sequenceNumber);
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getCheckpointContentsBySequenceNumber",
                params, System.currentTimeMillis());
        try {
            JSONRPC2Response<CheckpointContents> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request,
                    CheckpointContents.class);
            assertSuccess(jsonrpc2Response);
            return jsonrpc2Response.getResult();
        } catch (JSONRPC2SessionException e) {
            throw new RuntimeException(e);
        }

    }

}
