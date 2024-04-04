package com.github.wubuku.sui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.sui.bean.*;
import com.github.wubuku.sui.tests.*;
import com.github.wubuku.sui.utils.HexUtils;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import com.github.wubuku.sui.utils.TransactionUtils;
import com.google.common.primitives.Bytes;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class SuiJsonRpcClientTests {

    static final String SUI_COIN_TYPE = "0x2::sui::SUI";
    static final long DEFAULT_MAX_GAS_BUDGE = 1000000;

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void testGetMoveEvents_1() throws MalformedURLException, JsonProcessingException {
        //String url = "http://localhost:9000";
        String url = "https://fullnode.devnet.sui.io/";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
        PaginatedMoveEvents<JsonRpcTests.MintNFTEvent> moveEvents = client.queryMoveEvents(
                "0x2::devnet_nft::MintNFTEvent",
                null, 2, true, JsonRpcTests.MintNFTEvent.class);
        System.out.println(moveEvents);
        System.out.println(objectMapper.writeValueAsString(moveEvents));
    }

    @Test
    void testGetOwnedObjects_1() throws MalformedURLException, JsonProcessingException {
        String url = "https://fullnode.testnet.sui.io/";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
        //SuiObjectDataFilter filter = new SuiObjectDataFilter.StructType("0x4d6c3dd86aac1db8f2337fe78fb087ef5ea6812715edec09e4d9fa363872c261::liquidity_token::LiquidityToken");
        SuiObjectDataFilter filter = new SuiObjectDataFilter.StructType("0x507d2aacb7425085612e0d56131a57362729779bf3510c286b98568479314920::equipment::Equipment");
        SuiObjectResponseQuery query = new SuiObjectResponseQuery(filter, null);

        ObjectsPage ownedObjects = client.getOwnedObjects("0xfc50aa2363f3b3c5d80631cae512ec51a8ba94080500a981f4ae1a2ce4d201c2",
                query, null, 50);
        System.out.println(ownedObjects);
        System.out.println(objectMapper.writeValueAsString(ownedObjects));
    }

    @Test
    void testGetEventsByTransactionDigest_2() throws MalformedURLException, JsonProcessingException {
        String url = "https://fullnode.devnet.sui.io/";
        //String url = "http://localhost:9000";
        String transactionDigest = "85jYzsibHpaxRLwtWyGKxioFHBDFeLuELokpZYkhwwXn";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
        PaginatedEvents events = client.queryEvents(
                new SuiEventFilter.Transaction(transactionDigest),
                null, 10, false);
        System.out.println(events);
        System.out.println(objectMapper.writeValueAsString(events));
    }

    @Test
    void testGetEvents_1() throws MalformedURLException, JsonProcessingException {
        //String url = "https://fullnode.devnet.sui.io/";
        String url = "https://fullnode.testnet.sui.io/";
        String packageId = "0xa711c670d901adc74a345c3a032a2b513d73be5149e9645cdc5b68cfeed030a9";
        SuiJsonRpcClient client = new SuiJsonRpcClient(url);
//        PaginatedEvents events_c = client.getEvents(
//                new EventQuery.EventType(EventType.CHECKPOINT),
//                null, 1, false);
//        System.out.println(events_c);
        //if (true) return;
        // -----------------------
        EventId cursor = new EventId();
        cursor.setTxDigest("GAhYg7M4GCGWnead5tR2gMQVYHijkxHebvn7LPwgMUJm");
        cursor.setEventSeq("0");
        PaginatedEvents events = client.queryEvents(
                new SuiEventFilter.MoveEventType(packageId + "::product::ProductCreated"),
                cursor, 10, false);
        System.out.println(events);
        System.out.println(objectMapper.writeValueAsString(events));
        // -----------------------
        PaginatedMoveEvents<ProductCreated> paginatedMoveEvents = client.queryMoveEvents(
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
    void getTransactionBlock_1() throws MalformedURLException, JsonProcessingException {
        //SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.testnet.sui.io/");
        SuiTransactionBlockResponse suiTransactionBlockResponse = client.getTransactionBlock(
                //"5nvqAWujwq72FVbUtZp4mEFauRXsssQNGH2ny1KcAebp", // a failed trx
                "4mxSZCAkYwxhGQY79GDHQWFYoa8x3HQiQx4Azn9JbG8b",
                new SuiTransactionBlockResponseOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                )
        );
        //System.out.println(suiTransactionResponse);
        System.out.println(objectMapper.writeValueAsString(suiTransactionBlockResponse));
        AtomicReference<String> packageIdRef = new AtomicReference<>();
        SuiTransactionBlockEffects.SuiTransactionBlockEffectsV1 effects = (SuiTransactionBlockEffects.SuiTransactionBlockEffectsV1) suiTransactionBlockResponse.getEffects();
        SuiTransactionBlockEvents events = suiTransactionBlockResponse.getEvents();
        ObjectChange[] objectChanges = suiTransactionBlockResponse.getObjectChanges();
        Arrays.stream(objectChanges).filter(
                event -> event instanceof ObjectChange.Published
        ).findFirst().ifPresent(event -> {
            ObjectChange.Published publish = (ObjectChange.Published) event;
            System.out.println(publish);
            packageIdRef.set(publish.getPackageId());
        });

        System.out.println("--------");
        System.out.println("package Id: " + packageIdRef.get());
        String packageId = packageIdRef.get();

        String[] idGeneratorDataObjTypes = ContractConstants.getIdGeneratorDataObjectTypes(packageId);
        //System.out.println(idGeneratorDataObjTypes.length);
        Arrays.stream(objectChanges).filter(
                event -> event instanceof ObjectChange.Created
        ).forEach(event -> {
            ObjectChange.Created newObject = (ObjectChange.Created) event;
            //System.out.println(newObject);
            int i = newObject.getObjectType().indexOf("::");
            if (newObject.getObjectType().substring(0, i).equals(packageId)) {
//                System.out.println(newObject.getNewObject().getObjectType());
//                System.out.println(newObject.getNewObject().getObjectId());
                if (Arrays.stream(idGeneratorDataObjTypes).anyMatch(t -> t.equals(newObject.getObjectType()))) {
                    System.out.println("--------");
                    System.out.print("new object Id: " + newObject.getObjectId());
                    System.out.println(", type: " + newObject.getObjectType());
                }
            }
        });

    }

//    @Test
//    void testGetObjectsOwnedByAddress_1() throws MalformedURLException, JsonProcessingException {
//        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        List<SuiObjectInfo> suiObjectInfoList = client.getOwnedObjects("0xc890473abafb24a19e2f77e1d407fc1c468a71b4");
//        System.out.println(suiObjectInfoList);
//        System.out.println(objectMapper.writeValueAsString(suiObjectInfoList));
//    }

    @Test
    void testGetObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiObjectResponse getObjectDataResponse = client.getObject(
                "0x1a8e812a50899e9356044b99b1195771082e9197",
                new SuiObjectDataOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                )
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetObject_D() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.testnet.sui.io/");
        SuiObjectResponse getObjectDataResponse = client.getObject(
                "0x535b4b20596d9454fabeded9a0c438c456f8fb8c862d530fcb2ca4731f9f90b5",
                new SuiObjectDataOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                )
                //null
        );
        System.out.println(getObjectDataResponse.getData().getContent().getClass());
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetMoveEvents_3() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageId = "0xb927a6dd8e00e2189c84234d1609f5a9f0e1853c6854b59f271afd2248fc5f68";
        PaginatedMoveEvents<OnlyIdFields> events_1 = client.queryMoveEvents(
                packageId + "::domain_name::DomainNameIdTableCreated",
                null, 10, false, OnlyIdFields.class);
        System.out.println(events_1);

        PaginatedMoveEvents<OnlyIdFields> events_2 = client.queryMoveEvents(
                packageId + "::product::ProductIdGeneratorCreated",
                null, 10, false, OnlyIdFields.class);
        System.out.println(events_2);
    }

    @Test
    void testGetMoveEvents_D() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String packageId = "0xb927a6dd8e00e2189c84234d1609f5a9f0e1853c6854b59f271afd2248fc5f68";
        EventId cursor = null;
        int counter = 0;
        while (true) {
            int limit = 1;
            PaginatedMoveEvents<DaySummaryCreated> events_1 = client.queryMoveEvents(
                    packageId + "::day_summary::DaySummaryCreated",
                    cursor, limit, false, DaySummaryCreated.class);
            System.out.println(events_1);

            counter++;
            System.out.println("counter: " + counter);
            cursor = events_1.getNextCursor();
            if (!Page.hasNextPage(events_1)) {
                break;
            }
        }
    }

    @Test
    void testGetMoveObject_getDynamicFields_getDynamicFieldMoveObject_D() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiMoveObjectResponse<Order> getObjectDataResponse = client.getMoveObject(
                "0x50dc4c763b4f3df257a4557345bced2097bd0e32ad4200493527bcfdd1192546",
                new SuiObjectDataOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                ),
                Order.class
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
        Order order = getObjectDataResponse.getData().getContent().getFields();
        String testOrderItemTableId = order.getItems().getFields().getId().getId();
        System.out.println(testOrderItemTableId);

        String cursor = null;
        while (true) {
            DynamicFieldPage<?> orderItemPage = client.getDynamicFields(testOrderItemTableId, cursor, null, Object.class);
            for (DynamicFieldInfo<?> testOrderItemFieldInfo : orderItemPage.getData()) {
                System.out.println(testOrderItemFieldInfo);
                DynamicFieldName fieldName = testOrderItemFieldInfo.getName();
                System.out.println("field name: " + fieldName);
                String fieldObjectId = testOrderItemFieldInfo.getObjectId();
                System.out.println("field object Id: " + fieldObjectId);
                System.out.println("== get dynamic field object by parent_id and field_name ==");
                SuiMoveObjectResponse<OrderItemDynamicField> getOrderItemFieldObjectDataResponse = client
                        .getDynamicFieldMoveObject(testOrderItemTableId, fieldName, OrderItemDynamicField.class);
                System.out.println(getOrderItemFieldObjectDataResponse);
                System.out.println(getOrderItemFieldObjectDataResponse.getData().getContent().getFields().getId());
                System.out.println("== get object by id. ==");
                SuiMoveObjectResponse<OrderItemDynamicField> getOrderItemFieldObjectDataResponse_2
                        = client.getMoveObject(fieldObjectId,
                        new SuiObjectDataOptions(
                                true,
                                true,
                                true,
                                true,
                                true,
                                true,
                                true
                        ),
                        OrderItemDynamicField.class);
                System.out.println(getOrderItemFieldObjectDataResponse_2);
                System.out.println(getOrderItemFieldObjectDataResponse_2.getData().getContent().getFields().getName());
                System.out.println(getOrderItemFieldObjectDataResponse_2.getData().getContent().getFields().getId());
                OrderItem orderItem = getOrderItemFieldObjectDataResponse_2
                        .getData()
                        .getContent()
                        .getFields()
                        .getValue()
                        .getFields();
                System.out.println(orderItem);
            }
            cursor = orderItemPage.getNextCursor();
            System.out.println("cursor: " + cursor);
            if (!Page.hasNextPage(orderItemPage)) {
                System.out.println("end of pages");
                break;
            }
        }

