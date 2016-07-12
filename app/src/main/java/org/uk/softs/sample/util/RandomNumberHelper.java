package org.uk.softs.sample.util;

import java.util.Random;


public final class RandomNumberHelper {

    private static final int UP_TO_RANDOM_NUMBER = 100;

    private RandomNumberHelper() {

    }

    public static int getRandomNumber() {
        Random rnd = new Random();
        return rnd.nextInt(UP_TO_RANDOM_NUMBER);
    }

}
