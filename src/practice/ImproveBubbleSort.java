package practice;

import java.util.Arrays;

public class ImproveBubbleSort {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 32, 546, 65, 14, 12353, 52, 12, 3151, 612, 31, 4, 6, 8, 2, 213};
        sort1(arr1);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 32, 546, 65, 14, 12353, 52, 12, 3151, 612, 31, 4, 6, 8, 2, 213};
        sort2(arr2);

        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 32, 546, 65, 14, 12353, 52, 12, 3151, 612, 31, 4, 6, 8, 2, 213};
        sort3(arr3);
    }

    //기본적인 버블정렬
    public static void sort1(int[] arr){
        System.out.println("----------sort1 START-------------");
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                count++;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        System.out.println("count : " + count);
        System.out.println("----------sort1 END-------------");
    }

    public static void sort2(int[] arr){
        System.out.println("----------sort2 START-------------");
        int count = 0;
        int exchange = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                count++;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    exchange++;
                }
            }

            if(exchange == 0){
                break;
            }

            exchange = 0;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        System.out.println("count : " + count);
        System.out.println("----------sort2 END-------------");
    }

    public static void sort3(int[] arr){
        System.out.println("----------sort3 START-------------");
        int k = 0;
        int count = 0;
        int exchange = 0;

        while (k < arr.length - 1){
            int last = arr.length - 1;
            for (int j = arr.length - 1; j > k; j--) {
                count++;
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                    exchange++;
                }
            }

            if(exchange == 0){
                break;
            }

            exchange = 0;
            k = last;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        System.out.println("count : " + count);
        System.out.println("----------sort3 END-------------");
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
