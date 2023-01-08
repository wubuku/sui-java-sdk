package com.github.wubuku.sui.utils;

public class AddressUtils {
    public static final int ADDRESS_LENGTH = 20;

    private AddressUtils() {
    }

    public static byte[] hexToAddressBytes(String hex) {
        byte[] addressBytes = HexUtils.hexToByteArray(hex);
        if (addressBytes.length < ADDRESS_LENGTH) {
            byte[] bs = new byte[ADDRESS_LENGTH];
            for (int i = 0; i < addressBytes.length; i++) {
                bs[bs.length - addressBytes.length - i] = addressBytes[i];
            }
            addressBytes = bs;
        }
        return addressBytes;
    }

}
