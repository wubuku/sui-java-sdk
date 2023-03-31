package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigInteger;

public class SuiCallArgDeserializer extends JsonDeserializer<SuiCallArg> {
    @Override
    public SuiCallArg deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", currentToken, SuiCallArg.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", currentToken, SuiCallArg.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();

            String type = null;
            String objectType = null;

            String objectId = null;
            BigInteger version = null;
            String digest = null;

            //String objectId;
            BigInteger initialSharedVersion = null;
            Boolean mutable = null;

            String valueType = null;
            SuiJsonValue value = null;

            while (null != fieldName) {
                if ("type".equals(fieldName)) {
                    jsonParser.nextToken();
                    type = jsonParser.getValueAsString();
                } else if ("objectType".equals(fieldName)) {
                    jsonParser.nextToken();
                    objectType = jsonParser.getValueAsString();
                } else if ("objectId".equals(fieldName)) {
                    jsonParser.nextToken();
                    objectId = jsonParser.getValueAsString();
                } else if ("version".equals(fieldName)) {
                    jsonParser.nextToken();
                    version = jsonParser.getBigIntegerValue();
                } else if ("digest".equals(fieldName)) {
                    jsonParser.nextToken();
                    digest = jsonParser.getValueAsString();
                } else if ("initialSharedVersion".equals(fieldName)) {
                    jsonParser.nextToken();
                    initialSharedVersion = jsonParser.getBigIntegerValue();
                } else if ("mutable".equals(fieldName)) {
                    jsonParser.nextToken();
                    mutable = jsonParser.getBooleanValue();
                } else if ("valueType".equals(fieldName)) {
                    jsonParser.nextToken();
                    valueType = jsonParser.getValueAsString();
                } else if ("value".equals(fieldName)) {
                    jsonParser.nextToken();
                    value = jsonParser.readValueAs(SuiJsonValue.class);
                } else {
                    throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
            }
            if ("object".equals(type)) {
                if ("immOrOwnedObject".equals(objectType)) {
                    return new SuiCallArg.Object.ImmOrOwnedObject(objectId, version, digest);
                } else if ("sharedObject".equals(objectType)) {
                    return new SuiCallArg.Object.SharedObject(objectId, initialSharedVersion, mutable);
                }
            } else if ("pure".equals(type)) {
                return new SuiCallArg.Pure(valueType, value);
            }
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
        }
        return null;
    }
}
