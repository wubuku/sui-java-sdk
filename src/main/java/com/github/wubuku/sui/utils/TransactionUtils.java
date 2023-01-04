package com.github.wubuku.sui.utils;

import com.google.common.primitives.Bytes;

import java.util.Base64;

public class TransactionUtils {
    /**
     * From TypeScript definition:
     * <p>
     * <pre>
     * // See: sui/crates/sui-types/src/intent.rs
     * // This is currently hardcoded with [IntentScope::TransactionData = 0, Version::V0 = 0, AppId::Sui = 0]
     * const INTENT_BYTES = [0, 0, 0];
     * </pre>
     */
    public static final byte[] INTENT_BYTES = new byte[]{0, 0, 0};

    private TransactionUtils() {
    }

    public static byte[] ed25519SignTransactionBytes(byte[] privateKey, String txBytes) {
        return SignatureUtils.ed25519Sign(privateKey,
                Bytes.concat(TransactionUtils.INTENT_BYTES, Base64.getDecoder().decode(txBytes))
        );
    }

}
