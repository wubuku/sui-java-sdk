package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class BalanceChangeTypeDeserializer extends JsonDeserializer<BalanceChangeType> {
    @Override
    public BalanceChangeType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String code = jsonParser.getText();
            if ("Gas".equals(code)) {
                return BalanceChangeType.GAS;
            } else if ("Pay".equals(code)) {
                return BalanceChangeType.PAY;
            } else if ("Receive".equals(code)) {
                return BalanceChangeType.RECEIVE;
            }
            throw new InvalidFormatException(jsonParser, "BalanceChangeTypeDeserializer.deserialize() error.", currentToken, BalanceChangeType.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "BalanceChangeTypeDeserializer.deserialize() error.", currentToken, BalanceChangeType.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "BalanceChangeTypeDeserializer.deserialize() error.", jsonParser.currentToken(), BalanceChangeType.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "BalanceChangeTypeDeserializer.deserialize() error.", jsonParser.currentToken(), BalanceChangeType.class);
        }
        return null;
    }
}
