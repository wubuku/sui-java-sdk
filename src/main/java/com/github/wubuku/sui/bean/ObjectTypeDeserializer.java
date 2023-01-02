package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class ObjectTypeDeserializer extends JsonDeserializer<ObjectType> {
    @Override
    public ObjectType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String code = jsonParser.getText();
            if ("moveObject".equals(code)) {
                return ObjectType.MOVE_OBJECT;
            } else if ("package".equals(code)) {
                return ObjectType.PACKAGE;
            }
            throw new InvalidFormatException(jsonParser, "ObjectTypeDeserializer.deserialize() error.", currentToken, ObjectType.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "ObjectTypeDeserializer.deserialize() error.", currentToken, ObjectType.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "ObjectTypeDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectType.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "ObjectTypeDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectType.class);
        }
        return null;
    }
}
