package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPickPlus {
    public static void main(String[] args) {

        int[] numbers = {2, 1, 3, 4, 1};
        int[] result = solution(numbers);

        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }

                result.add(numbers[i] + numbers[j]);
            }
        }


        return result.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}
