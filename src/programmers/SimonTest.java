package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimonTest {
    public static void main(String[] args) {
        //The lines are printed in reverse order.
        String question = "The lines are printed in reverse order.";
        //String answer = "In the are lines order printed reverse.";


        Map<String, Integer> wordsMap = Arrays.stream(question.split(" "))
                .map(s -> s.replace(".", "").toLowerCase())
                .collect(Collectors.toMap(Function.identity(), o -> o.length()));

        //wordsMap.entrySet().stream().forEach(s -> System.out.println(s.getKey() + " : " + s.getValue()));
        //System.out.println("--------------------");
        String answer = wordsMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(" "));

        answer = answer.substring(0, 1).toUpperCase() + answer.substring(1) + ".";
        System.out.println(answer);
    }
}
