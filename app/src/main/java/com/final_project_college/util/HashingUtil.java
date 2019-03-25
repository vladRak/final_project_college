package com.final_project_college.util;

import static org.apache.commons.codec.digest.DigestUtils.*;

public class HashingUtil {

    private final static String SALT = "some_salt";

    public static String hash(String valueToHash) {
        return sha256Hex(valueToHash + SALT);
    }

    public static boolean verifyValue(String value, String hash) {
        System.out.println(hash(value));
        System.out.println(hash);
        return hash.equals(hash(value));
    }
}
