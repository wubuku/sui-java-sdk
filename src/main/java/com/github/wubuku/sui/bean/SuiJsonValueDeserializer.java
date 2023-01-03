package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiJsonValueDeserializer extends JsonDeserializer<SuiJsonValue> {
    @Override
    public SuiJsonValue deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            return new SuiJsonValue.String_(jsonParser.getText());
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiJsonValueDeserializer.deserialize() error.", currentToken, SuiJsonValue.class);
        } else if (currentToken.isScalarValue()) {
            if (currentToken.isBoolean()) {
                return new SuiJsonValue.Boolean(jsonParser.getBooleanValue());
            } else if (currentToken.isNumeric()) {
                return new SuiJsonValue.Number(jsonParser.getLongValue());
            }
            throw new InvalidFormatException(jsonParser, "SuiJsonValueDeserializer.deserialize() error.", currentToken, SuiJsonValue.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiJsonValueDeserializer.deserialize() error.", jsonParser.currentToken(), SuiJsonValue.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            return new SuiJsonValue.Array(jsonParser.readValueAs(SuiJsonValue[].class));
        }
        return null;
    }
}
