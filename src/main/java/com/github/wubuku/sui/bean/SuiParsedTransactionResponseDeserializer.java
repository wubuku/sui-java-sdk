package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SuiParsedTransactionResponseDeserializer extends JsonDeserializer<SuiParsedTransactionResponse> {
    @Override
    public SuiParsedTransactionResponse deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        return null;//todo
    }
}
