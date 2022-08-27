package com.estockmarket.companyservice.util;

import java.util.Random;

public class RandomUtils {

    public static char getRandomUpperCaseChar() {
        // ASCII for 'A' is 65 and there are 26 alphabets in total
        Random random = new Random();
        return (char) (Math.round(random.nextInt(26)) + 65);
    }
}
