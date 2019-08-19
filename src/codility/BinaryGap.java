package codility;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryGap {
    public static void main(String[] args) {

        int question = 6;
        System.out.println(solution(question));
    }

    public static int solution(int n) {
        String binary = Integer.toBinaryString(n);
        String[] arr = binary.substring(1).split("1");
        System.out.println(binary);
        System.out.println("10001001001011100100_2");
        System.out.println(Arrays.stream(arr).collect(Collectors.joining(",")));



        if (arr.length > 1) {
            return Arrays.stream(arr)
                    .map(String::length)
                    .max(Integer::compareTo)
                    .orElse(0);
        } else {
            return 0;
        }
    }
}
