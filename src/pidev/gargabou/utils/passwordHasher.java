/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pidev.gargabou.utils;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 *
 * @author alisl
 */
public class passwordHasher {
    private static final int ITERATIONS = 10;
    private static final int MEMORY = 65536;
    private static final int PARALLELISM = 1;

    public static String hashPassword(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(ITERATIONS, MEMORY, PARALLELISM, password);
        return hash;
    }

    public static boolean verifyPassword(String password, String hash) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.verify(hash, password);
    }
    private String getStoredHashForUser(String username) {
        // retrieve the stored hash for the given username from your data store
        // return null if the username is not found
        return null;
    }
}
