package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigInteger;

public class StringAndU64TupleDeserializer extends JsonDeserializer<StringAndU64Tuple> {
    @Override
    public StringAndU64Tuple deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.START_ARRAY.equals(currentToken)) {
            jsonParser.nextToken();
            String str = jsonParser.getText();
            jsonParser.nextToken();
            BigInteger uint = jsonParser.readValueAs(BigInteger.class);
            jsonParser.nextToken();
            if (!JsonToken.END_ARRAY.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "StringAndU64TupleDeserializer.deserialize() error.",
                        jsonParser.currentToken(), StringAndU64Tuple.class);
            }
            return new StringAndU64Tuple(str, uint);
        } else {
            throw new InvalidFormatException(jsonParser, "StringAndU64TupleDeserializer.deserialize() error.",
                    jsonParser.currentToken(), StringAndU64Tuple.class);
        }
    }
}
