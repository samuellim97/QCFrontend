package com.help.quickcard.api;

import java.math.BigInteger;

/**
 * Common methods we may need.
 * Created by shath on 03/02/18.
 */

public class Common {
    /**
     * Converts binary to hexadecimal string
     * @param data
     * @return
     */
     static String bin2hex(byte[] data) {
        return String.format("%0" + (data.length * 2) + "X", new BigInteger(1,data));
    }

    /**
     * Converts Hexadecimal String to Binary
     * @param s A valid hexadecimal string.
     * @return
     */
    public static byte[] hex2bin(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
