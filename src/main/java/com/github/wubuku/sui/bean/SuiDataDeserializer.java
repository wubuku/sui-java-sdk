package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiDataDeserializer extends JsonDeserializer<SuiData> {
    @Override
    public SuiData deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {

        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", currentToken, SuiData.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", currentToken, SuiData.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            /*
             * <pre>
             * export type SuiData = { dataType: ObjectType } & (
             *   | SuiMoveObject
             *   | SuiMovePackage
             * );
             * </pre>
             */
            ObjectType dataType = null;
            /*
             * <pre>
             *     export type SuiMoveObject = {
             *         type: string;
             *         fields: ObjectContentFields;
             *         has_public_transfer?: boolean;
             *     };
             * </pre>
             */
            String type = null;
            ObjectContentFields fields = null;
            Boolean has_public_transfer = null;
            /*
             * <pre>
             *     export type SuiMovePackage = {
             *         disassembled: MovePackageContent;
             *     };
             * </pre>
             */
            MovePackageContent disassembled = null;
            while (null != fieldName) {
                if ("dataType".equals(fieldName)) {
                    jsonParser.nextToken();
                    dataType = jsonParser.readValueAs(ObjectType.class);
                } else if ("type".equals(fieldName)) {
                    jsonParser.nextToken();
                    type = jsonParser.getValueAsString();
                } else if ("fields".equals(fieldName)) {
                    jsonParser.nextToken();
                    fields = jsonParser.readValueAs(ObjectContentFields.class);
                } else if ("has_public_transfer".equals(fieldName)) {
                    jsonParser.nextToken();
                    has_public_transfer = jsonParser.getBooleanValue();
                } else if ("disassembled".equals(fieldName)) {
                    jsonParser.nextToken();
                    disassembled = jsonParser.readValueAs(MovePackageContent.class);
                } else {
                    throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiData.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiData.class);
            }
            if (type != null) {
                return new SuiData.SuiMoveObject(type, fields, has_public_transfer, dataType);
            }
            if (disassembled != null) {
                return new SuiData.SuiMovePackage(disassembled, dataType);
            }
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiData.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiData.class);
        }
        return null;
    }
}
