package programmers.level1;

import java.util.Arrays;

public class NumberSorting {
    public static void main(String[] args) {

        int[] result = solution(12345);
        Arrays.stream(result).forEach(value -> System.out.print(value + " "));
    }

    public static int[] solution(long n) {
        String[] arr = String.valueOf(n).split("");
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[arr.length - (i + 1)] = Integer.parseInt(arr[i]);
        }

        return result;
    }
}
