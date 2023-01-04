package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiExecuteTransactionResponseDeserializer extends JsonDeserializer<SuiExecuteTransactionResponse> {
    @Override
    public SuiExecuteTransactionResponse deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiExecuteTransactionResponseDeserializer.deserialize() error.", currentToken, SuiExecuteTransactionResponse.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiExecuteTransactionResponseDeserializer.deserialize() error.", currentToken, SuiExecuteTransactionResponse.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            SuiExecuteTransactionResponse SuiExecuteTransactionResponse;
            if ("ImmediateReturn".equals(fieldName)) {
                jsonParser.nextToken();
                SuiExecuteTransactionResponse = new SuiExecuteTransactionResponse.ImmediateReturn(jsonParser
                        .readValueAs(SuiExecuteTransactionResponse.ImmediateReturn.ImmediateReturnProperties.class));
            } else if ("TxCert".equals(fieldName)) {
                jsonParser.nextToken();
                SuiExecuteTransactionResponse = new SuiExecuteTransactionResponse.TxCert(jsonParser
                        .readValueAs(SuiExecuteTransactionResponse.TxCert.TxCertProperties.class));
            } else if ("EffectsCert".equals(fieldName)) {
                jsonParser.nextToken();
                SuiExecuteTransactionResponse = new SuiExecuteTransactionResponse.EffectsCert(jsonParser
                        .readValueAs(SuiExecuteTransactionResponse.EffectsCert.EffectsCertProperties.class));
            } else {
                throw new InvalidFormatException(jsonParser, "SuiExecuteTransactionResponseDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecuteTransactionResponse.class);
            }
            jsonParser.nextToken();
            return SuiExecuteTransactionResponse;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiExecuteTransactionResponseDeserializer.deserialize() error.", jsonParser.currentToken(), SuiExecuteTransactionResponse.class);
        }
        return null;
    }
}