//        GetMoveObjectDataResponse<TestOrder.OrderItemField> getOrderItemsObjectDataResponse = client.getMoveObject(
//                testOrderItemTableId.getId(),
//                TestOrder.OrderItemField.class
//        );
//        System.out.println(getOrderItemsObjectDataResponse);
//        System.out.println(objectMapper.writeValueAsString(getOrderItemsObjectDataResponse));
    }

//    @Test
//    void testGetObjectsOwnedByObject_1() throws MalformedURLException, JsonProcessingException {
//        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        List<SuiObjectInfo> objectsOwnedByObject = client.getObjectsOwnedByObject(
//                "0xc8bfe731b7ef35fdab2c3ef99f09194e40627a10"
//        );
//        System.out.println(objectsOwnedByObject);
//        System.out.println(objectMapper.writeValueAsString(objectsOwnedByObject));
//    }

    @Test
    void testGetDynamicFields_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.testnet.sui.io/");
        DynamicFieldPage<?> dynamicFieldPage = client.getDynamicFields(
                "0xfcd0ec6e39a71add89f8287d1a958a8fd47eea7638d63e1cd13d5b1ab596460b",
                null, null, Object.class
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
        SuiMoveObjectResponse<OrderItemDynamicField> getObjectDataResponse = client.getMoveObject(
                "0x90c40b57ba0f4cdf060f6b387229e0de232c407a",
                new SuiObjectDataOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                ),
                OrderItemDynamicField.class
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetMoveObject_D() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiMoveObjectResponse<DaySummary> getObjectDataResponse = client.getMoveObject(
                "0x617fa230018fa51185dfa4cfca28a444a997d0e40026f81927ea6f52148de03d",
                new SuiObjectDataOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                ),
                DaySummary.class
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetMoveObject_4() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        SuiMoveObjectResponse<DomainName> getObjectDataResponse = client.getMoveObject(
                "0x8bfd9d58baf907954f392660ffbba1e59011caaa",
                new SuiObjectDataOptions(
                        true,
                        true,
                        true,
                        true,
                        true,
                        true,
                        true
                ),
                DomainName.class
        );
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
    }

    @Test
    void testGetDynamicFieldObject() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String parentObjectId = "0xc8bfe731b7ef35fdab2c3ef99f09194e40627a10";
        DynamicFieldName name = null;//todo "0x1::string::String {bytes: vector[48u8, 49u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8, 48u8]}";
        // ------------------
        SuiObjectResponse getObjectDataResponse = client.getDynamicFieldObject(parentObjectId, name);
        System.out.println(getObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getObjectDataResponse));
        // ------------------
        SuiMoveObjectResponse<OrderItemDynamicField> getMoveObjectDataResponse = client
                .getDynamicFieldMoveObject(parentObjectId, name, OrderItemDynamicField.class);
        System.out.println(getMoveObjectDataResponse);
        System.out.println(objectMapper.writeValueAsString(getMoveObjectDataResponse));
    }

    @Test
    void testGetDynamicField() throws MalformedURLException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.testnet.sui.io/");
        String objectIdOfDynamicField = "0xf244f3fec38cd8fd572104a45f10d502ddf2701cbcf8352a4ce7b6d670939158";
        SuiMoveObjectResponse<SimpleDynamicField<String, BigInteger>> getMoveObjectResp = client.getMoveObject(objectIdOfDynamicField,
                new SuiObjectDataOptions(true, true, true, true, true, true, true),
                new TypeReference<SuiMoveObjectResponse<SimpleDynamicField<String, BigInteger>>>() {
                }
        );
        System.out.println(getMoveObjectResp);
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

    //@Test
    void testPrivateKeyToPublicKey() {
        String privateKeyHex = "";//fill in private key
        byte[] privateKeyBytes = HexUtils.hexToByteArray(privateKeyHex);
        Ed25519PrivateKeyParameters privateKeyParameters = new Ed25519PrivateKeyParameters(privateKeyBytes);
        Ed25519PublicKeyParameters publicKeyParameters = privateKeyParameters.generatePublicKey();
        byte[] publicKeyBytes = publicKeyParameters.getEncoded();
        String publicKeyHex = HexUtils.byteArrayToHex(publicKeyBytes);
        System.out.println(publicKeyHex);//cd283a91930533987b1d2429db1b0453d03e5b188d00298a4bb6415f6cbf414e
        String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKeyBytes);
        System.out.println(publicKeyBase64);//zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=
    }

    @Test
    void testExecuteMoveCall_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        //SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        TransactionBytes encodeResult = encodeATestMoveCallTransaction(client, signerAddress);
        System.out.println(encodeResult);
        //System.out.println(objectMapper.writeValueAsString(result));
        String txBytes = encodeResult.getTxBytes();
        String sigScheme = SignatureScheme.ED25519;

        String privateKeyHex = "";//todo fill in the private key here
        String publicKeyBase64 = "zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=";

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
        byte sigSchemeByte;
        if (SignatureScheme.ED25519.equals(sigScheme)) {
            sigSchemeByte = 0;
        } else {
            throw new UnsupportedOperationException();
        }
        byte[] publicKey = Base64.getDecoder().decode(publicKeyBase64);
        //`flag || signature || pubkey` bytes,
        byte[] signature = Bytes.concat(
                new byte[]{sigSchemeByte},
                TransactionUtils.ed25519SignTransactionBytes(privateKey, txBytes),
                publicKey
        );
        String requestType = ExecuteTransactionRequestType.WAIT_FOR_EFFECTS_CERT;

        SuiExecuteTransactionResponse response = client.executeTransactionSerializedSig(
                txBytes,
                Base64.getEncoder().encodeToString(signature),
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
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
        SuiTransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
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
        SuiTransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
        TransactionBytes transactionBytes = client.payAllSui(signer, inputCoins, recipient, gasBudget);
        SuiTransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
        TransactionBytes transactionBytes = client.pay(signer, inputCoins, recipients, amounts, gasObjectId, gasBudget);
        SuiTransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
        TransactionBytes transactionBytes = client.paySui(signer, inputCoins, recipients, amounts, gasBudget);
        SuiTransactionEffects transactionEffects = client.dryRunTransaction(transactionBytes.getTxBytes());
        System.out.println(transactionEffects);
    }

    @Test
    void testDryRunTransaction_1() throws MalformedURLException, JsonProcessingException {
        String txBytes = "AQECAAAAAAAAAAAAAAAAAAAAAAAAAAIBAAAAAAAAACAsl58oZElxuAIo2GjCz+IBOEMg7t5UGPjc/+T2xv7uzgtsb2NrZWRfY29pbglsb2NrX2NvaW4BBwAAAAAAAAAAAAAAAAAAAAAAAAACA3N1aQNTVUkAAwEAL7WBWtgXCvMuHZ1+DWUmwBP8lzcBAAAAAAAAACArk/jbO5ZDr9GpkvlJdaXr9DtEILIXCX3FXCiiley2AgAUPCzzWg1NKd2dH2NDpur+AxMb+voACACgck4YCQAAPCzzWg1NKd2dH2NDpur+AxMb+vopTBJZhARVd5UWWwyi5EdpvQbJUwgAAAAAAAAAIHPmBAVvqy2ZINnuDjPcjyuCCbNWixbmw35oU/EqF03uAQAAAAAAAABAQg8AAAAAAA==";
        SuiJsonRpcClient client = new SuiJsonRpcClient("http://localhost:9000");
        SuiTransactionEffects transactionEffects = client.dryRunTransaction(txBytes);
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
        String recipient = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        long amount = 1L;
        TransactionBytes result = client.transferSui(signerAddress, suiObjectId, gasBudget, recipient, amount);
        System.out.println(result);
        System.out.println(objectMapper.writeValueAsString(result));
        System.out.println(result.getTxBytes());
    }

    @Test
    void testTransferObject_1() throws MalformedURLException, JsonProcessingException {
        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
        String signerAddress = "0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa";
        String objectId = "0x8134656922ebdfdd67a4e6a3da444d53c997c196";
        String gasObjectId = "0xbe8139d6d384d15dafd0b78274b983655ec045f4";
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;
        String recipient = "0x29e076107fc5a7c5f7c179d4e5547674fb0a0a8e";//to self?
        TransactionBytes encodeResult = client.transferObject(signerAddress, objectId, gasObjectId, gasBudget, recipient);
        System.out.println(encodeResult);
//        System.out.println(objectMapper.writeValueAsString(encodeResult));
//        System.out.println(encodeResult.getTxBytes());

        String txBytes = encodeResult.getTxBytes();
        String sigScheme = SignatureScheme.ED25519;

        String privateKeyHex = "";//todo fill in the private key here
        String publicKeyBase64 = "zSg6kZMFM5h7HSQp2xsEU9A+WxiNACmKS7ZBX2y/QU4=";

        SuiExecuteTransactionResponse response = executeTransaction(client, txBytes,
                publicKeyBase64, sigScheme, HexUtils.hexToByteArray(privateKeyHex));
        System.out.println(response);
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
        long gasBudget = DEFAULT_MAX_GAS_BUDGE;

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


//    @Test
//    void testGetValidators() throws MalformedURLException, JsonProcessingException {
//        SuiJsonRpcClient client = new SuiJsonRpcClient("https://fullnode.devnet.sui.io/");
//        List<ValidatorMetadata> result = client.getValidators();
//        System.out.println(result);
//        System.out.println(objectMapper.writeValueAsString(result));
//    }

}
