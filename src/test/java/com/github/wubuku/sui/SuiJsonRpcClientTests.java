package com.github.wubuku.sui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.sui.bean.*;
import com.github.wubuku.sui.utils.HexUtils;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import com.github.wubuku.sui.utils.TransactionUtils;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class SuiJsonRpcClientTests {

    static final String SUI_COIN_TYPE = "0x2::sui::SUI";

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void testGetMoveEvents_1() throws MalformedURLException, JsonProcessingException {
        //String url = "http://localhost:9000";
        String url = "https://fullnode.devnet.sui.io/";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
        PaginatedMoveEvents<JsonRpcTests.MintNFTEvent> moveEvents = client.getMoveEvents(
                "0x2::devnet_nft::MintNFTEvent",
                null, 2, true, JsonRpcTests.MintNFTEvent.class);
        System.out.println(moveEvents);
        System.out.println(objectMapper.writeValueAsString(moveEvents));
    }


    //@Test
    void testGetEvents_2() throws MalformedURLException, JsonProcessingException {
        //String url = "https://fullnode.devnet.sui.io/";
        String url = "http://localhost:9000";
        String transactionDigest = "3LBcVgGGXvKzRoQeNGvZZv64d5fWLrYmW78h2pU4Fw7n";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
        PaginatedEvents events = client.getEvents(
                new EventQuery.Transaction(transactionDigest),
                null, 10, false);
        System.out.println(events);
        System.out.println(objectMapper.writeValueAsString(events));
    }

    @Test
    void testGetEvents_1() throws MalformedURLException, JsonProcessingException {
        String url = "https://fullnode.devnet.sui.io/";
        String packageId = "0x7b07e7ba1f0902d589202277c65c59fc55f25085";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
//        PaginatedEvents events_c = client.getEvents(
//                new EventQuery.EventType(EventType.CHECKPOINT),
//                null, 1, false);
//        System.out.println(events_c);
        if (true) return;
        // -----------------------
        PaginatedEvents events = client.getEvents(
                new EventQuery.MoveEvent(packageId + "::product::ProductCreated"),
                null, 10, false);
        System.out.println(events);
        System.out.println(objectMapper.writeValueAsString(events));
        // -----------------------
        PaginatedMoveEvents<ProductCreated> paginatedMoveEvents = client.getMoveEvents(
                packageId + "::product::ProductCreated",
                null, 10, false, ProductCreated.class);
        System.out.println(paginatedMoveEvents);
        System.out.println(objectMapper.writeValueAsString(paginatedMoveEvents));
    }

    @Test
    void testGetTransactions_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        TransactionQuery.MoveFunction moveFunction = new TransactionQuery.MoveFunction(
                "0x0000000000000000000000000000000000000002",
                "devnet_nft",
                "mint");
        //TransactionQuery transactionQuery = TransactionQuery.All.INSTANCE;
        TransactionsPage transactionsPage = client.getTransactions(//transactionQuery,
                moveFunction,
                null, 1, true);
        System.out.println(transactionsPage);
        System.out.println(objectMapper.writeValueAsString(transactionsPage));
    }

    @Test
    void testGetTransactionsInRange_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        List<String> transactions = client.getTransactionsInRange(0, 100);
        System.out.println(transactions);
    }

    @Test
    void testGetTransaction_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiTransactionResponse suiTransactionResponse = client.getTransaction(
                "6dGPGAvezUjEPjNitEaFwzzJwJQxcyJhfrZd8NpXbR4A"
        );
        System.out.println(suiTransactionResponse);
        System.out.println(objectMapper.writeValueAsString(suiTransactionResponse));
    }

    @Test
    void testGetObjectsOwnedByAddress_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        List<SuiObjectInfo> suiObjectInfoList = client.getObjectsOwnedByAddress("0xc890473abafb24a19e2f77e1d407fc1c468a71b4");
        System.out.println(suiObjectInfoList);
        System.out.println(objectMapper.writeValueAsString(suiObjectInfoList));
    }

    @Test
    void testGetObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetObjectDataResponse getObjectDataResponse = client.getObject(
                "0x1a8e812a50899e9356044b99b1195771082e9197"
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetObject_2() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetObjectDataResponse getObjectDataResponse = client.getObject(
                "0x595e185525f2a9bb892dc634ba95a10f78010c1e"
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetMoveEvents_3() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageId = "0x7b07e7ba1f0902d589202277c65c59fc55f25085";
        PaginatedMoveEvents<OnlyIdFields> events_1 = client.getMoveEvents(
                packageId + "::domain_name::DomainNameIdTableCreated",
                null, 10, false, OnlyIdFields.class);
        System.out.println(events_1);
        if (events_1.getData() != null && !events_1.getData().isEmpty()) {
            System.out.println(events_1.getData().get(0).getEvent().getMoveEvent().getFields().getId());
        }
        PaginatedMoveEvents<OnlyIdFields> events_2 = client.getMoveEvents(
                packageId + "::product::ProductIdGeneratorCreated",
                null, 10, false, OnlyIdFields.class);
        System.out.println(events_2);
        if (events_1.getData() != null && !events_1.getData().isEmpty()) {
            System.out.println(events_2.getData().get(0).getEvent().getMoveEvent().getFields().getId());
        }
    }

    @Test
    void testGetMoveObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetMoveObjectDataResponse<TestOrder> getObjectDataResponse = client.getMoveObject(
                "0x595e185525f2a9bb892dc634ba95a10f78010c1e",
                TestOrder.class
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetObjectsOwnedByObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        List<SuiObjectInfo> objectsOwnedByObject = client.getObjectsOwnedByObject(
                "0xc8bfe731b7ef35fdab2c3ef99f09194e40627a10"
        );
        System.out.println(objectsOwnedByObject);
        System.out.println(objectMapper.writeValueAsString(objectsOwnedByObject));
    }

    @Test
    void testGetDynamicFields_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        DynamicFieldPage dynamicFieldPage = client.getDynamicFields(
                "0xc8bfe731b7ef35fdab2c3ef99f09194e40627a10",
                null, null
        );
        System.out.println(dynamicFieldPage);
        System.out.println(objectMapper.writeValueAsString(dynamicFieldPage));
        dynamicFieldPage.getData().forEach(dynamicField -> {
            System.out.println(dynamicField.getType());
            System.out.println(dynamicField.getName());
            System.out.println(dynamicField.getObjectId());
        });
    }

    @Test
    void testGetMoveObject_2() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetMoveObjectDataResponse<TestOrder.OrderItemField> getObjectDataResponse = client.getMoveObject(
                "0x90c40b57ba0f4cdf060f6b387229e0de232c407a",
                TestOrder.OrderItemField.class
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetDynamicFieldObject() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String parentObjectId = "0xc8bfe731b7ef35fdab2c3ef99f09194e40627a10";
        String name = "0x1::string::String {bytes: vector[48u8, 49u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8]}";
        // ------------------
        GetObjectDataResponse getObjectDataResponse = client.getDynamicFieldObject(parentObjectId, name);
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
        // ------------------
        GetMoveObjectDataResponse<TestOrder.OrderItemField> getMoveObjectDataResponse = client
                .getDynamicFieldMoveObject(parentObjectId, name, TestOrder.OrderItemField.class);
        System.out.println(getMoveObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getMoveObjectDataResponse));
    }

    @Test
    void testGetRawObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetRawObjectDataResponse getObjectDataResponse = client.getRawObject(
                "0x1a8e812a50899e9356044b99b1195771082e9197"
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }


