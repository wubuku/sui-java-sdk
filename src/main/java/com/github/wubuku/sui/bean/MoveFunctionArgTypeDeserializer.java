package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class MoveFunctionArgTypeDeserializer extends JsonDeserializer<MoveFunctionArgType> {
    @Override
    public MoveFunctionArgType deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String text = jsonParser.getText();
            if ("Pure".equals(text)) {
                return MoveFunctionArgType.Pure.INSTANCE;
            }
            throw new InvalidFormatException(jsonParser, "MoveFunctionArgTypeDeserializer.deserialize() error.", currentToken, MoveFunctionArgType.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "MoveFunctionArgTypeDeserializer.deserialize() error.", currentToken, MoveFunctionArgType.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            MoveFunctionArgType moveFunctionArgType;
            if ("Object".equals(fieldName)) {
                jsonParser.nextToken();
                moveFunctionArgType = new MoveFunctionArgType.Object(jsonParser.readValueAs(ObjectValueKind.class));
            } else {
                throw new InvalidFormatException(jsonParser, "MoveFunctionArgTypeDeserializer.deserialize() error.", jsonParser.currentToken(), MoveFunctionArgType.class);
            }
            jsonParser.nextToken();
            if (!JsonToken.END_OBJECT.equals(jsonParser.getCurrentToken())) {
                throw new InvalidFormatException(jsonParser, "MoveFunctionArgTypeDeserializer.deserialize() error.", jsonParser.currentToken(), MoveFunctionArgType.class);
            }
            return moveFunctionArgType;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "MoveFunctionArgTypeDeserializer.deserialize() error.", jsonParser.currentToken(), MoveFunctionArgType.class);
        }
        return null;
    }
}
