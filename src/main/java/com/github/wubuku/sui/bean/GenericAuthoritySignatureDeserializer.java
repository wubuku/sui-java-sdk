package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class GenericAuthoritySignatureDeserializer extends JsonDeserializer<GenericAuthoritySignature> {
    @Override
    public GenericAuthoritySignature deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            return new GenericAuthoritySignature.AuthoritySignature(jsonParser.getText());
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "GenericAuthoritySignatureDeserializer.deserialize() error.", currentToken, GenericAuthoritySignature.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "GenericAuthoritySignatureDeserializer.deserialize() error.", jsonParser.currentToken(), GenericAuthoritySignature.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            return new GenericAuthoritySignature.AuthoritySignatureArray(jsonParser.readValueAs(String[].class));
        }
        return null;
    }
}
