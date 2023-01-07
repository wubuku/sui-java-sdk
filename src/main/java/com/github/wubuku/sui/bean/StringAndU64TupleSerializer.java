package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class StringAndU64TupleSerializer extends JsonSerializer<StringAndU64Tuple> {
    @Override
    public void serialize(StringAndU64Tuple value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        gen.writeString(value.getItem1());
        gen.writeNumber(value.getItem2());
        gen.writeEndArray();
    }
}
