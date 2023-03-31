package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
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
 * /// An argument to a transaction in a programmable transaction block
 * #[derive(Debug, Copy, Clone, Serialize, Deserialize, JsonSchema, PartialEq, Eq)]
 * pub enum SuiArgument {
 *     /// The gas coin. The gas coin can only be used by-ref, except for with
 *     /// `TransferObjects`, which can use it by-value.
 *     GasCoin,
 *     /// One of the input objects or primitive values (from
 *     /// `ProgrammableTransactionBlock` inputs)
 *     Input(u16),
 *     /// The result of another transaction (from `ProgrammableTransactionBlock` transactions)
 *     Result(u16),
 *     /// Like a `Result` but it accesses a nested result. Currently, the only usage
 *     /// of this is to access a value from a Move call with multiple return values.
 *     NestedResult(u16, u16),
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiArgumentDeserializer.class)
public interface SuiArgument {

    @JsonSerialize(using = GasCoinSerializer.class)
    class GasCoin implements SuiArgument {
        public static GasCoin INSTANCE = new GasCoin();

        public GasCoin() {
        }

        @Override
        public String toString() {
            return "GasCoin{}";
        }
    }

    class GasCoinSerializer extends JsonSerializer<GasCoin> {
        @Override
        public void serialize(GasCoin value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString("GasCoin");
        }
    }

    class Input implements SuiArgument {
        @JsonProperty("Input")
        private int input;

        public Input() {
        }

        public Input(int input) {
            this.input = input;
        }

        public int getInput() {
            return input;
        }

        public void setInput(int input) {
            this.input = input;
        }

        @Override
        public String toString() {
            return "Input{" +
                    "input=" + input +
                    '}';
        }
    }

    class Result implements SuiArgument {
        @JsonProperty("Result")
        private int result;

        public Result() {
        }

        public Result(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "result=" + result +
                    '}';
        }
    }

    @JsonSerialize(using = NestedResultSerializer.class)
    class NestedResult implements SuiArgument {
        private int result;
        private int nestedResult;

        public NestedResult() {
        }

        public NestedResult(int[] items) {
            this.result = items[0];
            this.nestedResult = items[1];
        }

        public NestedResult(int result, int nestedResult) {
            this.result = result;
            this.nestedResult = nestedResult;
        }

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public int getNestedResult() {
            return nestedResult;
        }

        public void setNestedResult(int nestedResult) {
            this.nestedResult = nestedResult;
        }

        @Override
        public String toString() {
            return "NestedResult{" +
                    "result=" + result +
                    ", nestedResult=" + nestedResult +
                    '}';
        }
    }

    class NestedResultSerializer extends JsonSerializer<NestedResult> {
        @Override
        public void serialize(NestedResult value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeArray(new int[]{value.getResult(), value.getNestedResult()}, 0, 2);
        }
    }
}
