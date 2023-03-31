package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiArgumentDeserializer extends JsonDeserializer<SuiArgument> {
    @Override
    public SuiArgument deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
             if ("GasCoin".equals(jsonParser.getValueAsString())) {
                 return SuiArgument.GasCoin.INSTANCE;
             } else {
                 throw new InvalidFormatException(jsonParser, "SuiArgumentDeserializer.deserialize() error.", currentToken, SuiArgument.class);
             }
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiArgumentDeserializer.deserialize() error.", currentToken, SuiArgument.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiArgument SuiArgument;
            if ("Input".equals(fieldName)) {
                jsonParser.nextToken();
                SuiArgument = new SuiArgument.Input(jsonParser.getIntValue());
            } else if ("Result".equals(fieldName)) {
                jsonParser.nextToken();
                SuiArgument = new SuiArgument.Result(jsonParser.getIntValue());
            } else if ("NestedResult".equals(fieldName)) {
                jsonParser.nextToken();
                SuiArgument = new SuiArgument.NestedResult(jsonParser.readValueAs(int[].class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiArgumentDeserializer.deserialize() error.", jsonParser.currentToken(), SuiArgument.class);
            }
            jsonParser.nextToken();
            if (!JsonToken.END_OBJECT.equals(jsonParser.getCurrentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiArgumentDeserializer.deserialize() error.", jsonParser.currentToken(), SuiArgument.class);
            }
            return SuiArgument;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiArgumentDeserializer.deserialize() error.", jsonParser.currentToken(), SuiArgument.class);
        }
        return null;

    }
}
