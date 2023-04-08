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
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", currentToken, SuiExecutionStatus.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", currentToken, SuiExecutionStatus.class);

        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            String status = null;
            String error = null;

            while (null != fieldName) {
                if ("status".equals(fieldName)) {
                    jsonParser.nextToken();
                    status = jsonParser.getValueAsString();
                } else if ("error".equals(fieldName)) {
                    jsonParser.nextToken();
                    error = jsonParser.getValueAsString();
                } else {
                    throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
            }
            if ("success".equals(status)) {
                return new SuiExecutionStatus.Success();
            } else if ("failure".equals(status)) {
                return new SuiExecutionStatus.Failure(error);
            }
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiExecutionStatusDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecutionStatus.class);
        }
        return null;
    }


}
