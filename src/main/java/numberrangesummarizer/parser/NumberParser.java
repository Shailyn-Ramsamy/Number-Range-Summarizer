package numberrangesummarizer.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class NumberParser {

    public Collection<Integer> parse(String input) {
        if (input == null) return new ArrayList<>();

        String[] vals = input.split(",");

        return Arrays.stream(vals)
                .map(String::trim)
                .map(this::parseIntSafe)
                .filter(n -> n != null)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Integer parseIntSafe(String val) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println("Skipping invalid number: " + val);
            return null;
        }
    }
}

