package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiPastObjectReadStatusDeserializer extends JsonDeserializer<SuiPastObjectReadStatus> {
    @Override
    public SuiPastObjectReadStatus deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String code = jsonParser.getText();
            if ("VersionFound".equals(code)) {
                return SuiPastObjectReadStatus.VERSION_FOUND;
            } else if ("ObjectNotExists".equals(code)) {
                return SuiPastObjectReadStatus.OBJECT_NOT_EXISTS;
            } else if ("ObjectDeleted".equals(code)) {
                return SuiPastObjectReadStatus.OBJECT_DELETED;
            } else if ("VersionNotFound".equals(code)) {
                return SuiPastObjectReadStatus.VERSION_NOT_FOUND;
            } else if ("VersionTooHigh".equals(code)) {
                return SuiPastObjectReadStatus.VERSION_TOO_HIGH;
            }
            throw new InvalidFormatException(jsonParser, "SuiPastObjectReadStatusDeserializer.deserialize() error.", currentToken, SuiPastObjectReadStatus.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiPastObjectReadStatusDeserializer.deserialize() error.", currentToken, SuiPastObjectReadStatus.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiPastObjectReadStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiPastObjectReadStatus.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiPastObjectReadStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiPastObjectReadStatus.class);
        }
        return null;
    }
}
