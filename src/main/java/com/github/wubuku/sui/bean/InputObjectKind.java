package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * #[derive(Clone, Copy, Debug, Eq, PartialEq, Serialize, Deserialize)]
 * pub enum InputObjectKind {
 *     // A Move package, must be immutable.
 *     MovePackage(ObjectID),
 *     // A Move object, either immutable, or owned mutable.
 *     ImmOrOwnedMoveObject(ObjectRef),
 *     // A Move object that's shared and mutable.
 *     SharedMoveObject {
 *         id: ObjectID,
 *         initial_shared_version: SequenceNumber,
 *     },
 * }
 * </pre>
 */
@JsonDeserialize(using = InputObjectKindDeserializer.class)
public interface InputObjectKind {
    class MovePackage implements InputObjectKind {
        @JsonProperty("MovePackage")
        private String movePackage;

        public MovePackage() {
        }

        public MovePackage(String movePackage) {
            this.movePackage = movePackage;
        }

        public String getMovePackage() {
            return movePackage;
        }

        public void setMovePackage(String movePackage) {
            this.movePackage = movePackage;
        }

        @Override
        public String toString() {
            return "InputObjectKind.MovePackage{" +
                    "movePackage=" + movePackage +
                    '}';
        }
    }

    class ImmOrOwnedMoveObject implements InputObjectKind {
        @JsonProperty("ImmOrOwnedMoveObject")
        private SuiObjectRef immOrOwnedMoveObject;

        public ImmOrOwnedMoveObject() {
        }

        public ImmOrOwnedMoveObject(SuiObjectRef immOrOwnedMoveObject) {
            this.immOrOwnedMoveObject = immOrOwnedMoveObject;
        }

        public SuiObjectRef getImmOrOwnedMoveObject() {
            return immOrOwnedMoveObject;
        }

        public void setImmOrOwnedMoveObject(SuiObjectRef immOrOwnedMoveObject) {
            this.immOrOwnedMoveObject = immOrOwnedMoveObject;
        }

        @Override
        public String toString() {
            return "InputObjectKind.ImmOrOwnedMoveObject{" +
                    "immOrOwnedMoveObject=" + immOrOwnedMoveObject +
                    '}';
        }
    }

    class SharedMoveObject implements InputObjectKind {
        @JsonProperty("SharedMoveObject")
        private SharedMoveObjectProperties sharedMoveObject;

        public SharedMoveObject() {
        }

        public SharedMoveObject(SharedMoveObjectProperties sharedMoveObject) {
            this.sharedMoveObject = sharedMoveObject;
        }

        public SharedMoveObject(String id, Long initialSharedVersion) {
            this.sharedMoveObject = new SharedMoveObjectProperties(id, initialSharedVersion);
        }

        public SharedMoveObjectProperties getSharedMoveObject() {
            return sharedMoveObject;
        }

        public void setSharedMoveObject(SharedMoveObjectProperties sharedMoveObject) {
            this.sharedMoveObject = sharedMoveObject;
        }

        @Override
        public String toString() {
            return "InputObjectKind.SharedMoveObject{" +
                    "sharedMoveObject=" + sharedMoveObject +
                    '}';
        }

        public static class SharedMoveObjectProperties {
            private String id;
            @JsonProperty("initial_shared_version")
            private Long initialSharedVersion;

            public SharedMoveObjectProperties() {
            }

            public SharedMoveObjectProperties(String id, Long initialSharedVersion) {
                this.id = id;
                this.initialSharedVersion = initialSharedVersion;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public Long getInitialSharedVersion() {
                return initialSharedVersion;
            }

            public void setInitialSharedVersion(Long initialSharedVersion) {
                this.initialSharedVersion = initialSharedVersion;
            }

            @Override
            public String toString() {
                return "InputObjectKind.SharedMoveObjectProperties{" +
                        "id='" + id + '\'' +
                        ", initialSharedVersion=" + initialSharedVersion +
                        '}';
            }
        }
    }
}
