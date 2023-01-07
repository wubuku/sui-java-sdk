package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SuiJsonValueSerializer extends JsonSerializer<SuiJsonValue> {
    @Override
    public void serialize(SuiJsonValue value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value instanceof SuiJsonValue.String_) {
            gen.writeString(((SuiJsonValue.String_) value).getValue());
        } else if (value instanceof SuiJsonValue.Number) {
            gen.writeNumber(((SuiJsonValue.Number) value).getValue());
        } else if (value instanceof SuiJsonValue.U64) {
            gen.writeString(((SuiJsonValue.U64) value).getValue().toString());
        } else if (value instanceof SuiJsonValue.Boolean_) {
            gen.writeBoolean(((SuiJsonValue.Boolean_) value).getValue());
        } else if (value instanceof SuiJsonValue.Array) {
            gen.writeStartArray();
            for (SuiJsonValue v : ((SuiJsonValue.Array) value).getValues()) {
                serialize(v, gen, serializers);
            }
            gen.writeEndArray();
        }
    }
}
