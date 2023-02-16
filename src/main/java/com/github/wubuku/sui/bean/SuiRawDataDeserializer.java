package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;

public class SuiRawDataDeserializer extends JsonDeserializer<SuiRawData> {
    @Override
    public SuiRawData deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {

        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiRawDataDeserializer.deserialize() error.", currentToken, SuiRawData.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiRawDataDeserializer.deserialize() error.", currentToken, SuiRawData.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            ObjectType dataType = null;
            // SuiRawData.SuiMoveObject fields
            String type = null;
            Boolean has_public_transfer = null;
            BigInteger version = null;
            String bcsBytes = null;
            // SuiRawData.SuiMovePackage fields
            String id = null;
            Map<String, String> moduleMap = null;
            while (null != fieldName) {
                if ("dataType".equals(fieldName)) {
                    jsonParser.nextToken();
                    dataType = jsonParser.readValueAs(ObjectType.class);
                } else if ("type".equals(fieldName)) {
                    jsonParser.nextToken();
                    type = jsonParser.getValueAsString();
                } else if ("has_public_transfer".equals(fieldName)) {
                    jsonParser.nextToken();
                    has_public_transfer = jsonParser.getBooleanValue();
                } else if ("version".equals(fieldName)) {
                    jsonParser.nextToken();
                    version = jsonParser.getBigIntegerValue();
                } else if ("bcs_bytes".equals(fieldName)) {
                    jsonParser.nextToken();
                    bcsBytes = jsonParser.getText();
                } else if ("id".equals(fieldName)) {
                    jsonParser.nextToken();
                    id = jsonParser.getText();
                } else if ("module_map".equals(fieldName)) {
                    jsonParser.nextToken();
                    moduleMap = jsonParser.readValueAs(new TypeReference<Map<String, String>>() {
                    });
                } else {
                    throw new InvalidFormatException(jsonParser, "SuiRawDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiRawData.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiRawDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiRawData.class);
            }
            if (type != null) {
                return new SuiRawData.SuiMoveObject(type, has_public_transfer, version, bcsBytes, dataType);
            }
            if (id != null) {
                return new SuiRawData.SuiMovePackage(id, moduleMap, dataType);
            }
            throw new InvalidFormatException(jsonParser, "SuiRawDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiRawData.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiRawDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiRawData.class);
        }
        return null;
    }
}
