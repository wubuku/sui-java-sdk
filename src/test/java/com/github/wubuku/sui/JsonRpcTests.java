package com.github.wubuku.sui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.sui.bean.*;
import org.junit.jupiter.api.Test;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;
import org.starcoin.jsonrpc.client.JSONRPC2Session;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonRpcTests {
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJsonRpc_1() throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {
        String suiDevnetRpcHost = "https://fullnode.devnet.sui.io/";
        JSONRPC2Session jsonrpc2Session = new JSONRPC2Session(new URL(suiDevnetRpcHost));
        if (false) {
            List<Object> params_1 = new ArrayList<>();
            // The first parameter is EventQuery.
            params_1.add(EventQuery.All.INSTANCE); //params.add(new EventQuery.MoveEvent("0x2::devnet_nft::MintNFTEvent"));
            params_1.add(null); // The second parameter is cursor : <EventID> - optional paging cursor
            //params.add(new EventId(1L, 0L)); // cursor
            params_1.add(1);// The third parameter is 'limit'
            params_1.add(false);// The fourth parameter is descending_order
            JSONRPC2Request jsonrpc2Request_1 = new JSONRPC2Request("sui_getEvents", params_1, 1);
            JSONRPC2Response<PaginatedEvents> jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request_1,
                    new TypeReference<PaginatedEvents>() {
                    });
            System.out.println(jsonrpc2Response);
            System.out.println(new ObjectMapper().writeValueAsString(jsonrpc2Response));
        }
//        List<Object> params_2 = new ArrayList<>();
//        params_2.add(new EventQuery.MoveEvent("0x2::devnet_nft::MintNFTEvent"));// The first parameter is EventQuery.
//        params_2.add(null);// The second parameter is cursor : <EventID> - optional paging cursor
//        params_2.add(1);// limit
//        params_2.add(true);// descending_order
//        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getEvents", params_2, 1);
//        JSONRPC2Response<PaginatedMoveEvents<MintNFTEvent>> jsonrpc2Response2 = jsonrpc2Session
//                .sendAndGetParametricTypeResult(jsonrpc2Request,
//                        PaginatedMoveEvents.class,
//                        MintNFTEvent.class);
//        System.out.println(jsonrpc2Response2);
//        System.out.println(new ObjectMapper().writeValueAsString(jsonrpc2Response2));
    }

    @Test
    void testJsonRpc_2() throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {
        String suiDevnetRpcHost = "https://fullnode.devnet.sui.io/";
        JSONRPC2Session jsonrpc2Session = new JSONRPC2Session(new URL(suiDevnetRpcHost));
        List<Object> params = new ArrayList<>();
        params.add("0x3c2cf35a0d4d29dd9d1f6343a6eafe03131bfafa");
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getObjectsOwnedByAddress", params, 1);
        JSONRPC2Response<List<SuiObjectInfo>> jsonrpc2Response2 = jsonrpc2Session.sendAndGetListResult(
                jsonrpc2Request, SuiObjectInfo.class);
        System.out.println(new ObjectMapper().writeValueAsString(jsonrpc2Response2));
    }

    @Test
    void testJsonRpc_3() throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {
        String suiDevnetRpcHost = "https://fullnode.devnet.sui.io/";
        JSONRPC2Session jsonrpc2Session = new JSONRPC2Session(new URL(suiDevnetRpcHost));
        List<Object> params = new ArrayList<>();
        params.add("0x0b7a32cfbfbe22b55f3ad703b1b6af130266086e");
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getObject", params, 1);
        JSONRPC2Response<GetObjectDataResponse> jsonrpc2Response2 = jsonrpc2Session.send(jsonrpc2Request, GetObjectDataResponse.class);
        System.out.println(new ObjectMapper().writeValueAsString(jsonrpc2Response2));
    }

    @Test
    void testJsonDeserialize_4() throws JsonProcessingException {
        String json = "{\n" +
                "  \"id\": 1,\n" +
                "  \"jsonrpc\": \"2.0\",\n" +
                "  \"result\": {\n" +
                "    \"data\": [\n" +
                "      {\n" +
                "        \"event\": {\n" +
                "          \"moveEvent\": {\n" +
                "            \"bcs\": \"xZf38IrQNqH4nYmQybDhjQDNJtliUmwY0Ii3yFV9V97t6TYrkei00wlTdWlldCBORlQ=\",\n" +
                "            \"fields\": {\n" +
                "              \"creator\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "              \"name\": \"Suiet NFT\",\n" +
                "              \"object_id\": \"0xc597f7f08ad036a1f89d8990c9b0e18d00cd26d9\"\n" +
                "            },\n" +
                "            \"packageId\": \"0x0000000000000000000000000000000000000002\",\n" +
                "            \"sender\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "            \"transactionModule\": \"devnet_nft\",\n" +
                "            \"type\": \"0x2::devnet_nft::MintNFTEvent\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"id\": {\n" +
                "          \"eventSeq\": 2,\n" +
                "          \"txSeq\": 44\n" +
                "        },\n" +
                "        \"timestamp\": 1672366130490,\n" +
                "        \"txDigest\": \"E9J1iVw2FrmdVwNqAtm4pyxdZQZZkai8oGDUS8d2PLmJ\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"event\": {\n" +
                "          \"moveEvent\": {\n" +
                "            \"bcs\": \"5tdxnmVFQyN2L1l8fRQOpPGQXmViUmwY0Ii3yFV9V97t6TYrkei00wlTdWlldCBORlQ=\",\n" +
                "            \"fields\": {\n" +
                "              \"creator\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "              \"name\": \"Suiet NFT\",\n" +
                "              \"object_id\": \"0xe6d7719e65454323762f597c7d140ea4f1905e65\"\n" +
                "            },\n" +
                "            \"packageId\": \"0x0000000000000000000000000000000000000002\",\n" +
                "            \"sender\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "            \"transactionModule\": \"devnet_nft\",\n" +
                "            \"type\": \"0x2::devnet_nft::MintNFTEvent\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"id\": {\n" +
                "          \"eventSeq\": 2,\n" +
                "          \"txSeq\": 45\n" +
                "        },\n" +
                "        \"timestamp\": 1672366130493,\n" +
                "        \"txDigest\": \"H1wMj9YzJB2KN7cWYyAiD6UwGdvQGMekJPYEkWXvYxJs\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"nextCursor\": {\n" +
                "      \"eventSeq\": 2,\n" +
                "      \"txSeq\": 51\n" +
                "    }\n" +
                "  }\n" +
                "}";
        ObjectMapper om = objectMapper;
        Class<?> parametrized = PaginatedMoveEvents.class;
        Class<?> parameterClasses = MintNFTEvent.class;
        JSONRPC2Response<PaginatedMoveEvents<MintNFTEvent>> paginatedMoveEventsJSONRPC2Response = om.readValue(json,
                om.getTypeFactory().constructParametricType(JSONRPC2Response.class,
                        om.getTypeFactory().constructParametricType(parametrized, parameterClasses)));
        System.out.println(paginatedMoveEventsJSONRPC2Response);
    }

    @Test
    void testJsonDeserialize_3() throws JsonProcessingException {
        String json_3 = "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"event\": {\n" +
                "        \"moveEvent\": {\n" +
                "          \"bcs\": \"xZf38IrQNqH4nYmQybDhjQDNJtliUmwY0Ii3yFV9V97t6TYrkei00wlTdWlldCBORlQ=\",\n" +
                "          \"fields\": {\n" +
                "            \"creator\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "            \"name\": \"Suiet NFT\",\n" +
                "            \"object_id\": \"0xc597f7f08ad036a1f89d8990c9b0e18d00cd26d9\"\n" +
                "          },\n" +
                "          \"packageId\": \"0x0000000000000000000000000000000000000002\",\n" +
                "          \"sender\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "          \"transactionModule\": \"devnet_nft\",\n" +
                "          \"type\": \"0x2::devnet_nft::MintNFTEvent\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"id\": {\n" +
                "        \"eventSeq\": 2,\n" +
                "        \"txSeq\": 44\n" +
                "      },\n" +
                "      \"timestamp\": 1672366130490,\n" +
                "      \"txDigest\": \"E9J1iVw2FrmdVwNqAtm4pyxdZQZZkai8oGDUS8d2PLmJ\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"event\": {\n" +
                "        \"moveEvent\": {\n" +
                "          \"bcs\": \"5tdxnmVFQyN2L1l8fRQOpPGQXmViUmwY0Ii3yFV9V97t6TYrkei00wlTdWlldCBORlQ=\",\n" +
                "          \"fields\": {\n" +
                "            \"creator\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "            \"name\": \"Suiet NFT\",\n" +
                "            \"object_id\": \"0xe6d7719e65454323762f597c7d140ea4f1905e65\"\n" +
                "          },\n" +
                "          \"packageId\": \"0x0000000000000000000000000000000000000002\",\n" +
                "          \"sender\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "          \"transactionModule\": \"devnet_nft\",\n" +
                "          \"type\": \"0x2::devnet_nft::MintNFTEvent\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"id\": {\n" +
                "        \"eventSeq\": 2,\n" +
                "        \"txSeq\": 45\n" +
                "      },\n" +
                "      \"timestamp\": 1672366130493,\n" +
                "      \"txDigest\": \"H1wMj9YzJB2KN7cWYyAiD6UwGdvQGMekJPYEkWXvYxJs\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"nextCursor\": {\n" +
                "    \"eventSeq\": 2,\n" +
                "    \"txSeq\": 51\n" +
                "  }\n" +
                "}";
        PaginatedMoveEvents<Map<String, Object>> paginatedMoveEvents = objectMapper.readValue(
                json_3,
                new TypeReference<PaginatedMoveEvents<Map<String, Object>>>() {
                }
        );
        System.out.println(paginatedMoveEvents);
    }

    @Test
    void testJsonDeserialize_2() throws JsonProcessingException {
        String json_2 = " {\n" +
                "      \"data\" : [\n" +
                "         {\n" +
                "            \"event\" : {\n" +
                "               \"coinBalanceChange\" : {\n" +
                "                  \"amount\" : -183,\n" +
                "                  \"changeType\" : \"Gas\",\n" +
                "                  \"coinObjectId\" : \"0xb1e5500000000000000000000000000000000001\",\n" +
                "                  \"coinType\" : \"0x2::sui::SUI\",\n" +
                "                  \"owner\" : {\n" +
                "                     \"AddressOwner\" : \"0xc4173a804406a365e69dfb297d4eaaf002546ebd\"\n" +
                "                  },\n" +
                "                  \"packageId\" : \"0x0000000000000000000000000000000000000002\",\n" +
                "                  \"sender\" : \"0xc4173a804406a365e69dfb297d4eaaf002546ebd\",\n" +
                "                  \"transactionModule\" : \"gas\",\n" +
                "                  \"version\" : 1\n" +
                "               }\n" +
                "            },\n" +
                "            \"id\" : {\n" +
                "               \"eventSeq\" : 0,\n" +
                "               \"txSeq\" : 0\n" +
                "            },\n" +
                "            \"timestamp\" : 1672366130454,\n" +
                "            \"txDigest\" : \"cZQCA4UjrAK2BnpS2X7tWwLwFKc6KQUAdKBumHntCSA\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"nextCursor\" : {\n" +
                "         \"eventSeq\" : 1,\n" +
                "         \"txSeq\" : 0\n" +
                "      }\n" +
                "   }";
        PaginatedEvents paginatedEvents = objectMapper.readValue(json_2, PaginatedEvents.class);
        System.out.println(paginatedEvents);
    }

    @Test
    void testJsonDeserialize_1() throws JsonProcessingException {
        String json_1 = "{\n" +
                "  \"event\": {\n" +
                "    \"moveEvent\": {\n" +
                "      \"bcs\": \"xZf38IrQNqH4nYmQybDhjQDNJtliUmwY0Ii3yFV9V97t6TYrkei00wlTdWlldCBORlQ=\",\n" +
                "      \"fields\": {\n" +
                "        \"creator\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "        \"name\": \"Suiet NFT\",\n" +
                "        \"object_id\": \"0xc597f7f08ad036a1f89d8990c9b0e18d00cd26d9\"\n" +
                "      },\n" +
                "      \"packageId\": \"0x0000000000000000000000000000000000000002\",\n" +
                "      \"sender\": \"0x62526c18d088b7c8557d57deede9362b91e8b4d3\",\n" +
                "      \"transactionModule\": \"devnet_nft\",\n" +
                "      \"type\": \"0x2::devnet_nft::MintNFTEvent\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"id\": {\n" +
                "    \"eventSeq\": 2,\n" +
                "    \"txSeq\": 44\n" +
                "  },\n" +
                "  \"timestamp\": 1672366130490,\n" +
                "  \"txDigest\": \"E9J1iVw2FrmdVwNqAtm4pyxdZQZZkai8oGDUS8d2PLmJ\"\n" +
                "}";

        SuiEventEnvelope suiEventEnvelope = objectMapper.readValue(json_1, SuiEventEnvelope.class);
        System.out.println(suiEventEnvelope);
    }

    public static class MintNFTEvent {
        public String creator;
        public String name;
        public String object_id;

        @Override
        public String toString() {
            return "MintNFTEvent{" +
                    "creator='" + creator + '\'' +
                    ", name='" + name + '\'' +
                    ", object_id='" + object_id + '\'' +
                    '}';
        }
    }

}
