package com.github.wubuku.sui.bean;

/**
 * From Rust definition:
 * <p>
 * <pre>
 * /// Type of a Sui object
 * #[derive(Clone, Serialize, Deserialize, Ord, PartialOrd, Eq, PartialEq, Debug)]
 * pub enum ObjectType {
 *     /// Move package containing one or more bytecode modules
 *     Package,
 *     /// A Move struct of the given type
 *     Struct(MoveObjectType),
 * }
 * </pre>
 */
public interface ObjectType {
    //todo
}
