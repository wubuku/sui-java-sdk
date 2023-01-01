package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigInteger;

public class SuiEventDeserializer extends JsonDeserializer<SuiEvent> {
    @Override
    public SuiEvent deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiEventDeserializer.deserialize() error.", currentToken, SuiEvent.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiEventDeserializer.deserialize() error.", currentToken, SuiEvent.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiEvent suiEvent = null;
            if ("moveEvent".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.MoveEvent(jsonParser.readValueAs(MoveEvent.class));
            } else if ("publish".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.Publish(jsonParser.readValueAs(PublishEvent.class));
            } else if ("coinBalanceChange".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.CoinBalanceChange(jsonParser.readValueAs(CoinBalanceChangeEvent.class));
            } else if ("transferObject".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.TransferObject(jsonParser.readValueAs(TransferObjectEvent.class));
            } else if ("mutateObject".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.MutateObject(jsonParser.readValueAs(MutateObjectEvent.class));
            } else if ("deleteObject".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.DeleteObject(jsonParser.readValueAs(DeleteObjectEvent.class));
            } else if ("newObject".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.NewObject(jsonParser.readValueAs(NewObjectEvent.class));
            } else if ("epochChange".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.EpochChange(jsonParser.readValueAs(BigInteger.class));
            } else if ("checkpoint".equals(fieldName)) {
                jsonParser.nextToken();
                suiEvent = new SuiEvent.Checkpoint(jsonParser.readValueAs(BigInteger.class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiEventDeserializer.deserialize() error.", jsonParser.currentToken(), SuiEvent.class);
            }
            jsonParser.nextToken();
            return suiEvent;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiEventDeserializer.deserialize() error.", jsonParser.currentToken(), SuiEvent.class);
        }
        return null;
    }
}
