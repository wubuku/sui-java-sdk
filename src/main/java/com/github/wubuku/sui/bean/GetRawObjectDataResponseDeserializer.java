package com.github.wubuku.sui.bean;

public class GetRawObjectDataResponseDeserializer extends AbstractGetObjectDataResponseDeserializer<
        GetRawObjectDataResponse,
        GetRawObjectDataResponse.Details> {
    @Override
    protected Class<GetRawObjectDataResponse> getObjectDataResponseClass() {
        return GetRawObjectDataResponse.class;
    }

    @Override
    protected Class<GetRawObjectDataResponse.Details> getObjectDataResponseDetailsClass() {
        return GetRawObjectDataResponse.Details.class;
    }

    @Override
    protected GetRawObjectDataResponse newGetObjectDataResponse(ObjectStatus objectStatus, GetRawObjectDataResponse.Details details) {
        return new GetRawObjectDataResponse(objectStatus, details);
    }
}
