package com.github.wubuku.sui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.sui.bean.*;
import com.github.wubuku.sui.utils.HexUtils;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import static com.github.wubuku.sui.utils.TransactionUtils.ed25519SignTransactionBytes;

public class SuiJsonRpcClientTests {
    ObjectMapper objectMapper = new ObjectMapper();

    //@Test
    void testGetMoveEvents_1() throws MalformedURLException, JsonProcessingException {
        String url = "http://localhost:9000";
        //String url = "https://fullnode.devnet.sui.io/";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
        PaginatedMoveEvents<JsonRpcTests.MintNFTEvent> moveEvents = client.getMoveEvents(
                "0x2::devnet_nft::MintNFTEvent",
                null, 2, true, JsonRpcTests.MintNFTEvent.class);
        System.out.println(moveEvents);
        System.out.println(objectMapper.writeValueAsString(moveEvents));
    }

    //@Test
    void testGetMoveEvents_2() throws MalformedURLException, JsonProcessingException {
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
                "Bq9pBUCvLbmhVCCT3XkBhDpVCNaVgwk3DBinpYtyVVUh"
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
        GetObjectDataResponse getObjectDataResponse = client.getObject("0x1a8e812a50899e9356044b99b1195771082e9197");
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

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
                "0x2::sui::SUI", null, 1);
        System.out.println(coinPage);
        System.out.println(objectMapper.writeValueAsString(coinPage));
    }

//    @Test
//    void testGetCoins_2() throws MalformedURLException, JsonProcessingException {
//        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        CoinPage coinPage = client.getAllCoins("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa",
//                null, 1);
//        System.out.println(coinPage);
//        System.out.println(objectMapper.writeValueAsString(coinPage));
//    }

    @Test
    void testGetCoinMetadata_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiCoinMetadata coinMetadata = client.getCoinMetadata("0x2::sui::SUI");
        System.out.println(coinMetadata);
    }

    @Test
    void testGetTotalSupply_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        Supply totalSupply = client.getTotalSupply("0x2::sui::SUI");
        System.out.println(totalSupply);
    }

    @Test
    void testGetBalance_1() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        List<Balance> balance = client.getBalance(
                "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa",
                null//"0x2::sui::SUI"
        );
        System.out.println(balance);
    }

//    @Test
//    void testGetAllBalance_1() throws MalformedURLException {
//        //SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
//        List<Balance> balance = client.getAllBalances(
//                "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa"//,//"0x2::sui::SUI"
//                );
//        System.out.println(balance);
//    }

    @Test
    void testMoveCall_1() throws MalformedURLException, JsonProcessingException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
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
        TransactionBytes result = client.moveCall(signerAddress,
                packageObjectId, module, function,
                typeArguments, arguments,
                gasPayment, gasBudget);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        String txBytes = result.getTxBytes();
        System.out.println(txBytes);
        System.out.println(HexUtils.byteArrayToHex(Base64.getDecoder().decode(txBytes)));
        Arrays.stream(result.getInputObjects())
                .filter(i -> i instanceof InputObjectKind.ImmOrOwnedMoveObject)
                .forEach(i -> {
                    InputObjectKind.ImmOrOwnedMoveObject immOrOwnedMoveObject = (InputObjectKind.ImmOrOwnedMoveObject) i;
                    System.out.println(immOrOwnedMoveObject.getImmOrOwnedMoveObject());
                    System.out.println(HexUtils.byteArrayToHex(Base64.getDecoder().decode(
                            immOrOwnedMoveObject.getImmOrOwnedMoveObject().getDigest()
                    )));
                });
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
        TransactionBytes result = client.batchTransaction(signerAddress, transactionRequestParamsList, gasPayment, gasBudget);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
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
        String txBytes = "AQECAAAAAAAAAAAAAAAAAAAAAAAAAAIBAAAAAAAAACAsl58oZElxuAIo2GjCz+IBOEMg7t5UGPjc/+T2xv7uzgpkZXZuZXRfbmZ0BG1pbnQAAwAJCFRlc3QgTkZUAAQDLi4uAB0caHR0cDovL3Rlc3QuY29tL3Rlc3QtbmZ0LnBuZzws81oNTSndnR9jQ6bq/gMTG/r6KUwSWYQEVXeVFlsMouRHab0GyVMaAAAAAAAAACArYETjuL36KUj/wGTbwxDs7waB9PP3vyc7Zfc4r5qiXgEAAAAAAAAAQEIPAAAAAAA=";
        String sigScheme = SignatureScheme.ED25519;
        //String publicKeyHex = "cd283a91930533987b1d2429db1b0453d03e5b188d00298a4bb6415f6cbf414e";
        String publicKeyBase64 = "zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=";
        String privateKeyHex = "";//todo fill in your private key here
        byte[] signature = ed25519SignTransactionBytes(HexUtils.hexToByteArray(privateKeyHex), txBytes);
        String signatureBase64 = Base64.getEncoder().encodeToString(signature);
        String requestType = ExecuteTransactionRequestType.WAIT_FOR_EFFECTS_CERT;

        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        SuiExecuteTransactionResponse response = client.executeTransaction(
                txBytes,
                sigScheme, signatureBase64,
                publicKeyBase64,
                requestType
        );
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
        String[] typeArguments = new String[]{"0x2::sui::SUI"};
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
                gasPayment, gasBudget);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
    }

    @Test
    void testBatchTransaction_2() throws MalformedURLException, JsonProcessingException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String packageObjectId = "0x2";
        String module = "locked_coin";
        String function = "lock_coin";
//        TypeTag[] typeArguments = new TypeTag[]{
//                new TypeTag.Struct(new StructTag("0x2", "sui", "SUI", null))
//        };
        String[] typeArguments = new String[]{"0x2::sui::SUI"};
        SuiJsonValue[] arguments = new SuiJsonValue[]{
                new SuiJsonValue.String_("0x2fb5815ad8170af32e1d9d7e0d6526c013fc9737"),
                new SuiJsonValue.String_("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa"),
                new SuiJsonValue.Number(10000000000000L)
        };
        String gasPayment = "0x294c12598404557795165b0ca2e44769bd06c953";
        long gasBudget = 1000000;

        RPCTransactionRequestParams transactionRequestParams = new RPCTransactionRequestParams.MoveCallRequestParams(
                new MoveCallParams(packageObjectId, module, function, typeArguments, arguments)
        );
        RPCTransactionRequestParams[] transactionRequestParamsList = new RPCTransactionRequestParams[]{
                transactionRequestParams
        };
        TransactionBytes result = client.batchTransaction(signerAddress, transactionRequestParamsList, gasPayment, gasBudget);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
    }
}
