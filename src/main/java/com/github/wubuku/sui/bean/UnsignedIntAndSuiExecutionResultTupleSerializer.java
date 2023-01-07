package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class UnsignedIntAndSuiExecutionResultTupleSerializer extends JsonSerializer<UnsignedIntAndSuiExecutionResultTuple> {
    @Override
    public void serialize(UnsignedIntAndSuiExecutionResultTuple value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        gen.writeNumber(value.getUnsignedInt());
        gen.writeObject(value.getSuiExecutionResult());
        gen.writeEndArray();
    }
}
