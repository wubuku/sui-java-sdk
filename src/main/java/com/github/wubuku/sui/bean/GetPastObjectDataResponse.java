package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema, Clone)]
 * #[serde(tag = "status", content = "details", rename = "ObjectRead")]
 * pub enum SuiPastObjectRead<T: SuiData> {
 *     /// The object exists and is found with this version
 *     VersionFound(SuiObject<T>),
 *     /// The object does not exist
 *     ObjectNotExists(ObjectID),
 *     /// The object is found to be deleted with this version
 *     ObjectDeleted(SuiObjectRef),
 *     /// The object exists but not found with this version
 *     VersionNotFound(ObjectID, SequenceNumber),
 *     /// The asked object version is higher than the latest
 *     VersionTooHigh {
 *         object_id: ObjectID,
 *         asked_version: SequenceNumber,
 *         latest_version: SequenceNumber,
 *     },
 * }
 * </pre>
 */
@JsonDeserialize(using = GetPastObjectDataResponseDeserializer.class)
public class GetPastObjectDataResponse {
    private SuiPastObjectReadStatus status;
    private Details details;

    public GetPastObjectDataResponse() {
    }

    public GetPastObjectDataResponse(SuiPastObjectReadStatus status, Details details) {
        this.status = status;
        this.details = details;
    }

    public SuiPastObjectReadStatus getStatus() {
        return status;
    }

    public void setStatus(SuiPastObjectReadStatus status) {
        this.status = status;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "SuiPastObjectRead{" +
                "status=" + status +
                ", details=" + details +
                '}';
    }

    @JsonDeserialize(using = DetailsDeserializer.class)
    public interface Details {
        class VersionFound extends SuiObject implements Details {
            public VersionFound() {
            }

            public VersionFound(SuiParsedData data, ObjectOwner owner,
                                String previousTransaction, Long storageRebate,
                                SuiObjectRef reference) {
                super(data, owner, previousTransaction, storageRebate, reference);
            }
        }

        @JsonSerialize(using = ObjectNotExistsSerializer.class)
        class ObjectNotExists implements Details {
            private String id;

            public ObjectNotExists() {
            }

            public ObjectNotExists(String id) {
                this.id = id;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "ObjectId{" +
                        "id='" + id + '\'' +
                        '}';
            }
        }

        class ObjectNotExistsSerializer extends JsonSerializer<ObjectNotExists> {
            @Override
            public void serialize(ObjectNotExists value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString(value.getId());
            }
        }

        class ObjectDeleted extends SuiObjectRef implements Details {
            public ObjectDeleted() {
            }

            public ObjectDeleted(String digest, String objectId, BigInteger version) {
                super(digest, objectId, version);
            }


        }

        @JsonSerialize(using = VersionNotFoundSerializer.class)
        class VersionNotFound implements Details {
            private List<Object> objectIdAndSequenceNumber;

            public VersionNotFound() {
            }

            public VersionNotFound(List<Object> objectIdAndSequenceNumber) {
                this.objectIdAndSequenceNumber = objectIdAndSequenceNumber;
            }

            public List<Object> getObjectIdAndSequenceNumber() {
                return objectIdAndSequenceNumber;
            }

            public void setObjectIdAndSequenceNumber(List<Object> objectIdAndSequenceNumber) {
                this.objectIdAndSequenceNumber = objectIdAndSequenceNumber;
            }

            @Override
            public String toString() {
                return "VersionNotFound{" +
                        "objectIdAndSequenceNumber=" + objectIdAndSequenceNumber +
                        '}';
            }
        }

        class VersionNotFoundSerializer extends JsonSerializer<VersionNotFound> {
            @Override
            public void serialize(VersionNotFound value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeStartArray();
                for (Object o : value.getObjectIdAndSequenceNumber()) {
                    gen.writeObject(o);
                }
                gen.writeEndArray();
            }
        }

        class VersionTooHigh implements Details {
            @JsonProperty("object_id")
            private String objectId;
            @JsonProperty("asked_version")
            private Long askedVersion;
            @JsonProperty("latest_version")
            private Long latestVersion;

            public VersionTooHigh() {
            }

            public VersionTooHigh(String objectId, Long askedVersion, Long latestVersion) {
                this.objectId = objectId;
                this.askedVersion = askedVersion;
                this.latestVersion = latestVersion;
            }

            public String getObjectId() {
                return objectId;
            }

            public void setObjectId(String objectId) {
                this.objectId = objectId;
            }

