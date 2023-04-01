package com.github.wubuku.sui.bean;

import java.math.BigInteger;
import java.util.Map;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[serde_as]
 * #[derive(Debug, Clone, Deserialize, Serialize, JsonSchema, Eq, PartialEq)]
 * #[serde(rename_all = "camelCase", rename = "ObjectData")]
 * pub struct SuiObjectData {
 *     pub object_id: ObjectID,
 *     /// Object version.
 *     pub version: SequenceNumber,
 *     /// Base64 string representing the object digest
 *     pub digest: ObjectDigest,
 *     /// The type of the object. Default to be None unless SuiObjectDataOptions.showType is set to true
 *     #[schemars(with = "Option<String>")]
 *     #[serde_as(as = "Option<DisplayFromStr>")]
 *     #[serde(rename = "type", skip_serializing_if = "Option::is_none")]
 *     pub type_: Option<ObjectType>,
 *     // Default to be None because otherwise it will be repeated for the getOwnedObjects endpoint
 *     /// The owner of this object. Default to be None unless SuiObjectDataOptions.showOwner is set to true
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub owner: Option<Owner>,
 *     /// The digest of the transaction that created or last mutated this object. Default to be None unless
 *     /// SuiObjectDataOptions.showPreviousTransaction is set to true
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub previous_transaction: Option<TransactionDigest>,
 *     /// The amount of SUI we would rebate if this object gets deleted.
 *     /// This number is re-calculated each time the object is mutated based on
 *     /// the present storage gas price.
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub storage_rebate: Option<u64>,
 *     /// The Display metadata for frontend UI rendering, default to be None unless SuiObjectDataOptions.showContent is set to true
 *     /// This can also be None if the struct type does not have Display defined
 *     /// See more details in <https://forums.sui.io/t/nft-object-display-proposal/4872>
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub display: Option<BTreeMap<String, String>>,
 *     /// Move object content or package content, default to be None unless SuiObjectDataOptions.showContent is set to true
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub content: Option<SuiParsedData>,
 *     /// Move object content or package content in BCS, default to be None unless SuiObjectDataOptions.showBcs is set to true
 *     #[serde(skip_serializing_if = "Option::is_none")]
 *     pub bcs: Option<SuiRawData>,
 * }
 * </pre>
 */
public class SuiObjectData <C> {
    private String objectId;
    private BigInteger version;
    private String digest;
    private String type;
    private ObjectOwner owner;
    private String previousTransaction;
    private Long storageRebate;
    private Map<String, String> display;
    private C content;
    private SuiRawData bcs;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObjectOwner getOwner() {
        return owner;
    }

    public void setOwner(ObjectOwner owner) {
        this.owner = owner;
    }

    public String getPreviousTransaction() {
        return previousTransaction;
    }

    public void setPreviousTransaction(String previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    public Long getStorageRebate() {
        return storageRebate;
    }

    public void setStorageRebate(Long storageRebate) {
        this.storageRebate = storageRebate;
    }

    public Map<String, String> getDisplay() {
        return display;
    }

    public void setDisplay(Map<String, String> display) {
        this.display = display;
    }

    public C getContent() {
        return content;
    }

    public void setContent(C content) {
        this.content = content;
    }

    public SuiRawData getBcs() {
        return bcs;
    }

    public void setBcs(SuiRawData bcs) {
        this.bcs = bcs;
    }

    @Override
    public String toString() {
        return "SuiObjectData{" +
                "objectId='" + objectId + '\'' +
                ", version=" + version +
                ", digest='" + digest + '\'' +
                ", type='" + type + '\'' +
                ", owner=" + owner +
                ", previousTransaction='" + previousTransaction + '\'' +
                ", storageRebate=" + storageRebate +
                ", display=" + display +
                ", content=" + content +
                ", bcs=" + bcs +
                '}';
    }
}
