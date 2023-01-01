package com.github.wubuku.sui;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wubuku.sui.bean.EventId;
import com.github.wubuku.sui.bean.EventQuery;
import org.starcoin.jsonrpc.JSONRPC2Request;
import org.starcoin.jsonrpc.JSONRPC2Response;
import org.starcoin.jsonrpc.client.JSONRPC2Session;
import org.starcoin.jsonrpc.client.JSONRPC2SessionException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonRpcTests {

    public static void main(String[] args) throws MalformedURLException, JSONRPC2SessionException, JsonProcessingException {
        String suiDevnetRpcHost = "https://fullnode.devnet.sui.io";
        JSONRPC2Session jsonrpc2Session = new JSONRPC2Session(new URL(suiDevnetRpcHost));
        List<Object> params = new ArrayList<>();
        // The first parameter is EventQuery.
        params.add(EventQuery.All.INSTANCE);
        //params.add(new EventQuery.MoveEvent("0x2::devnet_nft::MintNFTEvent"));
        // The second parameter is cursor : <EventID> - optional paging cursor
        //params.add(null);//cursor
        params.add(new EventId(1L, 0L));
        // The third parameter is 'limit'
        params.add(1);//limit
        // The fourth parameter is descending_order
        params.add(false);//descending_order
        JSONRPC2Request jsonrpc2Request = new JSONRPC2Request("sui_getEvents", params, 1);
        JSONRPC2Response jsonrpc2Response = jsonrpc2Session.send(jsonrpc2Request);
        //System.out.println(jsonrpc2Response);
        System.out.println(new ObjectMapper().writeValueAsString(jsonrpc2Response));
    }

}
