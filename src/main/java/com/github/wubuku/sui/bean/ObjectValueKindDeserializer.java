package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class ObjectValueKindDeserializer extends JsonDeserializer<ObjectValueKind> {
    @Override
    public ObjectValueKind deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JacksonException {
        String code = jsonParser.getText();
        switch (code) {
            case "ByImmutableReference":
                return ObjectValueKind.BY_IMMUTABLE_REFERENCE;
            case "ByMutableReference":
                return ObjectValueKind.BY_MUTABLE_REFERENCE;
            case "ByValue":
                return ObjectValueKind.BY_VALUE;
            default:
                throw new InvalidFormatException(jsonParser, "ObjectValueKindDeserializer.deserialize() error.",
                        jsonParser.currentToken(), ObjectValueKind.class);
        }
    }
}
