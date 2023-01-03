package com.github.wubuku.sui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.sui.bean.*;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.util.List;

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
        SuiTransactionResponse suiTransactionResponse = client.getTransaction("FJTkcJRV3sxn5GuG4PVJuT5U2qP2ZnfDgcFWdASiBgjU");
        System.out.println(suiTransactionResponse);
        System.out.println(objectMapper.writeValueAsString(suiTransactionResponse));
    }

    @Test
    void testGetObjectsOwnedByAddress_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        List<SuiObjectInfo> suiObjectInfoList = client.getObjectsOwnedByAddress("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa");
        System.out.println(suiObjectInfoList);
        System.out.println(objectMapper.writeValueAsString(suiObjectInfoList));
    }

    @Test
    void testGetObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        GetObjectDataResponse getObjectDataResponse = client.getObject("0x0b7a32cfbfbe22b55f3ad703b1b6af130266086e");
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
    }
}
