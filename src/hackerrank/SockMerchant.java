package hackerrank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SockMerchant {


    public static void main(String[] args) {
        //3
        //int n = 9;
        //int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};

        //4
        int n = 10;
        int[] ar = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};


        System.out.println(solution(n, ar));
    }

    public static int solution(int n, int[] ar) {
        Map<Integer, Long> map = Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        return map.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(count -> ((count % 2) == 0) ? count / 2 : (count - 1) / 2)
                .reduce((integer, integer2) -> integer + integer2)
                .map(Long::intValue)
                .orElse(0);
    }
}
