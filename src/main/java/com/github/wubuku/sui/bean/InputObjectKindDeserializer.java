package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class InputObjectKindDeserializer extends JsonDeserializer<InputObjectKind> {
    @Override
    public InputObjectKind deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "InputObjectKindDeserializer.deserialize() error.", currentToken, InputObjectKind.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "InputObjectKindDeserializer.deserialize() error.", currentToken, InputObjectKind.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            InputObjectKind InputObjectKind;
            if ("MovePackage".equals(fieldName)) {
                jsonParser.nextToken();
                InputObjectKind = new InputObjectKind.MovePackage(jsonParser.getValueAsString());
            } else if ("ImmOrOwnedMoveObject".equals(fieldName)) {
                jsonParser.nextToken();
                InputObjectKind = new InputObjectKind.ImmOrOwnedMoveObject(jsonParser.readValueAs(SuiObjectRef.class));
            } else if ("SharedMoveObject".equals(fieldName)) {
                jsonParser.nextToken();
                InputObjectKind = new InputObjectKind.SharedMoveObject(jsonParser.readValueAs(InputObjectKind.SharedMoveObject.SharedMoveObjectProperties.class));
            } else {
                throw new InvalidFormatException(jsonParser, "InputObjectKindDeserializer.deserialize() error.", jsonParser.currentToken(), InputObjectKind.class);
            }
            jsonParser.nextToken();
            return InputObjectKind;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "InputObjectKindDeserializer.deserialize() error.", jsonParser.currentToken(), InputObjectKind.class);
        }
        return null;
    }
}
