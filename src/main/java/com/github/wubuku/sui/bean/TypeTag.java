package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Serialize, Deserialize, Debug, PartialEq, Hash, Eq, Clone, PartialOrd, Ord)]
 * pub enum TypeTag {
 *     // alias for compatibility with old json serialized data.
 *     #[serde(rename = "bool", alias = "Bool")]
 *     Bool,
 *     #[serde(rename = "u8", alias = "U8")]
 *     U8,
 *     #[serde(rename = "u64", alias = "U64")]
 *     U64,
 *     #[serde(rename = "u128", alias = "U128")]
 *     U128,
 *     #[serde(rename = "address", alias = "Address")]
 *     Address,
 *     #[serde(rename = "signer", alias = "Signer")]
 *     Signer,
 *     #[serde(rename = "vector", alias = "Vector")]
 *     Vector(Box<TypeTag>),
 *     #[serde(rename = "struct", alias = "Struct")]
 *     Struct(Box<StructTag>),
 *
 *     // NOTE: Added in bytecode version v6, do not reorder!
 *     #[serde(rename = "u16", alias = "U16")]
 *     U16,
 *     #[serde(rename = "u32", alias = "U32")]
 *     U32,
 *     #[serde(rename = "u256", alias = "U256")]
 *     U256,
 * }
 * </pre>
 */
public interface TypeTag {
    class Bool implements TypeTag {
        public static Bool INSTANCE = new Bool();
        private final String bool = null;

        public Bool() {
        }
    }

    class U8 implements TypeTag {
        public static U8 INSTANCE = new U8();
        private final String u8 = null;

        public U8() {
        }
    }

    class U64 implements TypeTag {
        public static U64 INSTANCE = new U64();
        private final String u64 = null;

        public U64() {
        }
    }

    class U128 implements TypeTag {
        public static U128 INSTANCE = new U128();
        private final String u128 = null;

        public U128() {
        }
    }

    class Address implements TypeTag {
        public static Address INSTANCE = new Address();
        private final String address = null;

        public Address() {
        }
    }

    class Signer implements TypeTag {
        public static Signer INSTANCE = new Signer();
        private final String signer = null;

        public Signer() {
        }
    }

    class Vector implements TypeTag {
        private TypeTag vector;

        public Vector() {
        }

        public Vector(TypeTag vector) {
            this.vector = vector;
        }

        public TypeTag getVector() {
            return vector;
        }

        public void setVector(TypeTag vector) {
            this.vector = vector;
        }

        @Override
        public String toString() {
            return "TypeTag.Vector{" +
                    "vector=" + vector +
                    '}';
        }
    }

    class Struct implements TypeTag {
        private StructTag struct;

        public Struct() {
        }

        public Struct(StructTag struct) {
            this.struct = struct;
        }

        public StructTag getStruct() {
            return struct;
        }

        public void setStruct(StructTag struct) {
            this.struct = struct;
        }

        @Override
        public String toString() {
            return "TypeTag.Struct{" +
                    "struct=" + struct +
                    '}';
        }
    }

    class U16 implements TypeTag {
        public static U16 INSTANCE = new U16();
        private final String u16 = null;

        public U16() {
        }
    }

    class U32 implements TypeTag {
        public static U32 INSTANCE = new U32();
        private final String u32 = null;

        public U32() {
        }
    }

    class U256 implements TypeTag {
        public static U256 INSTANCE = new U256();
        private final String u256 = null;

        public U256() {
        }
    }
}
