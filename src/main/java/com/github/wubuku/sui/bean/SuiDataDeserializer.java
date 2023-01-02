package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SuiDataDeserializer extends JsonDeserializer<SuiData> {
    @Override
    public SuiData deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return null;//todo
    }
}
