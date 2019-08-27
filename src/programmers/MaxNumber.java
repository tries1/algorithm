package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * <p>
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 * <p>
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * <p>
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 * <p>
 * 입출력 예
 * numbers	return
 * [6, 10, 2]	6210
 * [3, 30, 34, 5, 9]
 */
public class MaxNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        //9534330
        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {
        Map<Integer, List<Integer>> group = new HashMap<>();
        Arrays.stream(numbers).forEach(i -> setGroup(group, intLength(i), i));

        return group.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .map(integers -> integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()))
                .map(integers -> integers.stream().map(String::valueOf).collect(Collectors.joining()))
                .collect(Collectors.joining());
    }

    public static void setGroup(Map<Integer, List<Integer>> group, Integer groupNum, Integer value) {
        if (group.containsKey(groupNum)) {
            group.get(groupNum).add(value);
        } else {
            List<Integer> integers = new ArrayList<>();
            integers.add(value);
            group.put(groupNum, integers);
        }
    }

    public static int intLength(int x) {
        return (int) (Math.log10(x) + 1);
    }
}


