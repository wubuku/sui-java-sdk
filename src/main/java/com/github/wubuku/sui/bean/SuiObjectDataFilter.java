package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public interface SuiObjectDataFilter {
    class MatchAll implements SuiObjectDataFilter {
        @JsonProperty("MatchAll")
        private SuiObjectResponseQuery[] matchAll;

        public SuiObjectResponseQuery[] getMatchAll() {
            return matchAll;
        }

        public void setMatchAll(SuiObjectResponseQuery[] matchAll) {
            this.matchAll = matchAll;
        }

        @Override
        public String toString() {
            return "MatchAll{" +
                    "matchAll=" + Arrays.toString(matchAll) +
                    '}';
        }
    }

    class MatchAny implements SuiObjectDataFilter {
        @JsonProperty("MatchAny")
        private SuiObjectResponseQuery[] matchAny;

        public SuiObjectResponseQuery[] getMatchAny() {
            return matchAny;
        }

        public void setMatchAny(SuiObjectResponseQuery[] matchAny) {
            this.matchAny = matchAny;
        }

        @Override
        public String toString() {
            return "MatchAny{" +
                    "matchAny=" + Arrays.toString(matchAny) +
                    '}';
        }
    }

    class MatchNone implements SuiObjectDataFilter {
        @JsonProperty("MatchNone")
        private SuiObjectResponseQuery[] matchNone;

        public SuiObjectResponseQuery[] getMatchNone() {
            return matchNone;
        }

        public void setMatchNone(SuiObjectResponseQuery[] matchNone) {
            this.matchNone = matchNone;
        }

        @Override
        public String toString() {
            return "MatchNone{" +
                    "matchNone=" + Arrays.toString(matchNone) +
                    '}';
        }
    }

    class Package implements SuiObjectDataFilter {
        @JsonProperty("Package")
        private String package_;

        public String getPackage_() {
            return package_;
        }

        public void setPackage_(String package_) {
            this.package_ = package_;
        }

        @Override
        public String toString() {
            return "Package{" +
                    "package_='" + package_ + '\'' +
                    '}';
        }
    }

    class MoveModule implements SuiObjectDataFilter {

        @JsonProperty("MoveModule")
        private MoveModuleProperties moveModule;

        public MoveModuleProperties getMoveModule() {
            return moveModule;
        }

        public void setMoveModule(MoveModuleProperties moveModule) {
            this.moveModule = moveModule;
        }

        public static class MoveModuleProperties {

            @JsonProperty("module")
            private String module;
            @JsonProperty("package")
            private String package_;

            public String getModule() {
                return module;
            }

            public void setModule(String module) {
                this.module = module;
            }

            public String getPackage_() {
                return package_;
            }

            public void setPackage_(String package_) {
                this.package_ = package_;
            }

            @Override
            public String toString() {
                return "MoveModuleProperties{" +
                        "module='" + module + '\'' +
                        ", package_='" + package_ + '\'' +
                        '}';
            }

        }

    }

    class StructType implements SuiObjectDataFilter {
        @JsonProperty("StructType")
        private String structType;

        public StructType(String structType) {
            this.structType = structType;
        }

        public StructType() {
        }

        public String getStructType() {
            return structType;
        }

        public void setStructType(String structType) {
            this.structType = structType;
        }

        @Override
        public String toString() {
            return "StructType{" +
                    "structType='" + structType + '\'' +
                    '}';
        }
    }

    class AddressOwner implements SuiObjectDataFilter {
        @JsonProperty("AddressOwner")
        private String addressOwner;

        public AddressOwner() {
        }

        public AddressOwner(String addressOwner) {
            this.addressOwner = addressOwner;
        }

        public String getAddressOwner() {
            return addressOwner;
        }

        public void setAddressOwner(String addressOwner) {
            this.addressOwner = addressOwner;
        }

        @Override
        public String toString() {
            return "ObjectOwner.AddressOwner{" +
                    "addressOwner='" + addressOwner + '\'' +
                    '}';
        }
    }

    class ObjectOwner implements SuiObjectDataFilter {
        @JsonProperty("ObjectOwner")
        private String objectOwner;

        public ObjectOwner() {
        }

        public ObjectOwner(String objectOwner) {
            this.objectOwner = objectOwner;
        }

        public String getObjectOwner() {
            return objectOwner;
        }

        public void setObjectOwner(String objectOwner) {
            this.objectOwner = objectOwner;
        }

        @Override
        public String toString() {
            return "ObjectOwner.ObjectOwner_{" +
                    "objectOwner='" + objectOwner + '\'' +
                    '}';
        }
    }

    class ObjectId implements SuiObjectDataFilter {
        @JsonProperty("ObjectId")
        private String objectId;

        public ObjectId() {
        }

        public ObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        @Override
        public String toString() {
            return "ObjectId{" +
                    "objectId='" + objectId + '\'' +
                    '}';
        }
    }

    class ObjectIds implements SuiObjectDataFilter {
        @JsonProperty("ObjectIds")
        private String[] objectIds;

        public ObjectIds() {
        }

        public ObjectIds(String[] objectIds) {
            this.objectIds = objectIds;
        }

        public String[] getObjectIds() {
            return objectIds;
        }

        public void setObjectIds(String[] objectIds) {
            this.objectIds = objectIds;
        }

        @Override
        public String toString() {
            return "ObjectIds{" +
                    "objectIds=" + Arrays.toString(objectIds) +
                    '}';
        }
    }

    class Version implements SuiObjectDataFilter {
        @JsonProperty("Version")
        private String version;

        public Version() {
        }

        public Version(String version) {
            this.version = version;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        @Override
        public String toString() {
            return "Version{" +
                    "version='" + version + '\'' +
                    '}';
        }
    }
}
