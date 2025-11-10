package numberrangesummarizer;

import numberrangesummarizer.parser.NumberParser;
import numberrangesummarizer.utils.RangeFormatter;
import java.util.Collection;

public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer {

    private final NumberParser parser = new NumberParser();
    private final RangeFormatter formatter = new RangeFormatter();

    @Override
    public Collection<Integer> collect(String input) {
        return parser.parse(input);
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return formatter.summarize(input);
    }
}
