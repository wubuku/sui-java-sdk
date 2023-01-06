package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class GetObjectDataResponseDeserializer extends JsonDeserializer<GetObjectDataResponse> {
    @Override
    public GetObjectDataResponse deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        ObjectStatus objectStatus = null;
        GetObjectDataResponse.Details details = null;
        if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            while (null != fieldName) {
                if ("status".equals(fieldName)) {
                    jsonParser.nextToken();
                    objectStatus = jsonParser.readValueAs(ObjectStatus.class);
                } else if ("details".equals(fieldName)) {
                    jsonParser.nextToken();
                    details = jsonParser.readValueAs(GetObjectDataResponse.Details.class);
                } else {
                    throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDeserializer.deserialize() error.", jsonParser.currentToken(), GetObjectDataResponse.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDeserializer.deserialize() error.", jsonParser.currentToken(), GetObjectDataResponse.class);
            }
        }
        if (null == objectStatus || null == details) {
            throw new InvalidFormatException(jsonParser, "GetObjectDataResponse.DetailsDeserializer.deserialize() error.", jsonParser.currentToken(), GetObjectDataResponse.Details.class);
        }
        return new GetObjectDataResponse(objectStatus, details);
    }

}
