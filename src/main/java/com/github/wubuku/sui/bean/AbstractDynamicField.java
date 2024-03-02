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
public abstract class AbstractDynamicField<N, V> {
    private UID id;
    private N name;
    private V value;

    public AbstractDynamicField() {
    }

    public AbstractDynamicField(UID id, N name, V value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
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
