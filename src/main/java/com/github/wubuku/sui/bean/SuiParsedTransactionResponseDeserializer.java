package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiParsedTransactionResponseDeserializer extends JsonDeserializer<SuiParsedTransactionResponse> {
    @Override
    public SuiParsedTransactionResponse deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiParsedTransactionResponseDeserializer.deserialize() error.", currentToken, SuiParsedTransactionResponse.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiParsedTransactionResponseDeserializer.deserialize() error.", currentToken, SuiParsedTransactionResponse.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiParsedTransactionResponse suiParsedTransactionResponse;
            if ("SplitCoin".equals(fieldName)) {
                jsonParser.nextToken();
                suiParsedTransactionResponse = new SuiParsedTransactionResponse.SplitCoin(jsonParser.readValueAs(SuiParsedSplitCoinResponse.class));
            } else if ("MergeCoin".equals(fieldName)) {
                jsonParser.nextToken();
                suiParsedTransactionResponse = new SuiParsedTransactionResponse.MergeCoin(jsonParser.readValueAs(SuiParsedMergeCoinResponse.class));
            } else if ("Publish".equals(fieldName)) {
                jsonParser.nextToken();
                suiParsedTransactionResponse = new SuiParsedTransactionResponse.Publish(jsonParser.readValueAs(SuiParsedPublishResponse.class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiParsedTransactionResponseDeserializer.deserialize() error.", jsonParser.currentToken(), SuiParsedTransactionResponse.class);
            }
            jsonParser.nextToken();
            return suiParsedTransactionResponse;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiParsedTransactionResponseDeserializer.deserialize() error.", jsonParser.currentToken(), SuiParsedTransactionResponse.class);
        }
        return null;
    }
}
