package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;

/**
 * @param <D>         Details Type
 * @param <ID>        ObjectId type
 * @param <OBJ>       SuiObject type
 * @param <OBJ_REF>   SuiObjectRef type
 * @param <SUI_DATA>> SuiData type
 */
public abstract class GetObjectDataResponseDetailsDeserializer<
        D, ID extends D, OBJ extends D, OBJ_REF extends D, SUI_DATA> extends JsonDeserializer<D> {

    @Override
    public D deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            return newObjectId(jsonParser.getText());
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDetailsDeserializer.deserialize() error.",
                    currentToken, Object.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();
            /*
             * <pre>
             *    export type SuiObject = {
             *         data: SuiData;
             *         owner: ObjectOwner;
             *         previousTransaction: TransactionDigest;
             *         storageRebate: number;
             *         reference: SuiObjectRef;
             *     };
             * </pre>
             */
            SUI_DATA data = null;
            ObjectOwner owner = null;
            String previousTransaction = null;
            Long storageRebate = null;
            OBJ_REF reference = null;
            /*
             * <pre>
             * export type SuiObjectRef = {
             *     digest: TransactionDigest;
             *     objectId: string;
             *     version: number;
             * };
             * </pre>
             */
            String digest = null;
            String objectId = null;
            Long version = null;
            while (null != fieldName) {
                if ("data".equals(fieldName)) {
                    jsonParser.nextToken();
                    data = jsonParser.readValueAs(getSuiDataClass());
                } else if ("owner".equals(fieldName)) {
                    jsonParser.nextToken();
                    owner = jsonParser.readValueAs(ObjectOwner.class);
                } else if ("previousTransaction".equals(fieldName)) {
                    jsonParser.nextToken();
                    previousTransaction = jsonParser.getValueAsString();
                } else if ("storageRebate".equals(fieldName)) {
                    jsonParser.nextToken();
                    storageRebate = jsonParser.getLongValue();
                } else if ("reference".equals(fieldName)) {
                    jsonParser.nextToken();
                    reference = jsonParser.readValueAs(getSuiObjectRefClass());
                } else if ("digest".equals(fieldName)) {
                    jsonParser.nextToken();
                    digest = jsonParser.getValueAsString();
                } else if ("objectId".equals(fieldName)) {
                    jsonParser.nextToken();
                    objectId = jsonParser.getValueAsString();
                } else if ("version".equals(fieldName)) {
                    jsonParser.nextToken();
                    version = jsonParser.getLongValue();
                } else {
                    throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDetailsDeserializer.deserialize() error.",
                            jsonParser.currentToken(), Object.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDetailsDeserializer.deserialize() error.",
                        jsonParser.currentToken(), Object.class);
            }
            if (data != null) {
                return newSuiObject(data, owner, previousTransaction, storageRebate, reference);
            }
            if (digest != null) {
                return newSuiObjectRef(digest, objectId, version);
            }
            throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDetailsDeserializer.deserialize() error.",
                    jsonParser.currentToken(), Object.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "GetObjectDataResponseDetailsDeserializer.deserialize() error.",
                    jsonParser.currentToken(), Object.class);
        }
        return null;
    }

    protected abstract ID newObjectId(String text);

    protected abstract OBJ newSuiObject(SUI_DATA data,
                                        ObjectOwner owner,
                                        String previousTransaction,
                                        Long storageRebate,
                                        OBJ_REF reference);

    protected abstract OBJ_REF newSuiObjectRef(String digest, String objectId, Long version);

    protected abstract Class<OBJ_REF> getSuiObjectRefClass();

    protected abstract Class<SUI_DATA> getSuiDataClass();
}
