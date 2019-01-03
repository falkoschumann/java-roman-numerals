package de.muspellheim.roman;

import java.util.*;

public class RomanConverter {

    private static final Map<Character, Integer> DIGITS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static int fromRoman(String romanNumeral) {
        int currentDigit = DIGITS.get(romanNumeral.charAt(0));
        if (romanNumeral.length() == 1) {
            return currentDigit;
        }

        int nextDigit = DIGITS.get(romanNumeral.charAt(1));
        if (currentDigit < nextDigit) {
            currentDigit *= -1;
        }

        return currentDigit + fromRoman(romanNumeral.substring(1));
    }

}