            public Long getAskedVersion() {
                return askedVersion;
            }

            public void setAskedVersion(Long askedVersion) {
                this.askedVersion = askedVersion;
            }

            public Long getLatestVersion() {
                return latestVersion;
            }

            public void setLatestVersion(Long latestVersion) {
                this.latestVersion = latestVersion;
            }

            @Override
            public String toString() {
                return "VersionTooHigh{" +
                        "objectId='" + objectId + '\'' +
                        ", askedVersion=" + askedVersion +
                        ", latestVersion=" + latestVersion +
                        '}';
            }
        }
    }

    public static class DetailsDeserializer extends JsonDeserializer<GetPastObjectDataResponse.Details> {

        @Override
        public GetPastObjectDataResponse.Details deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (JsonToken.VALUE_STRING.equals(currentToken)) {
                return new GetPastObjectDataResponse.Details.ObjectNotExists(jsonParser.getText());
            } else if (JsonToken.VALUE_NULL.equals(currentToken)) {
                return null;
            } else if (currentToken.isScalarValue()) {
                throw new InvalidFormatException(jsonParser, "GetPastObjectDataResponse.DetailsDeserializer.deserialize() error.", currentToken, GetPastObjectDataResponse.Details.class);
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
                SuiParsedData data = null;
                ObjectOwner owner = null;
                String previousTransaction = null;
                Long storageRebate = null;
                SuiObjectRef reference = null;
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
                BigInteger version = null;
                /*
                 *     VersionTooHigh {
                 *         object_id: ObjectID,
                 *         asked_version: SequenceNumber,
                 *         latest_version: SequenceNumber,
                 *     },
                 */
                String versionTooHighObjectId = null;
                Long versionTooHighAskedVersion = null;
                Long versionTooHighLatestVersion = null;
                while (null != fieldName) {
                    if ("data".equals(fieldName)) {
                        jsonParser.nextToken();
                        data = jsonParser.readValueAs(SuiParsedData.class);
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
                        reference = jsonParser.readValueAs(SuiObjectRef.class);
                    } else if ("digest".equals(fieldName)) {
                        jsonParser.nextToken();
                        digest = jsonParser.getValueAsString();
                    } else if ("objectId".equals(fieldName)) {
                        jsonParser.nextToken();
                        objectId = jsonParser.getValueAsString();
                    } else if ("version".equals(fieldName)) {
                        jsonParser.nextToken();
                        version = jsonParser.getBigIntegerValue();
                    } else if ("object_id".equals(fieldName)) {
                        jsonParser.nextToken();
                        versionTooHighObjectId = jsonParser.getValueAsString();
                    } else if ("asked_version".equals(fieldName)) {
                        jsonParser.nextToken();
                        versionTooHighAskedVersion = jsonParser.getLongValue();
                    } else if ("latest_version".equals(fieldName)) {
                        jsonParser.nextToken();
                        versionTooHighLatestVersion = jsonParser.getLongValue();
                    } else {
                        throw new InvalidFormatException(jsonParser, "GetPastObjectDataResponse.DetailsDeserializer.deserialize() error.", jsonParser.currentToken(), GetPastObjectDataResponse.Details.class);
                    }
                    fieldName = jsonParser.nextFieldName();
                }
                if (!JsonToken.END_OBJECT.equals(jsonParser.currentToken())) {
                    throw new InvalidFormatException(jsonParser, "GetPastObjectDataResponse.DetailsDeserializer.deserialize() error.", jsonParser.currentToken(), Details.class);
                }
                if (data != null) {
                    return new Details.VersionFound(data, owner, previousTransaction, storageRebate, reference);
                }
                if (digest != null) {
                    return new Details.ObjectDeleted(digest, objectId, version);
                }
                if (versionTooHighAskedVersion != null) {
                    return new Details.VersionTooHigh(versionTooHighObjectId, versionTooHighAskedVersion, versionTooHighLatestVersion);
                }
                throw new InvalidFormatException(jsonParser, "GetPastObjectDataResponse.DetailsDeserializer.deserialize() error.", jsonParser.currentToken(), Details.class);
            } else if (JsonToken.START_ARRAY.equals(currentToken)) {
                return new Details.VersionNotFound(jsonParser.readValueAs(new TypeReference<List<Object>>() {
                }));
                //throw new InvalidFormatException(jsonParser, "GetPastObjectDataResponse.DetailsDeserializer.deserialize() error.", jsonParser.currentToken(), Details.class);
            }
            return null;
        }
    }
}
