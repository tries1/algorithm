package bakjun;

import java.util.Arrays;
import java.util.Scanner;

public class NumberSort3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        sort(nums, 0, nums.length - 1);

        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sort(int[] arr, int left, int right) {
        if(left < right){
            int pivot = partition(arr, left, right);

            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while ((arr[left] < pivot) && (left < right)) left++;
            while ((arr[right] > pivot) && (left < right)) right--;

            if(left < right){
                swap(arr, left, right);
            }
        }


        return left;
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
