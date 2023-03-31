package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class ObjectChangeDeserializer extends JsonDeserializer<ObjectChange> {
    @Override
    public ObjectChange deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        ObjectChange o = jsonParser.readValueAs(ObjectChange.TempObjectChange.class);
        if ("published".equals(o.getType())) {
            return new ObjectChange.Published(o.packageId, o.version, o.digest, o.modules);
        } else if ("transferred".equals(o.getType())) {
            return new ObjectChange.Transferred(o.sender, o.recipient, o.objectType, o.objectId, o.version, o.digest);
        } else if ("mutated".equals(o.getType())) {
            return new ObjectChange.Mutated(o.sender, o.owner, o.objectType, o.objectId, o.version, o.previousVersion, o.digest);
        } else if ("deleted".equals(o.getType())) {
            return new ObjectChange.Deleted(o.sender, o.objectType, o.objectId, o.version);
        } else if ("wrapped".equals(o.getType())) {
            return new ObjectChange.Wrapped(o.sender, o.objectType, o.objectId, o.version);
        } else if ("created".equals(o.getType())) {
            return new ObjectChange.Created(o.sender, o.owner, o.objectType, o.objectId, o.version, o.digest);
        }

        throw new InvalidFormatException(jsonParser, "ObjectChangeDeserializer.deserialize() error.", jsonParser.currentToken(), ObjectChange.class);

    }
}
