package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Eq, PartialEq, Clone, Debug, Serialize, Deserialize, JsonSchema)]
 * #[serde(rename = "ExecutionStatus", rename_all = "camelCase", tag = "status")]
 * pub enum SuiExecutionStatus {
 *     // Gas used in the success case.
 *     Success,
 *     // Gas used in the failed case, and the error.
 *     Failure { error: String },
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiExecutionStatusDeserializer.class)
public interface SuiExecutionStatus {
    @JsonSerialize(using = SuiExecutionStatusSerializer.class)
    class Success implements SuiExecutionStatus {
        public static Success INSTANCE = new Success();

        public Success() {
        }

        @Override
        public String toString() {
            return "Success{}";
        }
    }

    class SuiExecutionStatusSerializer extends JsonSerializer<Success> {
        @Override
        public void serialize(Success value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString("success");
        }
    }

    class Failure implements SuiExecutionStatus {
        private FailureProperties failure;

        public Failure() {
        }

        public Failure(FailureProperties failure) {
            this.failure = failure;
        }

        public FailureProperties getFailure() {
            return failure;
        }

        public void setFailure(FailureProperties failure) {
            this.failure = failure;
        }

        @Override
        public String toString() {
            return "Failure{" +
                    "failure=" + failure +
                    '}';
        }

        public static class FailureProperties {
            private String error;

            public FailureProperties() {
            }

            public FailureProperties(String error) {
                this.error = error;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            @Override
            public String toString() {
                return "FailureProperties{" +
                        "error='" + error + '\'' +
                        '}';
            }
        }
    }
}