//    @Test
//    void testGetDynamicFieldObject_1() throws MalformedURLException, JsonProcessingException {
//        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        GetObjectDataResponse getObjectDataResponse = client.getDynamicFieldObject(
//                "0xc8bfe731b7ef35fdab2c3ef99f09194e40627a10",
//                "01000000000000000000000000000000"
//        );
//        System.out.println(getObjectDataResponse);
//        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
//    }

    @Test
    void tryGetPastObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetPastObjectDataResponse getObjectDataResponse = client.tryGetPastObject(
                "0x1a8e812a50899e9356044b99b1195771082e9197",
                392L);
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetCoins_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        CoinPage coinPage = client.getCoins("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa",
                SUI_COIN_TYPE, null, 1);
        System.out.println(coinPage);
        System.out.println(objectMapper.writeValueAsString(coinPage));
    }

    @Test
    void testGetAllCoins_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        CoinPage coinPage = client.getAllCoins("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa",
                null, 1);
        System.out.println(coinPage);
        System.out.println(objectMapper.writeValueAsString(coinPage));
    }

    @Test
    void testGetCoinMetadata_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiCoinMetadata coinMetadata = client.getCoinMetadata(SUI_COIN_TYPE);
        System.out.println(coinMetadata);
    }

    @Test
    void testGetTotalSupply_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        Supply totalSupply = client.getTotalSupply(SUI_COIN_TYPE);
        System.out.println(totalSupply);
    }

    @Test
    void testGetBalance_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        CoinBalance balance = client.getBalance(
                "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa",
                null//SUI_COIN_TYPE
        );
        System.out.println(balance);
    }

    @Test
    void testGetAllBalance_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        List<CoinBalance> balanceList = client.getAllBalances(
                "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa"
        );
        System.out.println(balanceList);
    }

    @Test
    void testExecuteMoveCall_1() throws MalformedURLException, JsonProcessingException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        TransactionBytes encodeResult = encodeATestMoveCallTransaction(client, signerAddress);
        System.out.println(encodeResult);
        //System.out.println(objectMapper.writeValueAsString(result));
        String txBytes = encodeResult.getTxBytes();
        String publicKeyBase64 = "zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=";
        String sigScheme = SignatureScheme.ED25519;
        String privateKeyHex = "";//todo fill in the private key here
        SuiExecuteTransactionResponse response = executeTransaction(client, txBytes,
                publicKeyBase64, sigScheme, HexUtils.hexToByteArray(privateKeyHex));
        System.out.println(response);
