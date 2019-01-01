package de.muspellheim.roman;

import java.text.*;
import java.util.stream.*;

public class RomanConverter {

    public static int fromRoman(String romanNumeral) throws ParseException {
        var numbers = new Parser().parse(romanNumeral);
        numbers = subtract(numbers);
        return numbers.sum();
    }

    private static IntStream subtract(IntStream numbers) {
        var a = numbers.toArray();
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                a[i] *= -1;
            }
        }
        return IntStream.of(a);
    }

    private static class Parser {

        private int index;

        private IntStream parse(String text) throws ParseException {
            var builder = IntStream.builder();
            for (index = 0; index < text.length(); index++) {
                char c = text.charAt(index);
                int n = mapFromRoman(c);
                builder.accept(n);
            }
            return builder.build();
        }

        private int mapFromRoman(char c) throws ParseException {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    throw new ParseException("not a roman digit: " + c, index);
            }
        }

    }

}
