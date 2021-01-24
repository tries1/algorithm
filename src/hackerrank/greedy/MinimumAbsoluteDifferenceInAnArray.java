package hackerrank.greedy;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInAnArray {
    public static void main(String[] args) {

        int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i+1]));
        }

        System.out.println(min);

    }
}
