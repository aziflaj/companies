package com.aziflaj.companies.auth;


import com.sun.istack.internal.NotNull;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public final class Auth {
    public static final int SALT_LENGTH = 50;
    public static final int ITERATIONS = 20 * 1000;
    public static final int KEY_LENGTH = 256;

    public static String passwordHash(@NotNull String password) {
        try {
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(SALT_LENGTH);
            return Base64.getEncoder().encodeToString(salt) + "$" + hash(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean passwordCheck(@NotNull String password, @NotNull String storedPassword) {
        String[] saltAndPassword = storedPassword.split("\\$");
        String inputHash = Auth.hash(password, Base64.getDecoder().decode(saltAndPassword[0]));
        return inputHash.equals(saltAndPassword[1]);
    }

    private static String hash(String password, byte[] salt) {
        try {
            SecretKey key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
                    .generateSecret(new PBEKeySpec(password.toCharArray(),
                            salt,
                            ITERATIONS,
                            KEY_LENGTH));

            return Base64.getEncoder().encodeToString(key.getEncoded());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return "";
    }
}
