package numberrangesummarizer;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        NumberRangeSummarizerImplementation summarizer = new NumberRangeSummarizerImplementation();

        Collection<Integer> collecty = summarizer.collect(input);

        String ans = summarizer.summarizeCollection(collecty);

        System.out.println("==========Output==========");

        System.out.println(ans);
    }
    
}
