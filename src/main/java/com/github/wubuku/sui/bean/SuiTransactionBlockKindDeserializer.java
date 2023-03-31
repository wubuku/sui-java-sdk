package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigInteger;

public class SuiTransactionBlockKindDeserializer extends JsonDeserializer<SuiTransactionBlockKind> {
    @Override
    public SuiTransactionBlockKind deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {

        JsonToken currentToken = jsonParser.getCurrentToken();
        if (JsonToken.VALUE_STRING.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", currentToken, SuiCallArg.class);
        } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
            return null;
        } else if (currentToken.isScalarValue()) {
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", currentToken, SuiCallArg.class);
        } else if (JsonToken.START_OBJECT.equals(currentToken)) {
            String fieldName = jsonParser.nextFieldName();

            String kind = null;
            // ChangeEpoch /////////////////////////
            BigInteger epoch = null;
            Long storageCharge = null;
            Long computationCharge = null;
            Long storageRebate = null;
            Long epochStartTimestampMS = null;

            // Genesis ///////////////////////
            String[] objects = null;

            // ConsensusCommitPrologue ///////
            //BigInteger epoch = null;
            BigInteger round = null;
            BigInteger commitTimestampMS = null;

            // ProgrammableTransaction ///////
            SuiCallArg[] inputs = null;
            Object[] transactions = null;

            while (null != fieldName) {
                if ("kind".equals(fieldName)) {
                    jsonParser.nextToken();
                    kind = jsonParser.getValueAsString();
                } else if ("epoch".equals(fieldName)) {
                    jsonParser.nextToken();
                    epoch = jsonParser.getBigIntegerValue();
                } else if ("storageCharge".equals(fieldName)) {
                    jsonParser.nextToken();
                    storageCharge = jsonParser.getLongValue();
                } else if ("computationCharge".equals(fieldName)) {
                    jsonParser.nextToken();
                    computationCharge = jsonParser.getLongValue();
                } else if ("storageRebate".equals(fieldName)) {
                    jsonParser.nextToken();
                    storageRebate = jsonParser.getLongValue();
                } else if ("epochStartTimestampMS".equals(fieldName)) {
                    jsonParser.nextToken();
                    epochStartTimestampMS = jsonParser.getLongValue();
                } else if ("objects".equals(fieldName)) {
                    jsonParser.nextToken();
                    objects = jsonParser.readValueAs(String[].class);
                } else if ("round".equals(fieldName)) {
                    jsonParser.nextToken();
                    round = jsonParser.getBigIntegerValue();
                } else if ("commitTimestampMS".equals(fieldName)) {
                    jsonParser.nextToken();
                    commitTimestampMS = jsonParser.getBigIntegerValue();
                } else if ("inputs".equals(fieldName)) {
                    jsonParser.nextToken();
                    inputs = jsonParser.readValueAs(SuiCallArg[].class);
                } else if ("transactions".equals(fieldName)) {
                    jsonParser.nextToken();
                    transactions = jsonParser.readValueAs(Object[].class);
                } else {
                    throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
                }
                fieldName = jsonParser.nextFieldName();
            }
            if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
            }
            if ("ChangeEpoch".equals(kind)) {
                return new SuiTransactionBlockKind.ChangeEpoch(epoch, storageCharge, computationCharge, storageRebate, epochStartTimestampMS);
            } else if ("Genesis".equals(kind)) {
                return new SuiTransactionBlockKind.Genesis(objects);
            } else if ("ConsensusCommitPrologue".equals(kind)) {
                return new SuiTransactionBlockKind.ConsensusCommitPrologue(epoch, round, commitTimestampMS);
            } else if ("ProgrammableTransaction".equals(kind)) {
                return new SuiTransactionBlockKind.ProgrammableTransaction(inputs, transactions);
            }
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
        } else if (JsonToken.START_ARRAY.equals(currentToken)) {
            throw new InvalidFormatException(jsonParser, "SuiCallArgDeserializer.deserialize() error.", jsonParser.currentToken(), SuiCallArg.class);
        }
        return null;
    }
}
