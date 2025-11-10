package test.numberrangesummarizer.parser;

import org.junit.jupiter.api.Test;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

public class NumberParserTest {

    private final NumberParser parser = new NumberParser();

    @Test
    void parsesValidCommaSeparatedNumbers() {
        Collection<Integer> result = parser.parse("1,2,3,4,5");
        assertEquals(5, result.size());
        assertTrue(result.contains(3));
    }

    @Test
    void trimsWhitespaceAndParsesCorrectly() {
        Collection<Integer> result = parser.parse(" 1 ,  2, 3 ");
        assertEquals(3, result.size());
    }

    @Test
    void skipsInvalidNumbers() {
        Collection<Integer> result = parser.parse("1,a,3");
        assertEquals(2, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(3));
    }

    @Test
    void returnsEmptyCollectionOnNullOrBlankInput() {
        assertTrue(parser.parse(null).isEmpty());
        assertTrue(parser.parse("   ").isEmpty());
    }
}
