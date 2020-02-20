package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = 1;
        long b = 2;
        long c = 3;
        long d = 4;
        long e = 5;

        long min = 0, max = 0;
        long[] ints = {a, b, c, d, e};

        long maxNum = Arrays.stream(ints).max().orElse(0);
        long minNum = Arrays.stream(ints).min().orElse(0);

        max = Arrays.stream(ints).filter(value -> value != minNum).sum();
        min = Arrays.stream(ints).filter(value -> value != maxNum).sum();

        System.out.println(min + " " + max);
    }
}
