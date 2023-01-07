package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

/**
 * @param <T> GetObjectDataResponse type
 * @param <D> GetObjectDataResponse.Details type
 */
public abstract class AbstractGetObjectDataResponseDeserializer<T, D> extends JsonDeserializer<T> {
    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        ObjectStatus objectStatus = null;
        D details = null;
        if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            while (null != fieldName) {
                if ("status".equals(fieldName)) {
                    jsonParser.nextToken();
                    objectStatus = jsonParser.readValueAs(ObjectStatus.class);
                } else if ("details".equals(fieldName)) {
                    jsonParser.nextToken();
                    details = jsonParser.readValueAs(getObjectDataResponseDetailsClass());
                } else {
                    throw new InvalidFormatException(jsonParser, "AbstractGetObjectDataResponseDeserializer.deserialize() error.",
                            jsonParser.currentToken(), getObjectDataResponseClass());
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "AbstractGetObjectDataResponseDeserializer.deserialize() error.",
                        jsonParser.currentToken(), getObjectDataResponseClass());
            }
        }
        if (null == objectStatus || null == details) {
            throw new InvalidFormatException(jsonParser, "AbstractGetObjectDataResponseDeserializer.deserialize() error.",
                    jsonParser.currentToken(), getObjectDataResponseClass());
        }
        return newGetObjectDataResponse(objectStatus, details);
    }

    protected abstract Class<T> getObjectDataResponseClass();

    protected abstract Class<D> getObjectDataResponseDetailsClass();

    protected abstract T newGetObjectDataResponse(ObjectStatus objectStatus, D details);

}
