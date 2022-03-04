package org.utils.stringutils;

import org.junit.jupiter.api.Test;
import org.utils.exceptions.InvalidStringInputException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {
    // THREE-PART FORMAT:
    // methodBeingTested_inputCondition_expectedOutcome

    // Happy path
    @Test
    void splitString_oneSeparator_expectTwoParts() throws InvalidStringInputException {
        String inputString = "Hello|World";
        String separator = "\\|";
        StringParser stringParser = new StringParser();
        ArrayList<String> stringParts = stringParser.splitString(inputString, separator);   // Call the method

        assertEquals(2, stringParts.size());
    }

    // Negative test
    // If input is NULL?
    @Test
    void splitString_nullInput_expectException() {
        String inputString = null;
        String separator = "\\|";
        StringParser stringParser = new StringParser();
//        ArrayList<String> stringParts = stringParser.splitString(inputString, separator);   // Call the method

//        assertEquals(0, stringParts.size()); // results in NPE

        // Proper way for controlled exception throwing checking
        assertThrows(InvalidStringInputException.class,
                ()->stringParser.splitString(inputString,separator));
    }
}