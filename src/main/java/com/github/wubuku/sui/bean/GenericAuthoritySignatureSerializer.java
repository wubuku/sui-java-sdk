package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenericAuthoritySignatureSerializer extends JsonSerializer<GenericAuthoritySignature> {
    @Override
    public void serialize(GenericAuthoritySignature value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value instanceof GenericAuthoritySignature.AuthoritySignature) {
            gen.writeString(((GenericAuthoritySignature.AuthoritySignature) value).getSignature());
        } else if (value instanceof GenericAuthoritySignature.AuthoritySignatureArray) {
            gen.writeStartArray();
            for (String s : ((GenericAuthoritySignature.AuthoritySignatureArray) value).getSignatures()) {
                gen.writeString(s);
            }
            gen.writeEndArray();
        }
    }
}
