package com.github.wubuku.sui.bean;

/**
 * From Move definition:
 * <p>
 * <pre>
 * /// Internal object used for storing the field and value
 * struct Field<Name: copy + drop + store, Value: store> has key {
 *     /// Determined by the hash of the object ID, the field name value and it's type,
 *     /// i.e. hash(parent.id || name || Name)
 *     id: UID,
 *     /// The value for the name of this field
 *     name: Name,
 *     /// The value bound to this field
 *     value: Value,
 * }
 * </pre>
 */
public class StructValueDynamicField<N, T> extends AbstractDynamicField<N, MoveStruct<T>> {
    private UID id;
    private N name;
    private MoveStruct<T> value;

    public StructValueDynamicField() {
    }

    public StructValueDynamicField(UID id, N name, MoveStruct<T> value) {
        super(id, name, value);
    }

    public UID getId() {
        return id;
    }

    public void setId(UID id) {
        this.id = id;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public MoveStruct<T> getValue() {
        return value;
    }

    public void setValue(MoveStruct<T> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DynamicField{" +
                "id=" + id +
                ", name=" + name +
                ", value=" + value +
                '}';
    }
}
