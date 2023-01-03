package com.github.wubuku.sui.bean;

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
public class InputObjectKind extends java.util.LinkedHashMap<String, Object> {
    //todo
}
