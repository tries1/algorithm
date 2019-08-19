package practice;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 32, 546, 65, 14, 12353, 52, 12, 3151, 612, 31, 4, 6, 8, 2, 213};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > 0; j--) {
                //System.out.println(arr[j]);
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
