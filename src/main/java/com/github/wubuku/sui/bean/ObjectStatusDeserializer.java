package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class ObjectStatusDeserializer extends JsonDeserializer<ObjectStatus> {
    @Override
    public ObjectStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String code = jsonParser.getText();
            if ("Exists".equals(code)) {
                return ObjectStatus.EXISTS;
            } else if ("NotExists".equals(code)) {
                return ObjectStatus.NOT_EXISTS;
            } else if ("Deleted".equals(code)) {
                return ObjectStatus.DELETED;
            }
            throw new InvalidFormatException(jsonParser, "ObjectStatusDeserializer.deserialize() error.", currentToken, ObjectStatus.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "ObjectStatusDeserializer.deserialize() error.", currentToken, ObjectStatus.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "ObjectStatusDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectStatus.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "ObjectStatusDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectStatus.class);
        }
        return null;
    }
}