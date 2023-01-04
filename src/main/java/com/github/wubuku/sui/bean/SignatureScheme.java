package com.github.wubuku.sui.bean;

/**
 * From TypeScript definition:
 * <p>
 * <pre>
 * export type SignatureScheme = 'ED25519' | 'Secp256k1';
 *
 * export const SIGNATURE_SCHEME_TO_FLAG = {
 *   ED25519: 0x00,
 *   Secp256k1: 0x01,
 * };
 * </pre>
 */
public class SignatureScheme {
    public static final String ED25519 = "ED25519";
    public static final String SECP256K1 = "Secp256k1";

    public static final byte ED25519_FLAG = 0x00;
    public static final byte SECP256K1_FLAG = 0x01;

    private SignatureScheme() {
    }
}
