package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiMoveNormalizedTypeDeserializer extends JsonDeserializer<SuiMoveNormalizedType> {
    @Override
    public SuiMoveNormalizedType deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            return jsonParser.readValueAs(SuiMoveNormalizedType.Primitive.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiMoveNormalizedTypeDeserializer.deserialize() error.", currentToken, SuiMoveNormalizedType.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiMoveNormalizedType suiMoveNormalizedType;
            if ("Struct".equals(fieldName)) {
                jsonParser.nextToken();
                suiMoveNormalizedType = new SuiMoveNormalizedType.Struct(jsonParser.readValueAs(SuiMoveNormalizedType.Struct.StructProperties.class));
            } else if ("Vector".equals(fieldName)) {
                jsonParser.nextToken();
                suiMoveNormalizedType = new SuiMoveNormalizedType.Vector(jsonParser.readValueAs(SuiMoveNormalizedType.class));
            } else if ("TypeParameter".equals(fieldName)) {
                jsonParser.nextToken();
                suiMoveNormalizedType = new SuiMoveNormalizedType.TypeParameter(jsonParser.getIntValue());
            } else if ("Reference".equals(fieldName)) {
                jsonParser.nextToken();
                suiMoveNormalizedType = new SuiMoveNormalizedType.Reference(jsonParser.readValueAs(SuiMoveNormalizedType.class));
            } else if ("MutableReference".equals(fieldName)) {
                jsonParser.nextToken();
                suiMoveNormalizedType = new SuiMoveNormalizedType.MutableReference(jsonParser.readValueAs(SuiMoveNormalizedType.class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiMoveNormalizedTypeDeserializer.deserialize() error.", jsonParser.currentToken(), SuiMoveNormalizedType.class);
            }
            jsonParser.nextToken();
            if (!JsonToken.END_OBJECT.equals(jsonParser.getCurrentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiMoveNormalizedTypeDeserializer.deserialize() error.", jsonParser.currentToken(), SuiMoveNormalizedType.class);
            }
            return suiMoveNormalizedType;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiMoveNormalizedTypeDeserializer.deserialize() error.", jsonParser.currentToken(), SuiMoveNormalizedType.class);
        }
        return null;
    }
}
