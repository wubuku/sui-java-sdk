package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class GetPastObjectDataResponseDeserializer extends JsonDeserializer<GetPastObjectDataResponse> {
    @Override
    public GetPastObjectDataResponse deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        SuiPastObjectReadStatus objectStatus = null;
        GetPastObjectDataResponse.Details details = null;
        if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            while (null != fieldName) {
                if ("status".equals(fieldName)) {
                    jsonParser.nextToken();
                    objectStatus = jsonParser.readValueAs(SuiPastObjectReadStatus.class);
                } else if ("details".equals(fieldName)) {
                    jsonParser.nextToken();
                    details = jsonParser.readValueAs(GetPastObjectDataResponse.Details.class);
                } else {
                    throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDeserializer.deserialize() error.", jsonParser.currentToken(), GetPastObjectDataResponse.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDeserializer.deserialize() error.", jsonParser.currentToken(), GetPastObjectDataResponse.class);
            }
        }
        if (null == objectStatus || null == details) {
            throw new InvalidFormatException(jsonParser, "GetPastObjectDataResponse.DetailsDeserializer.deserialize() error.", jsonParser.currentToken(), GetPastObjectDataResponse.Details.class);
        }
        return new GetPastObjectDataResponse(objectStatus, details);
    }
}
