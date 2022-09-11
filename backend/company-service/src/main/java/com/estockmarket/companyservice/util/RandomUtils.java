package com.estockmarket.companyservice.util;

import java.util.Random;

public class RandomUtils {

    private static Random random = new Random();

    public static char getRandomUpperCaseChar() {
        // ASCII for 'A' is 65 and there are 26 alphabets in total
        return (char) (random.nextInt(26) + 65);
    }

    private RandomUtils(){}
}
