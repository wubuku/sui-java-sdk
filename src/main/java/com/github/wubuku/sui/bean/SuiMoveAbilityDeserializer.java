package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiMoveAbilityDeserializer extends JsonDeserializer<SuiMoveAbility> {
    @Override
    public SuiMoveAbility deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String code = jsonParser.getText();
            if ("Copy".equals(code)) {
                return SuiMoveAbility.COPY;
            } else if ("Drop".equals(code)) {
                return SuiMoveAbility.DROP;
            } else if ("Store".equals(code)) {
                return SuiMoveAbility.STORE;
            } else if ("Key".equals(code)) {
                return SuiMoveAbility.KEY;
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
