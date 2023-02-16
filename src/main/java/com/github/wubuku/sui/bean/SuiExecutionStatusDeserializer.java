package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiExecutionStatusDeserializer extends JsonDeserializer<SuiExecutionStatus> {

    @Override
    public SuiExecutionStatus deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String text = jsonParser.getText();
            if ("success".equals(text)) {
                return SuiExecutionStatus.Success.INSTANCE;
            }
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", currentToken, SuiExecutionStatus.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", currentToken, SuiExecutionStatus.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiExecutionStatus suiExecutionStatus;
            if ("failure".equals(fieldName)) {
                jsonParser.nextToken();
                suiExecutionStatus = new SuiExecutionStatus.Failure(jsonParser.readValueAs(SuiExecutionStatus.Failure.FailureProperties.class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
            }
            jsonParser.nextToken();
            if (!JsonToken.END_OBJECT.equals(jsonParser.getCurrentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
            }
            return suiExecutionStatus;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
        }
        return null;
    }


}
