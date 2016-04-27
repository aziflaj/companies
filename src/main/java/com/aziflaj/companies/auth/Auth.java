package com.aziflaj.companies.auth;

import com.sun.istack.internal.NotNull;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Final class used for handling password-based features, like
 * password validation and hashing
 */
public final class Auth {
    public static final int SALT_LENGTH = 50;
    public static final int ITERATIONS = 20 * 1000;
    public static final int KEY_LENGTH = 256;

    /**
     * Hashes a password value using salt
     *
     * @param password The password to hash
     * @return The hashed password or an empty string if something goes wrong (like the
     * "SHA1PRNG" algorithm isn't found)
     */
    public static String passwordHash(@NotNull String password) {
        try {
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(SALT_LENGTH);
            return Base64.getEncoder().encodeToString(salt) + "$" + hash(password, salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Checks if a plain-text password is the same as a previously hashed password
     *
     * @param password       The plain-text password to check
     * @param storedPassword The previously stored password, potentially fetched from the database
     * @return {@code true} if the passwords match, otherwise {@code false}
     */
    public static boolean passwordCheck(@NotNull String password, @NotNull String storedPassword) {
        String[] saltAndPassword = storedPassword.split("\\$");
        String inputHash = Auth.hash(password, Base64.getDecoder().decode(saltAndPassword[0]));
        return inputHash.equals(saltAndPassword[1]);
    }

    /**
     * Hashes a password, given the plain-text password and a salt value
     *
     * @param password The plain-text password to hash
     * @param salt     A salt value
     * @return The hashed password
     */
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
