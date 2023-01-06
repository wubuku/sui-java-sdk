package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class ObjectOwnerDeserializer extends JsonDeserializer<ObjectOwner> {
    @Override
    public ObjectOwner deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            String text = jsonParser.getText();
            if ("Immutable".equals(text)) {
                return ObjectOwner.Immutable.INSTANCE;
            }
            throw new InvalidFormatException(jsonParser, "ObjectOwnerDeserializer.deserialize() error.", currentToken, ObjectOwner.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "ObjectOwnerDeserializer.deserialize() error.", currentToken, ObjectOwner.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            ObjectOwner objectOwner;
            if ("AddressOwner".equals(fieldName)) {
                jsonParser.nextToken();
                objectOwner = new ObjectOwner.AddressOwner(jsonParser.getValueAsString());
            } else if ("ObjectOwner".equals(fieldName)) {
                jsonParser.nextToken();
                objectOwner = new ObjectOwner.ObjectOwner_(jsonParser.getValueAsString());
            } else if ("Shared".equals(fieldName)) {
                jsonParser.nextToken();
                objectOwner = new ObjectOwner.Shared(jsonParser.readValueAs(ObjectOwner.Shared.SharedProperties.class));
            } else {
                throw new InvalidFormatException(jsonParser, "ObjectOwnerDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectOwner.class);
            }
            jsonParser.nextToken();
            if (!JsonToken.END_OBJECT.equals(jsonParser.getCurrentToken())) {
                throw new InvalidFormatException(jsonParser, "ObjectOwnerDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectOwner.class);
            }
            return objectOwner;
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "ObjectOwnerDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectOwner.class);
        }
        return null;
    }
}