//        System.out.println(txBytes);
//        System.out.println(HexUtils.byteArrayToHex(Base64.getDecoder().decode(txBytes)));
//        Arrays.stream(result.getInputObjects())
//                .filter(i -> i instanceof InputObjectKind.ImmOrOwnedMoveObject)
//                .forEach(i -> {
//                    InputObjectKind.ImmOrOwnedMoveObject immOrOwnedMoveObject = (InputObjectKind.ImmOrOwnedMoveObject) i;
//                    System.out.println(immOrOwnedMoveObject.getImmOrOwnedMoveObject());
//                    System.out.println(HexUtils.byteArrayToHex(Base64.getDecoder().decode(
//                            immOrOwnedMoveObject.getImmOrOwnedMoveObject().getDigest()
//                    )));
//                });
    }

    private SuiExecuteTransactionResponse executeTransaction(SuiJsonRpcClient client,
                                                             String txBytes,
                                                             String publicKeyBase64, String sigScheme,
                                                             byte[] privateKey) {
        byte[] signature = TransactionUtils.ed25519SignTransactionBytes(privateKey, txBytes);
        String signatureBase64 = Base64.getEncoder().encodeToString(signature);
        String requestType = ExecuteTransactionRequestType.WAIT_FOR_EFFECTS_CERT;

        SuiExecuteTransactionResponse response = client.executeTransaction(
                txBytes,
                sigScheme, signatureBase64,
                publicKeyBase64,
                requestType
        );
        return response;
    }

    private TransactionBytes encodeATestMoveCallTransaction(SuiJsonRpcClient client, String signerAddress) {
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        String function = "mint";
        String[] typeArguments = new String[0];
        SuiJsonValue[] arguments = new SuiJsonValue[]{
                new SuiJsonValue.String_("Test NFT"),
                new SuiJsonValue.String_("..."),
                new SuiJsonValue.String_("http://test.org/test-nft.png")
        };
        long gasBudget = 1000000;
        String gasPayment = selectGasPayment(client, signerAddress, gasBudget);
        TransactionBytes result = client.moveCall(signerAddress,
                packageObjectId, module, function,
                typeArguments, arguments,
                gasPayment, gasBudget, null);
        return result;
    }

    /**
     * Select a gas payment object.
     *
     * @return the gas payment object id
     */
    private String selectGasPayment(SuiJsonRpcClient client, String owner, long gasBudget) {
        CoinPage coinPage = client.getCoins(owner, SUI_COIN_TYPE, null, 100);
        for (Coin c : coinPage.getData()) {
            if (c.getBalance().compareTo(BigInteger.valueOf(gasBudget)) >= 0) {
                return c.getCoinObjectId();
            }
        }
        throw new RuntimeException("No enough gas payment");
    }

    private String selectSuiCoinObjectBut(SuiJsonRpcClient client, String owner, String[] excludedCoinObjects) {
        CoinPage coinPage = client.getCoins(owner, SUI_COIN_TYPE, null, 100);
        for (Coin c : coinPage.getData()) {
            if (Arrays.stream(excludedCoinObjects).noneMatch(c.getCoinObjectId()::equals)) {
                return c.getCoinObjectId();
            }
        }
        throw new RuntimeException("No enough gas payment");
    }

    @Test
    void testBatchTransaction_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        String function = "mint";
        String[] typeArguments = new String[0]; // TypeTag[] typeArguments
        SuiJsonValue[] arguments = new SuiJsonValue[]{
                new SuiJsonValue.String_("Test NFT"),
                new SuiJsonValue.String_("..."),
                new SuiJsonValue.String_("http://test.com/test-nft.png")
        };
        String gasPayment = "0x294c12598404557795165b0ca2e44769bd06c953";
        long gasBudget = 1000000;
        RPCTransactionRequestParams transactionRequestParams = new RPCTransactionRequestParams.MoveCallRequestParams(
                new MoveCallParams(packageObjectId, module, function, typeArguments, arguments)
        );
        RPCTransactionRequestParams[] transactionRequestParamsList = new RPCTransactionRequestParams[]{
                transactionRequestParams
        };
        TransactionBytes result = client.batchTransaction(signerAddress,
                transactionRequestParamsList,
                gasPayment, gasBudget, SuiTransactionBuilderMode.COMMIT);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
    }

    @Test
    void testSplitCoin_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String gasObjectId = selectGasPayment(client, signerAddress, 100000);
        String coinObjectId = selectSuiCoinObjectBut(client, signerAddress, new String[]{gasObjectId});
        BigInteger[] amounts = new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)};
        TransactionBytes transactionBytes = client.splitCoin(signerAddress, coinObjectId, amounts, gasObjectId, 100000L);
        TransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
        System.out.println(transactionEffects);
    }

    @Test
    void testMergeCoins_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String gasObjectId = selectGasPayment(client, signerAddress, 100000);
        String coinObjectId_1 = selectSuiCoinObjectBut(client, signerAddress, new String[]{gasObjectId});
        String coinObjectId_2 = selectSuiCoinObjectBut(client, signerAddress, new String[]{gasObjectId, coinObjectId_1});
        TransactionBytes transactionBytes = client.mergeCoins(signerAddress, coinObjectId_1, coinObjectId_2, gasObjectId, 100000L);
        TransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
        System.out.println(transactionEffects);
    }

    @Test
    void testPayAllSui_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String signer = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String coinObjectId_1 = selectSuiCoinObjectBut(client, signer, new String[]{});
        String coinObjectId_2 = selectSuiCoinObjectBut(client, signer, new String[]{coinObjectId_1});

        String[] inputCoins = new String[]{coinObjectId_1, coinObjectId_2};
        String recipient = signer;
        long gasBudget = 100000;
        TransactionBytes transactionBytes = client.payAllSui(signer, inputCoins, recipient, gasBudget);
        TransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
        System.out.println(transactionEffects);
    }

    @Test
    void testPaySui_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String signer = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String gasObjectId = selectGasPayment(client, signer, 100000);
        String coinObjectId_1 = selectSuiCoinObjectBut(client, signer, new String[]{gasObjectId});
        String coinObjectId_2 = selectSuiCoinObjectBut(client, signer, new String[]{gasObjectId, coinObjectId_1});
        String[] inputCoins = new String[]{coinObjectId_1, coinObjectId_2};
        String recipient_1 = signer;
        String recipient_2 = signer;
        String[] recipients = new String[]{recipient_1, recipient_2};
        BigInteger[] amounts = new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)};
        long gasBudget = 100000;
        TransactionBytes transactionBytes = client.pay(signer, inputCoins, recipients, amounts, gasObjectId, gasBudget);
        TransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
        System.out.println(transactionEffects);
    }

    @Test
    void testPay_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String signer = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String coinObjectId_1 = selectSuiCoinObjectBut(client, signer, new String[]{});
        String coinObjectId_2 = selectSuiCoinObjectBut(client, signer, new String[]{coinObjectId_1});
        String[] inputCoins = new String[]{coinObjectId_1, coinObjectId_2};
        String recipient_1 = signer;
        String recipient_2 = signer;
        String[] recipients = new String[]{recipient_1, recipient_2};
        BigInteger[] amounts = new BigInteger[]{BigInteger.valueOf(1), BigInteger.valueOf(2)};
        long gasBudget = 100000;
        TransactionBytes transactionBytes = client.paySui(signer, inputCoins, recipients, amounts, gasBudget);
        TransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
        System.out.println(transactionEffects);
    }

    @Test
    void testDryRunTransaction_1() throws MalformedURLException, JsonProcessingException {
        String txBytes = "AQECAAAAAAAAAAAAAAAAAAAAAAAAAAIBAAAAAAAAACAsl58oZElxuAIo2GjCz+IBOEMg7t5UGPjc/+T2xv7uzgtsb2NrZWRfY29pbglsb2NrX2NvaW4BBwAAAAAAAAAAAAAAAAAAAAAAAAACA3N1aQNTVUkAAwEAL7WBWtgXCvMuHZ1+DWUmwBP8lzcBAAAAAAAAACArk/jbO5ZDr9GpkvlJdaXr9DtEILIXCX3FXCiiley2AgAUPCzzWg1NKd2dH2NDpur+AxMb+voACACgck4YCQAAPCzzWg1NKd2dH2NDpur+AxMb+vopTBJZhARVd5UWWwyi5EdpvQbJUwgAAAAAAAAAIHPmBAVvqy2ZINnuDjPcjyuCCbNWixbmw35oU/EqF03uAQAAAAAAAABAQg8AAAAAAA==";
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        TransactionEffects transactionEffects = client.dryRunTransaction(txBytes);
        System.out.println(transactionEffects);
        System.out.println(objectMapper.writeValueAsString(transactionEffects));
    }

    //@Test
    void testExecuteTransaction_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String txBytes = "AQECAAAAAAAAAAAAAAAAAAAAAAAAAAIBAAAAAAAAACAsl58oZElxuAIo2GjCz+IBOEMg7t5UGPjc/+T2xv7uzgpkZXZuZXRfbmZ0BG1pbnQAAwAJCFRlc3QgTkZUAAQDLi4uAB0caHR0cDovL3Rlc3QuY29tL3Rlc3QtbmZ0LnBuZzws81oNTSndnR9jQ6bq/gMTG/r6KUwSWYQEVXeVFlsMouRHab0GyVMaAAAAAAAAACArYETjuL36KUj/wGTbwxDs7waB9PP3vyc7Zfc4r5qiXgEAAAAAAAAAQEIPAAAAAAA=";
        //String publicKeyHex = "cd283a91930533987b1d2429db1b0453d03e5b188d00298a4bb6415f6cbf414e";
        String publicKeyBase64 = "zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=";
        String sigScheme = SignatureScheme.ED25519;
        String privateKeyHex = "";//todo fill in your private key here
        SuiExecuteTransactionResponse response = executeTransaction(client,
                txBytes, publicKeyBase64, sigScheme, HexUtils.hexToByteArray(privateKeyHex));
        System.out.println(response);
        System.out.println(objectMapper.writeValueAsString(response));
    }

    @Test
    void testMoveCall_2() throws MalformedURLException, JsonProcessingException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String packageObjectId = "0x2";
        String module = "locked_coin";
        String function = "lock_coin";
