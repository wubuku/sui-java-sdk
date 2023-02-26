//package com.github.wubuku.sui.bean;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonToken;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//
//import java.io.IOException;
//
//public class ExecutionStatusTypeDeserializer extends JsonDeserializer<ExecutionStatusType> {
//    @Override
//    public ExecutionStatusType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        JsonToken currentToken = jsonParser.getCurrentToken();
//        if (JsonToken.VALUE_STRING.equals(currentToken)) {
//            String code = jsonParser.getText();
//            if ("success".equals(code)) {
//                return ExecutionStatusType.SUCCESS;
//            } else if ("failure".equals(code)) {
//                return ExecutionStatusType.FAILURE;
//            }
//            throw new InvalidFormatException(jsonParser, "ExecutionStatusTypeDeserializer.deserialize() error.", currentToken, ExecutionStatusType.class);
//        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
//            return null;
//        } else if (currentToken.isScalarValue()) {
//            throw new InvalidFormatException(jsonParser, "ExecutionStatusTypeDeserializer.deserialize() error.", currentToken, ExecutionStatusType.class);
//        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
//            throw new InvalidFormatException(jsonParser, "ExecutionStatusTypeDeserializer.deserialize() error.", jsonParser.currentToken(), ExecutionStatusType.class);
//        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
//            throw new InvalidFormatException(jsonParser, "ExecutionStatusTypeDeserializer.deserialize() error.", jsonParser.currentToken(), ExecutionStatusType.class);
//        }
//        return null;
//    }
//
//}