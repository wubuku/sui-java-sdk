package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Arrays;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type AuthoritySignature = string;
 *
 * export type GenericAuthoritySignature =
 *   | AuthoritySignature[]
 *   | AuthoritySignature;
 * </pre>
 */
@JsonDeserialize(using = GenericAuthoritySignatureDeserializer.class)
@JsonSerialize(using = GenericAuthoritySignatureSerializer.class)
public interface GenericAuthoritySignature {

    class AuthoritySignatureArray implements GenericAuthoritySignature {
        private String[] signatures;

        public AuthoritySignatureArray() {
        }

        public AuthoritySignatureArray(String[] signatures) {
            this.signatures = signatures;
        }

        public String[] getSignatures() {
            return signatures;
        }

        public void setSignatures(String[] signatures) {
            this.signatures = signatures;
        }

        @Override
        public String toString() {
            return "GenericAuthoritySignature.AuthoritySignatureArray{" +
                    "signatures=" + Arrays.toString(signatures) +
                    '}';
        }
    }

    class AuthoritySignature implements GenericAuthoritySignature {
        private String signature;

        public AuthoritySignature() {
        }

        public AuthoritySignature(String signature) {
            this.signature = signature;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        @Override
        public String toString() {
            return "GenericAuthoritySignature.AuthoritySignature{" +
                    "signature='" + signature + '\'' +
                    '}';
        }
    }
}
