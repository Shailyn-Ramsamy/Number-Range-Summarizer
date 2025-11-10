package numberrangesummarizer.utils;

import numberrangesummarizer.models.Range;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

public class RangeFormatter {

    public String summarize(Collection<Integer> input) {
        if (input == null || input.isEmpty()) return "No numbers provided.";

        List<Integer> list = new ArrayList<>(input);
        List<Range> ranges = new ArrayList<>();

        Range current = new Range(list.get(0), list.get(0));

        for (int i = 1; i < list.size(); i++) {
            int n = list.get(i);
            if (current.isConsecutive(n)) {
                current = current.extendTo(n);
            } else {
                ranges.add(current);
                current = new Range(n, n);
            }
        }

        ranges.add(current);

        StringJoiner joiner = new StringJoiner(", ");
        for (Range r : ranges) {
            joiner.add(r.toString());
        }

        return joiner.toString();
    }
    
}
