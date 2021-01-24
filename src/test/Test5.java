package test;

import java.util.Arrays;

public class Test5 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 2, 2, 4};

        int n = arr.length / 2;
        arr = Arrays.stream(arr).distinct().boxed().sorted().mapToInt(Integer::intValue).toArray();

        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[0] != arr[i + 1]) {
                count++;
            }

            if (count == n) {
                break;
            }
        }

        System.out.println(count);
    }
}
