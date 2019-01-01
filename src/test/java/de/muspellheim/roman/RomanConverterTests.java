package de.muspellheim.roman;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.text.*;

import static org.junit.jupiter.api.Assertions.*;

class RomanConverterTests {

    @Test
    void convert() throws ParseException {
        assertEquals(4, RomanConverter.fromRoman("IV"));
    }

    @ParameterizedTest(name = "[{index}] Convert from roman numeral {0} to {1}")
    @CsvSource({
            "M, 1000", // nur eine römische Ziffer
            "XVI, 16", // nur Addition von Ziffernwerten
            "MCDXCII, 1492",
            "MCMLXXXIV, 1984",
    })
    void fromRomanNumerals(String romanNumeral, int translation) throws ParseException {
        assertEquals(translation, RomanConverter.fromRoman(romanNumeral));
    }

    @Test
    @DisplayName("XAI is not a roman numeral")
    void notARomanNumeral() {
        ParseException exception = assertThrows(ParseException.class, () -> {
            RomanConverter.fromRoman("XAI");
        });
        assertEquals("not a roman digit: A", exception.getMessage());
        assertEquals(1, exception.getErrorOffset());
    }

}
