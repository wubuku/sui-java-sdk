package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;
import java.util.List;

/**
 * From Rust definition:
 * <p>
 * <pre>
 *
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub enum SuiMoveNormalizedType {
 *     Bool,
 *     U8,
 *     U16,
 *     U32,
 *     U64,
 *     U128,
 *     U256,
 *     Address,
 *     Signer,
 *     Struct {
 *         address: String,
 *         module: String,
 *         name: String,
 *         type_arguments: Vec<SuiMoveNormalizedType>,
 *     },
 *     Vector(Box<SuiMoveNormalizedType>),
 *     TypeParameter(SuiMoveTypeParameterIndex),
 *     Reference(Box<SuiMoveNormalizedType>),
 *     MutableReference(Box<SuiMoveNormalizedType>),
 * }
 * </pre>
 */
@JsonDeserialize(using = SuiMoveNormalizedTypeDeserializer.class)
public interface SuiMoveNormalizedType {

    @JsonDeserialize(using = PrimitiveDeserializer.class)
    @JsonSerialize(using = PrimitiveSerializer.class)
    enum Primitive implements SuiMoveNormalizedType {
        BOOL {
            @Override
            public String getCode() {
                return "Bool";
            }
        },
        U8 {
            @Override
            public String getCode() {
                return "U8";
            }
        },
        U16 {
            @Override
            public String getCode() {
                return "U16";
            }
        },
        U32 {
            @Override
            public String getCode() {
                return "U32";
            }
        },
        U64 {
            @Override
            public String getCode() {
                return "U64";
            }
        },
        U128 {
            @Override
            public String getCode() {
                return "U128";
            }
        },
        U256 {
            @Override
            public String getCode() {
                return "U256";
            }
        },
        ADDRESS {
            @Override
            public String getCode() {
                return "Address";
            }
        },
        SIGNER {
            @Override
            public String getCode() {
                return "Signer";
            }
        };

        public abstract String getCode();
    }

    class PrimitiveDeserializer extends JsonDeserializer<Primitive> {
        @Override
        public Primitive deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
            String code = jsonParser.getValueAsString();
            for (Primitive value : Primitive.values()) {
                if (value.getCode().equals(code)) {
                    return value;
                }
            }
            throw new InvalidFormatException(jsonParser, "SuiMoveNormalizedType.PrimitiveDeserializer.deserialize() error.", jsonParser.currentToken(), Primitive.class);
        }
    }

    class PrimitiveSerializer extends JsonSerializer<Primitive> {
        @Override
        public void serialize(Primitive value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.getCode());
        }
    }

    class Struct implements SuiMoveNormalizedType {
        @JsonProperty("Struct")
        private StructProperties struct;

        public Struct() {

        }

        public Struct(StructProperties struct) {
            this.struct = struct;
        }

        public StructProperties getStruct() {
            return struct;
        }

        public void setStruct(StructProperties struct) {
            this.struct = struct;
        }

        @Override
        public String toString() {
            return "Struct{" +
                    "struct=" + struct +
                    '}';
        }

        public static class StructProperties {
            private String address;
            private String module;
            private String name;
            @JsonProperty("type_arguments")
            private List<SuiMoveNormalizedType> typeArguments;

            public StructProperties() {
            }

            public StructProperties(String address, String module, String name, List<SuiMoveNormalizedType> typeArguments) {
                this.address = address;
                this.module = module;
                this.name = name;
                this.typeArguments = typeArguments;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<SuiMoveNormalizedType> getTypeArguments() {
                return typeArguments;
            }

            public void setTypeArguments(List<SuiMoveNormalizedType> typeArguments) {
                this.typeArguments = typeArguments;
            }

            @Override
            public String toString() {
                return "StructProperties{" +
                        "address='" + address + '\'' +
                        ", module='" + module + '\'' +
                        ", name='" + name + '\'' +
                        ", typeArguments=" + typeArguments +
                        '}';
            }
        }
    }

    class Vector implements SuiMoveNormalizedType {
        @JsonProperty("Vector")
        private SuiMoveNormalizedType vector;

        public Vector() {
        }

        public Vector(SuiMoveNormalizedType vector) {
            this.vector = vector;
        }

        public SuiMoveNormalizedType getVector() {
            return vector;
        }

        public void setVector(SuiMoveNormalizedType vector) {
            this.vector = vector;
        }

        @Override
        public String toString() {
            return "Vector{" +
                    "vector=" + vector +
                    '}';
        }
    }

    class TypeParameter implements SuiMoveNormalizedType {
        @JsonProperty("TypeParameter")
        private Integer typeParameter;

        public TypeParameter() {
        }

        public TypeParameter(Integer typeParameter) {
            this.typeParameter = typeParameter;
        }

        public Integer getTypeParameter() {
            return typeParameter;
        }

        public void setTypeParameter(Integer typeParameter) {
            this.typeParameter = typeParameter;
        }

        @Override
        public String toString() {
            return "TypeParameter{" +
                    "typeParameter=" + typeParameter +
                    '}';
        }
    }

    class Reference implements SuiMoveNormalizedType {
        @JsonProperty("Reference")
        private SuiMoveNormalizedType reference;

        public Reference() {
        }

        public Reference(SuiMoveNormalizedType reference) {
            this.reference = reference;
        }

        public SuiMoveNormalizedType getReference() {
            return reference;
        }

        public void setReference(SuiMoveNormalizedType reference) {
            this.reference = reference;
        }

        @Override
        public String toString() {
            return "Reference{" +
                    "reference=" + reference +
                    '}';
        }
    }

    class MutableReference implements SuiMoveNormalizedType {
        @JsonProperty("MutableReference")
        private SuiMoveNormalizedType mutableReference;

        public MutableReference() {
        }

        public MutableReference(SuiMoveNormalizedType mutableReference) {
            this.mutableReference = mutableReference;
        }

        public SuiMoveNormalizedType getMutableReference() {
            return mutableReference;
        }

        public void setMutableReference(SuiMoveNormalizedType mutableReference) {
            this.mutableReference = mutableReference;
        }

        @Override
        public String toString() {
            return "MutableReference{" +
                    "mutableReference=" + mutableReference +
                    '}';
        }
    }
}
