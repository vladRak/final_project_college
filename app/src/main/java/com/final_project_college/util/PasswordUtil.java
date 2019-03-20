package com.final_project_college.util;

import static org.apache.commons.codec.digest.DigestUtils.*;

public class PasswordUtil {

    private final static String SALT = "some_salt";

    public static String hash(String password) {
        return sha256Hex(password + SALT);
    }

    public static boolean verifyPassword(String password, String hash) {
        System.out.println(hash(password));
        System.out.println(hash);
        return hash.equals(hash(password));
    }
}
