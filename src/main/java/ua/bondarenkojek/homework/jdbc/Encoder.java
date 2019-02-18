package ua.bondarenkojek.homework.jdbc;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

public class Encoder {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static BASE64Encoder enc = new BASE64Encoder();

    public static String encode(String text) {
        try {
            return enc.encode(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
