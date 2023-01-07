package com.github.wubuku.sui.bean;

public class GetObjectDataResponseDeserializer extends AbstractGetObjectDataResponseDeserializer<GetObjectDataResponse,
        GetObjectDataResponse.Details> {


    @Override
    protected Class<GetObjectDataResponse> getObjectDataResponseClass() {
        return GetObjectDataResponse.class;
    }

    @Override
    protected Class<GetObjectDataResponse.Details> getObjectDataResponseDetailsClass() {
        return GetObjectDataResponse.Details.class;
    }

    @Override
    protected GetObjectDataResponse newGetObjectDataResponse(ObjectStatus objectStatus,
                                                             GetObjectDataResponse.Details details) {
        return new GetObjectDataResponse(objectStatus, details);
    }
}
