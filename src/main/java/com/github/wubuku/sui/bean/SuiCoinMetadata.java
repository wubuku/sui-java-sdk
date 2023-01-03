package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, JsonSchema, Clone)]
 * #[serde(rename_all = "camelCase")]
 * pub struct SuiCoinMetadata {
 *     /// Number of decimal places the coin uses.
 *     pub decimals: u8,
 *     /// Name for the token
 *     pub name: String,
 *     /// Symbol for the token
 *     pub symbol: String,
 *     /// Description of the token
 *     pub description: String,
 *     /// URL for the token logo
 *     pub icon_url: Option<String>,
 *     /// Object id for the CoinMetadata object
 *     pub id: Option<ObjectID>,
 * }
 * </pre>
 */
public class SuiCoinMetadata {
    private int decimals;
    private String name;
    private String symbol;
    private String description;
    private String iconUrl;
    private String id;

    public SuiCoinMetadata() {
    }

    public SuiCoinMetadata(int decimals, String name, String symbol, String description, String iconUrl, String id) {
        this.decimals = decimals;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.iconUrl = iconUrl;
        this.id = id;
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SuiCoinMetadata{" +
                "decimals=" + decimals +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
