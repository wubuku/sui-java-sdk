package com.github.wubuku.sui.bean;

public class Table extends MoveObject<Table.Fields> {
    public Table() {
    }

    public Table(String type, Fields fields) {
        super(type, fields);
    }

    @Override
    public String toString() {
        return "Table{" +
                "type='" + getType() + '\'' +
                ", fields=" + getFields() +
                '}';
    }

    public static class Fields {
        private UID id;

        private Long size;

        public Fields() {
        }

        public Fields(UID id, Long size) {
            this.id = id;
            this.size = size;
        }

        public UID getId() {
            return id;
        }

        public void setId(UID id) {
            this.id = id;
        }

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Fields{" +
                    "id=" + id +
                    ", size=" + size +
                    '}';
        }
    }
}
