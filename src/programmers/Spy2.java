package programmers;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Spy2 {
    public static void main(String[] args) {
        //expected 10
        //String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"smoky_makeup", "face"}};
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        //String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        Map<String, Long> map = Arrays.stream(clothes).collect(Collectors.groupingBy(it -> it[1], Collectors.counting()));

        Long total = 0L;
        for (Map.Entry<String, Long> it : map.entrySet()) {
            total = total + it.getValue();
        }

        System.out.println(total.intValue() + ", " + map.size() + ", " + clothes.length);
        return total.intValue() * map.size();
    }
}
