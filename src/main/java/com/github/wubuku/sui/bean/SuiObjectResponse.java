package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema, Clone, PartialEq, Eq)]
 * pub struct SuiObjectResponse {
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub data: Option<SuiObjectData>,
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub error: Option<SuiObjectResponseError>,
 * }
 * </pre>
 */
public class SuiObjectResponse extends AbstractSuiObjectResponse<SuiObjectData<SuiParsedData>> {

    @Override
    public String toString() {
        return "SuiObjectResponse{" +
                "data=" + data +
                ", error=" + error +
                '}';
    }
}
