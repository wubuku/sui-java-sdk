package com.github.wubuku.sui.bean;

public class Table {
    private String type;
    private Fields fields;


    public Table() {
    }

    public Table(String type, Fields fields) {
        this.type = type;
        this.fields = fields;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }


    @Override
    public String toString() {
        return "Table{" +
                "type='" + type + '\'' +
                ", fields=" + fields +
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
