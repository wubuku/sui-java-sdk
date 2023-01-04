package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiTransactionKindDeserializer extends JsonDeserializer<SuiTransactionKind> {
    @Override
    public SuiTransactionKind deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiTransactionKindDeserializer.deserialize() error.", currentToken, SuiTransactionKind.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiTransactionKindDeserializer.deserialize() error.", currentToken, SuiTransactionKind.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiTransactionKind suiTransactionKind;
            if ("TransferObject".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.TransferObject(jsonParser.readValueAs(TransferObject.class));
            } else if ("Publish".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.Publish(jsonParser.readValueAs(SuiMovePackage.class));
            } else if ("Call".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.Call(jsonParser.readValueAs(MoveCall.class));
            } else if ("TransferSui".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.TransferSui(jsonParser.readValueAs(SuiTransferSui.class));
            } else if ("ChangeEpoch".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.ChangeEpoch(jsonParser.readValueAs(SuiChangeEpoch.class));
            } else if ("Pay".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.Pay(jsonParser.readValueAs(Pay.class));
            } else if ("PaySui".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.PaySui(jsonParser.readValueAs(PaySui.class));
            } else if ("PayAllSui".equals(fieldName)) {
                jsonParser.nextToken();
                suiTransactionKind = new SuiTransactionKind.PayAllSui(jsonParser.readValueAs(PayAllSui.class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiTransactionKindDeserializer.deserialize() error.", jsonParser.currentToken(), SuiTransactionKind.class);
            }
            jsonParser.nextToken();
            return suiTransactionKind;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiTransactionKindDeserializer.deserialize() error.", jsonParser.currentToken(), SuiTransactionKind.class);
        }
        return null;
    }
}