//        TypeTag[] typeArguments = new TypeTag[]{
//                new TypeTag.Struct(new StructTag("0x2", "sui", "SUI", null))
//        };
        String[] typeArguments = new String[]{SUI_COIN_TYPE};
        SuiJsonValue[] arguments = new SuiJsonValue[]{
                new SuiJsonValue.String_("0x2fb5815ad8170af32e1d9d7e0d6526c013fc9737"),
                new SuiJsonValue.String_("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa"),
                new SuiJsonValue.Number(10000000000000L)
        };
        String gasPayment = "0x294c12598404557795165b0ca2e44769bd06c953";
        long gasBudget = 1000000;
        TransactionBytes result = client.moveCall(signerAddress,
                packageObjectId, module, function,
                typeArguments, arguments,
                gasPayment, gasBudget, SuiTransactionBuilderMode.DEV_INSPECT);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
    }

    @Test
    void testTransferSui_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String suiObjectId = "0x4ce8778751c9efc6ced31d5005afabaab870c1de";
        long gasBudget = 1000000;
        String recipient = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        long amount = 1L;
        TransactionBytes result = client.transferSui(signerAddress, suiObjectId, gasBudget, recipient, amount);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
    }

    @Test
    void testBatchTransaction_2() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String packageObjectId = "0x2";
        String module = "locked_coin";
        String function = "lock_coin";
