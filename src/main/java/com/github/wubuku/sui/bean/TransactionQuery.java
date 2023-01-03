package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type TransactionQuery =
 *   | 'All'
 *   | {
 *       MoveFunction: {
 *         package: ObjectId;
 *         module: string | null;
 *         function: string | null;
 *       };
 *     }
 *   | { InputObject: ObjectId }
 *   | { MutatedObject: ObjectId }
 *   | { FromAddress: SuiAddress }
 *   | { ToAddress: SuiAddress };
 * </pre>
 */
public interface TransactionQuery {
    @JsonSerialize(using = AllJsonSerializer.class)
    class All implements TransactionQuery {
        public static All INSTANCE = new All();

        @Override
        public String toString() {
            return "All{}";
        }
    }

    class AllJsonSerializer extends JsonSerializer<All> {
        @Override
        public void serialize(All value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString("All");
        }
    }

    class MoveFunction implements TransactionQuery {
        @JsonProperty("MoveFunction")
        private MoveFunctionProperties moveFunction;

        public MoveFunction() {
        }

        public MoveFunction(String package_, String module, String function) {
            this.moveFunction = new MoveFunctionProperties(package_, module, function);
        }

        public MoveFunction(MoveFunctionProperties moveFunction) {
            this.moveFunction = moveFunction;
        }

        public MoveFunctionProperties getMoveFunction() {
            return moveFunction;
        }

        public void setMoveFunction(MoveFunctionProperties moveFunction) {
            this.moveFunction = moveFunction;
        }

        @Override
        public String toString() {
            return "MoveFunction{" +
                    "moveFunction=" + moveFunction +
                    '}';
        }

        public static class MoveFunctionProperties {
            @JsonProperty("package")
            private String package_;
            private String module;
            private String function;

            public MoveFunctionProperties() {
            }

            public MoveFunctionProperties(String package_, String module, String function) {
                this.package_ = package_;
                this.module = module;
                this.function = function;
            }

            public String getPackage_() {
                return package_;
            }

            public void setPackage_(String package_) {
                this.package_ = package_;
            }

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

            public String getFunction() {
                return function;
            }

            public void setFunction(String function) {
                this.function = function;
            }

            @Override
            public String toString() {
                return "MoveFunctionProperties{" +
                        "package='" + package_ + '\'' +
                        ", module='" + module + '\'' +
                        ", function='" + function + '\'' +
                        '}';
            }
        }
    }

    class InputObject implements TransactionQuery {
        @JsonProperty("InputObject")
        private String inputObject;

        public InputObject() {
        }

        public InputObject(String inputObject) {
            this.inputObject = inputObject;
        }

        public String getInputObject() {
            return inputObject;
        }

        public void setInputObject(String inputObject) {
            this.inputObject = inputObject;
        }

        @Override
        public String toString() {
            return "InputObject{" +
                    "inputObject='" + inputObject + '\'' +
                    '}';
        }
    }

    class MutatedObject implements TransactionQuery {
        @JsonProperty("MutatedObject")
        private String mutatedObject;

        public MutatedObject() {
        }

        public MutatedObject(String mutatedObject) {
            this.mutatedObject = mutatedObject;
        }

        public String getMutatedObject() {
            return mutatedObject;
        }

        public void setMutatedObject(String mutatedObject) {
            this.mutatedObject = mutatedObject;
        }

        @Override
        public String toString() {
            return "MutatedObject{" +
                    "mutatedObject='" + mutatedObject + '\'' +
                    '}';
        }
    }

    class FromAddress implements TransactionQuery {
        @JsonProperty("FromAddress")
        private String fromAddress;

        public FromAddress() {
        }

        public FromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }

        public String getFromAddress() {
            return fromAddress;
        }

        public void setFromAddress(String fromAddress) {
            this.fromAddress = fromAddress;
        }

        @Override
        public String toString() {
            return "FromAddress{" +
                    "fromAddress='" + fromAddress + '\'' +
                    '}';
        }
    }

    class ToAddress implements TransactionQuery {
        @JsonProperty("ToAddress")
        private String toAddress;

        public ToAddress() {
        }

        public ToAddress(String toAddress) {
            this.toAddress = toAddress;
        }

        public String getToAddress() {
            return toAddress;
        }

        public void setToAddress(String toAddress) {
            this.toAddress = toAddress;
        }

        @Override
        public String toString() {
            return "ToAddress{" +
                    "toAddress='" + toAddress + '\'' +
                    '}';
        }
    }

}
