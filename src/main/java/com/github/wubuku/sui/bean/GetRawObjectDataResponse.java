package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.math.BigInteger;

@JsonDeserialize(using = GetRawObjectDataResponseDeserializer.class)
public class GetRawObjectDataResponse extends AbstractGetObjectDataResponse<GetRawObjectDataResponse.Details> {
    public GetRawObjectDataResponse() {
    }

    public GetRawObjectDataResponse(ObjectStatus status, Details details) {
        super(status, details);
    }

    @Override
    public String toString() {
        return "GetObjectDataResponse{" +
                "status=" + getStatus() +
                ", details=" + getDetails() +
                '}';
    }

    @JsonDeserialize(using = DetailsDeserializer.class)
    public interface Details {
        class SuiObject extends com.github.wubuku.sui.bean.SuiRawObject implements Details {
            public SuiObject() {
            }

            public SuiObject(SuiRawData data, ObjectOwner owner,
                             String previousTransaction, Long storageRebate,
                             com.github.wubuku.sui.bean.SuiObjectRef reference) {
                super(data, owner, previousTransaction, storageRebate, reference);
            }
        }

        @JsonSerialize(using = ObjectIdSerializer.class)
        class ObjectId implements Details {
            private String id;

            public ObjectId() {
            }

            public ObjectId(String id) {
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

        class ObjectIdSerializer extends JsonSerializer<ObjectId> {
            @Override
            public void serialize(ObjectId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                gen.writeString(value.getId());
            }
        }

        class SuiObjectRef extends com.github.wubuku.sui.bean.SuiObjectRef implements Details {
            public SuiObjectRef() {
            }

            public SuiObjectRef(String digest, String objectId, BigInteger version) {
                super(digest, objectId, version);
            }
        }
    }

    public static class DetailsDeserializer extends GetObjectDataResponseDetailsDeserializer<
            Details, Details.ObjectId, Details.SuiObject, Details.SuiObjectRef, SuiRawData> {

        @Override
        protected Details.ObjectId newObjectId(String text) {
            return new Details.ObjectId(text);
        }

        @Override
        protected Details.SuiObject newSuiObject(SuiRawData data, ObjectOwner owner,
                                                 String previousTransaction,
                                                 Long storageRebate,
                                                 Details.SuiObjectRef reference) {
            return new Details.SuiObject(data, owner, previousTransaction, storageRebate, reference);
        }

        @Override
        protected Details.SuiObjectRef newSuiObjectRef(String digest, String objectId, BigInteger version) {
            return new Details.SuiObjectRef(digest, objectId, version);
        }

        @Override
        protected Class<Details.SuiObjectRef> getSuiObjectRefClass() {
            return Details.SuiObjectRef.class;
        }

        @Override
        protected Class<SuiRawData> getSuiDataClass() {
            return SuiRawData.class;
        }
    }
}
