package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type GetObjectDataResponse = {
 *   status: ObjectStatus;
 *   details: SuiObject | ObjectId | SuiObjectRef;
 * };
 * </pre>
 */
public class GetObjectDataResponse {
    private ObjectStatus status;
    private Details details;

    public GetObjectDataResponse() {
    }

    public GetObjectDataResponse(ObjectStatus status, Details details) {
        this.status = status;
        this.details = details;
    }

    public ObjectStatus getStatus() {
        return status;
    }

    public void setStatus(ObjectStatus status) {
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
        return "GetObjectDataResponse{" +
                "status=" + status +
                ", details=" + details +
                '}';
    }

    @JsonDeserialize(using = DetailsDeserializer.class)
    public interface Details {
        class SuiObject extends com.github.wubuku.sui.bean.SuiObject implements Details {
            public SuiObject() {
            }

            public SuiObject(SuiData data, ObjectOwner owner,
                             String previousTransaction, Long storageRebate,
                             com.github.wubuku.sui.bean.SuiObjectRef reference) {
                super(data, owner, previousTransaction, storageRebate, reference);
            }
        }

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

        class SuiObjectRef extends com.github.wubuku.sui.bean.SuiObjectRef implements Details {
            public SuiObjectRef() {
            }

            public SuiObjectRef(String digest, String objectId, Long version) {
                super(digest, objectId, version);
            }
        }
    }

    public static class DetailsDeserializer extends JsonDeserializer<Details> {
        @Override
        public Details deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return null;//todo
        }
    }
}
