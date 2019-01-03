package de.muspellheim.roman;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.text.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for roman numerals converter")
class RomanConverterTests {

    @ParameterizedTest(name = "[{index}] Convert from roman numeral {0} to arabic numeral {1}")
    @CsvSource({
            "M, 1000", // nur eine römische Ziffer
            "XVI, 16", // nur Addition von Ziffernwerten
            "MCDXCII, 1492",
            "MCMLXXXIV, 1984",
    })
    void convertFromRomanNumeralToArabicNueral(String romanNumeral, int arabicNumeral) throws ParseException {
        assertEquals(arabicNumeral, RomanConverter.fromRoman(romanNumeral));
    }

}
