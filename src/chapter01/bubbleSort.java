package chapter01;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {32, 54, 1, 325, 65, 3, 32, 12, 15, 17};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j-1, j);
                }
            }
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }

    public static void swap(int[] arr, int x, int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }
}
