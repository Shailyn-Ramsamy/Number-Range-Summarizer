package numberrangesummarizer.models;

public class Range {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        if (end < start) {
            throw new IllegalArgumentException("End of range cannot be less than start.");
        }
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isSingleValue() {
        return start == end;
    }

    public boolean isConsecutive(int number) {
        return number == end + 1;
    }

    public Range extendTo(int number) {
        return new Range(start, number);
    }

    @Override
    public String toString() {
        return isSingleValue() ? String.valueOf(start) : start + "-" + end; // This is what creates the range
    }
}
