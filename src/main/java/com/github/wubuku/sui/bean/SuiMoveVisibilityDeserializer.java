package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiMoveVisibilityDeserializer extends JsonDeserializer<SuiMoveVisibility> {
    @Override
    public SuiMoveVisibility deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String code = jsonParser.getText();
            if ("Private".equals(code)) {
                return SuiMoveVisibility.PRIVATE;
            } else if ("Public".equals(code)) {
                return SuiMoveVisibility.PUBLIC;
            } else if ("Friend".equals(code)) {
                return SuiMoveVisibility.FRIEND;
            }
            throw new InvalidFormatException(jsonParser, "SuiMoveAbilityDeserializer.deserialize() error.", currentToken, SuiMoveAbility.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiMoveAbilityDeserializer.deserialize() error.", currentToken, SuiMoveAbility.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiMoveAbilityDeserializer.deserialize() error.", jsonParser.currentToken(), SuiMoveAbility.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiMoveAbilityDeserializer.deserialize() error.", jsonParser.currentToken(), SuiMoveAbility.class);
        }
        return null;
    }
}
