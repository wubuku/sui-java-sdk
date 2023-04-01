package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

public class SuiParsedDataDeserializer extends JsonDeserializer<SuiParsedData> {
    @Override
    public SuiParsedData deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {

        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", currentToken, SuiParsedData.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", currentToken, SuiParsedData.class);
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
            SuiDataType dataType = null;
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
                    dataType = jsonParser.readValueAs(SuiDataType.class);
                } else if ("type".equals(fieldName)) {
                    jsonParser.nextToken();
                    type = jsonParser.getValueAsString();
                } else if ("fields".equals(fieldName)) {
                    jsonParser.nextToken();
                    fields = jsonParser.readValueAs(ObjectContentFields.class);
                } else if ("hasPublicTransfer".equals(fieldName)) {
                    jsonParser.nextToken();
                    has_public_transfer = jsonParser.getBooleanValue();
                } else if ("disassembled".equals(fieldName)) {
                    jsonParser.nextToken();
                    disassembled = jsonParser.readValueAs(MovePackageContent.class);
                } else {
                    throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error. Unknown field name: " + fieldName, jsonParser.currentToken(), SuiParsedData.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiParsedData.class);
            }
            if (type != null) {
                return new SuiParsedData.MoveObject(type, fields, has_public_transfer, dataType);
            }
            if (disassembled != null) {
                return new SuiParsedData.Package(disassembled, dataType);
            }
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiParsedData.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiDataDeserializer.deserialize() error.", jsonParser.currentToken(), SuiParsedData.class);
        }
        return null;
    }
}
