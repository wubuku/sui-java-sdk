package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class UnsignedIntAndSuiExecutionResultTupleDeserializer extends JsonDeserializer<UnsignedIntAndSuiExecutionResultTuple> {
    @Override
    public UnsignedIntAndSuiExecutionResultTuple deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.START_ARRAY.equals(currentToken)) {
            jsonParser.nextToken();
            Long uint = jsonParser.getLongValue();
            jsonParser.nextToken();
            SuiExecutionResult suiExecutionResult = jsonParser.readValueAs(SuiExecutionResult.class);
            jsonParser.nextToken();
            if (!JsonToken.END_ARRAY.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "UsizeAndSuiExecutionResultTupleDeserializer.deserialize() error.",
                        jsonParser.currentToken(), UnsignedIntAndSuiExecutionResultTuple.class);
            }
            return new UnsignedIntAndSuiExecutionResultTuple(uint, suiExecutionResult);
        } else {
            throw new InvalidFormatException(jsonParser, "UsizeAndSuiExecutionResultTupleDeserializer.deserialize() error.",
                    jsonParser.currentToken(), UnsignedIntAndSuiExecutionResultTuple.class);
        }
    }
}
