package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Rust version of the Move sui::validator_set::ValidatorPair type
 * #[derive(Debug, Serialize, Deserialize, Clone, Eq, PartialEq, JsonSchema)]
 * pub struct ValidatorPair {
 *     from: SuiAddress,
 *     to: SuiAddress,
 * }
 * </pre>
 */
public class ValidatorPair {
    private String from;
    private String to;

    public ValidatorPair() {
    }

    public ValidatorPair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "ValidatorPair{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
