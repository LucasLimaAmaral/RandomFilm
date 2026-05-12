package com.pop.film.util;

import java.security.SecureRandom;

public final class RandomUtils {

    private RandomUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    private static final SecureRandom RANDOM = new SecureRandom();


    public static int nextInt(int max) {
        return RANDOM.nextInt(1, max+1);
    }
}
