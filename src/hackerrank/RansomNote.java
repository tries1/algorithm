package hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {
    public static void main(String[] args) {
        String magazine = "ive got a lovely bunch of coconuts";
        String note = "ive got some coconuts";

        Map<String, Long> magazineSet = Arrays.stream(magazine.split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        String[] noteArr = note.split(" ");

        boolean result = false;
        for (String word : noteArr) {
            if(magazineSet.containsKey(word) && magazineSet.get(word).longValue() > 0l){
                result = true;
                magazineSet.put(word, magazineSet.get(word).longValue() - 1);
            } else {
                System.out.println("No");
                result = false;
                break;
            }

        }

        if(result){
            System.out.println("Yes");
        }
    }
}
