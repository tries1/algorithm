package hackerrank;

import java.util.Arrays;
import java.util.function.Function;

public class RepeatedString {
    public static void main(String[] args) {
        // 7
        //String s = "aba";
        //long n = 10;

        String s = "a";
        long n = 100000000;

        System.out.println(solution(s, n));
    }

    public static long solution(String s, long n) {
        long multi = n / s.length();
        long leftCnt = n % s.length();

        Function<String, Long> aCnt = (str) -> Arrays.stream(str.split(""))
                .filter(it -> "a".equals(it))
                .count();

        return ((aCnt.apply(s) * multi) + aCnt.apply(s.substring(0, Math.toIntExact(leftCnt))));
    }
}
