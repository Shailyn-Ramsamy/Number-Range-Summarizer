package numberrangesummarizer.utils;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeFormatterTest {

    private final RangeFormatter formatter = new RangeFormatter();

    @Test
    void summarize_shouldHandleSingleNumber() {
        List<Integer> input = Collections.singletonList(5);
        String result = formatter.summarize(input);
        assertEquals("5", result);
    }

    @Test
    void summarize_shouldCombineConsecutiveNumbersIntoRanges() {
        List<Integer> input = Arrays.asList(1, 2, 3, 5, 6, 8);
        String result = formatter.summarize(input);
        assertEquals("1-3, 5-6, 8", result);
    }

    @Test
    void summarize_shouldHandleNonConsecutiveNumbers() {
        List<Integer> input = Arrays.asList(2, 4, 6, 8);
        String result = formatter.summarize(input);
        assertEquals("2, 4, 6, 8", result);
    }

    @Test
    void summarize_shouldHandleAllConsecutiveNumbers() {
        List<Integer> input = Arrays.asList(10, 11, 12, 13, 14);
        String result = formatter.summarize(input);
        assertEquals("10-14", result);
    }

    @Test
    void summarize_shouldHandleUnsortedInput() {
        List<Integer> input = Arrays.asList(5, 3, 4, 1, 2);  
        String result = formatter.summarize(input);
        assertEquals("5, 3-4, 1-2", result);
    }

    @Test
    void summarize_shouldHandleDuplicateNumbers() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 4);
        String result = formatter.summarize(input);
        assertEquals("1-2, 2-4", result);
    }
}
