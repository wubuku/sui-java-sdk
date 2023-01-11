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
 * #[derive(Serialize, Deserialize, Debug, JsonSchema)]
 * pub enum MoveFunctionArgType {
 *     Pure,
 *     Object(ObjectValueKind),
 * }
 * </pre>
 */
@JsonDeserialize(using = MoveFunctionArgTypeDeserializer.class)
public interface MoveFunctionArgType {
    @JsonSerialize(using = PureSerializer.class)
    class Pure implements MoveFunctionArgType {
        public static Pure INSTANCE = new Pure();

        @Override
        public String toString() {
            return "InputObjectKind.Pure{}";
        }
    }

    class PureSerializer extends JsonSerializer<Pure> {
        @Override
        public void serialize(Pure value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString("Pure");
        }
    }

    class Object implements MoveFunctionArgType {
        @JsonProperty("Object")
        private ObjectValueKind objectValueKind;

        public Object() {
        }

        public Object(ObjectValueKind objectValueKind) {
            this.objectValueKind = objectValueKind;
        }

        public ObjectValueKind getObjectValueKind() {
            return objectValueKind;
        }

        public void setObjectValueKind(ObjectValueKind objectValueKind) {
            this.objectValueKind = objectValueKind;
        }

        @Override
        public String toString() {
            return "InputObjectKind.Object{" +
                    "objectValueKind=" + objectValueKind +
                    '}';
        }
    }
}
