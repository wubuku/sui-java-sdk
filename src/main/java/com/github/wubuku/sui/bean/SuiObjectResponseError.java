package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde(tag = "code", rename = "ObjectResponseError", rename_all = "camelCase")]
 * pub enum SuiObjectResponseError {
 *     #[error("Object {:?} does not exist.", object_id)]
 *     NotExists { object_id: ObjectID },
 *     #[error(
 *         "Object has been deleted object_id: {:?} at version: {:?} in digest {:?}",
 *         object_id,
 *         version,
 *         digest
 *     )]
 *     Deleted {
 *         object_id: ObjectID,
 *         /// Object version.
 *         version: SequenceNumber,
 *         /// Base64 string representing the object digest
 *         digest: ObjectDigest,
 *     },
 *     #[error("Unknown Error.")]
 *     Unknown,
 *     // TODO: also integrate SuiPastObjectResponse (VersionNotFound,  VersionTooHigh)
 * }
 * </pre>
 */
public class SuiObjectResponseError {
    //todo: implement
}
