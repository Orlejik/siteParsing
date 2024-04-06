package Helpers;

import java.util.Random;

public class RandomLong {
    public static int newRandLong() {

        Random rand = new Random();
        return rand.nextInt(99999999);
    }


}
