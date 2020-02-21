package hackerrank;

import java.util.Scanner;

/**
 * ar의 갯수만큼 반복하면서, 각각 앞에서부터 순차대로 숫자를 제외해가며 sum을 하고
 * min, max를 구하여 반영한다.
 */
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = 5;
        long b = 5;
        long c = 5;
        long d = 5;
        long e = 5;

        long min = Long.MAX_VALUE, max = 0, sum;
        long[] ints = {a, b, c, d, e};

        for (int i = 0; i < ints.length; i++) {
            sum = 0;
            for (int j = 0; j < ints.length; j++) {
                if (i != j) {
                    sum += ints[j];
                }
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        System.out.println(min + " " + max);
    }
}
