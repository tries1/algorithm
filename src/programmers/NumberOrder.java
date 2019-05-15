package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class NumberOrder {
    public static void main(String[] args) {
        //118372	873211
        long n = 118372;
        String order = Arrays.stream(String.valueOf(n).split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());

        System.out.println(Long.valueOf(order).longValue());
    }
}