//        TypeTag[] typeArguments = new TypeTag[]{
//                new TypeTag.Struct(new StructTag("0x2", "sui", "SUI", null))
//        };
        String[] typeArguments = new String[]{SUI_COIN_TYPE};
        SuiJsonValue[] arguments = new SuiJsonValue[]{
                new SuiJsonValue.String_("0x72c6a7df69b25c0eb89eb50bc5abec93ea80e17a"),
                new SuiJsonValue.String_("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa"),
                new SuiJsonValue.U64(10000L)
        };
        String gasPayment = "0x4ce8778751c9efc6ced31d5005afabaab870c1de";
        long gasBudget = 1000000;

        RPCTransactionRequestParams transactionRequestParams = new RPCTransactionRequestParams.MoveCallRequestParams(
                new MoveCallParams(packageObjectId, module, function, typeArguments, arguments)
        );
        RPCTransactionRequestParams[] transactionRequestParamsList = new RPCTransactionRequestParams[]{
                transactionRequestParams
        };
        TransactionBytes result = client.batchTransaction(signerAddress,
                transactionRequestParamsList, gasPayment, gasBudget, SuiTransactionBuilderMode.DEV_INSPECT);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
    }

    @Test
    void testGetNormalizedMoveFunction_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        String module = "locked_coin";
        String function = "lock_coin";
        SuiMoveNormalizedFunction result = client.getNormalizedMoveFunction(packageObjectId, module, function);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetNormalizedMoveFunction_2() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        String function = "mint";
        SuiMoveNormalizedFunction result = client.getNormalizedMoveFunction(packageObjectId, module, function);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetMoveFunctionArgTypes_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        String function = "mint";
        List<MoveFunctionArgType> result = client.getMoveFunctionArgTypes(packageObjectId, module, function);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetMoveFunctionArgTypes_2() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        String module = "locked_coin";
        String function = "lock_coin";
        List<MoveFunctionArgType> result = client.getMoveFunctionArgTypes(packageObjectId, module, function);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetNormalizedMoveStruct_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        String struct = "DevNetNFT";
        SuiMoveNormalizedStruct result = client.getNormalizedMoveStruct(packageObjectId, module, struct);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetNormalizedMoveModule_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        String module = "devnet_nft";
        SuiMoveNormalizedModule result = client.getNormalizedMoveModule(packageObjectId, module);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetNormalizedMoveModulesByPackage_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageObjectId = "0x2";
        Map<String, SuiMoveNormalizedModule> result = client.getNormalizedMoveModulesByPackage(packageObjectId);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testDevInspectTransaction_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String txBytes = "AQECAAAAAAAAAAAAAAAAAAAAAAAAAAIBAAAAAAAAACD9Ib41F5sMx2kwW9SdHSvDoPgb8bJxcqqEXGym2e0Q6Qtsb2NrZWRfY29pbglsb2NrX2NvaW4BBwAAAAAAAAAAAAAAAAAAAAAAAAACA3N1aQNTVUkAAwEAcsan32myXA64nrULxavsk+qA4XrGAgAAAAAAACDFQZG8302FqmO5RiUtt3azjuqIZGnPGp+XHPS0z72g0AAUPCzzWg1NKd2dH2NDpur+AxMb+voACBAnAAAAAAAAPCzzWg1NKd2dH2NDpur+AxMb+vpM6HeHUcnvxs7THVAFr6uquHDB3sUCAAAAAAAAIJlYQmDTupgm+CNfVr2uEdLNj32ayN/qm57eh3wptDq1AQAAAAAAAABAQg8AAAAAAA==";
        DevInspectResults result = client.devInspectTransaction(txBytes);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetTotalTransactionNumber_1() throws MalformedURLException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        long result = client.getTotalTransactionNumber();
        System.out.println(result);
    }

    @Test
    void testGetCommitteeInfo_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        CommitteeInfoResponse result = client.getCommitteeInfo(0L);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testGetSuiSystemState_1() throws JsonProcessingException, MalformedURLException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiSystemState result = client.getSuiSystemState();
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    //@Test
    void testGetLatestCheckpointSequenceNumber_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        BigInteger result = client.getLatestCheckpointSequenceNumber();
        System.out.println(result);
    }

    @Test
    void testGetCheckpointContentsBySequenceNumber_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        CheckpointContents result = client.getCheckpointContentsBySequenceNumber(1L);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    public static class ProductCreated {
        public String id;//: object::ID,
        public String product_id;//: String,
        public String name;//: String,
        public BigInteger unit_price;//: u128,

        @Override
        public String toString() {
            return "ProductCreated{" +
                    "id='" + id + '\'' +
                    ", product_id='" + product_id + '\'' +
                    ", name='" + name + '\'' +
                    ", unit_price=" + unit_price +
                    '}';
        }
    }


//    @Test
//    void testGetValidators() throws MalformedURLException, JsonProcessingException {
//        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        List<ValidatorMetadata> result = client.getValidators();
//        System.out.println(result);
//        System.out.println(objectMapper.writeValueAsString(result));
//    }

    public static class TestOrder {
        public UID id;
        public Long total_amount;
        public Long version;
        public Table items; //OrderItem table

        @Override
        public String toString() {
            return "TestOrder{" +
                    "id=" + id +
                    ", total_amount=" + total_amount +
                    ", version=" + version +
                    ", items=" + items +
                    '}';
        }

        public static class OrderItemField extends DynamicField<String, TestOrder.OrderItem> {

        }

        public static class OrderItem {
            public String product_id;
            public Long quantity;
            public Long item_amount;

            @Override
            public String toString() {
                return "OrderItem{" +
                        "product_id='" + product_id + '\'' +
                        ", quantity=" + quantity +
                        ", item_amount=" + item_amount +
                        '}';
            }
        }
    }
}
