package bakjun;

import java.util.Arrays;

/**
 * Quick osrt
 * 1. 배열내에서 기준이 되는 값을 선택
 * 2. 기준값을 기준으로 왼쪽은 기준값보다 작은값, 오른쪽은 큰값으로 배치
 * 3. 2번으로 '분할'이 끝났으면 해당 pivot을 기준으로 좌, 우 sort 수행
 * 4. 3번 이후 좌, 우 sort를 재귀적으로 수행
 */
public class QuickSortSample {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }*/

        int N = 8;
        //int[] nums = {69, 10, 30, 2, 16, 8, 31, 22};
        int[] nums = {6,9,7,8,3123,414,152,31,513,42141,543,665,7867,876,96,80,79078,45,1,4,2,3,10};
        //int[] nums = { 69, 10, 30, 2, 16, 8, 31, 22 };

        quickSort(nums, 0, nums.length - 1);
        System.out.println("\n\nResult ==========> ");
        Arrays.stream(nums).forEach(i -> System.out.print(i + ","));
    }

    // 값을 비교하고 로우와 하이를 이동시키면서 값의 교환이 이루어지는 함수
    public static int partition(int arr[], int left, int right) {

        int pivot = arr[(left + right) / 2];

        while (left < right) {
            while ((arr[left] < pivot) && (left < right)) left++;
            while ((arr[right] > pivot) && (left < right)) right--;

            System.out.println(String.format("left : %s[%s], right : %s[%s]",left, arr[left], right, arr[right]));
            if (left < right) {
                swap(arr, left, right);
            }
        }

        return left;
    }


    public static void quickSort(int arr[], int left, int right) {

        if (left < right) {
            // 값을 비교하고 로우와 하이를 이동시키면서 값의 교환이 이루어지는 함수
            int pivotNewIndex = partition(arr, left, right);
            // quick sort의 설명중
            // 자주 나오는 '재귀', '분할' 이라고 설명되어지는 부분이다.
            quickSort(arr, left, pivotNewIndex - 1);
            quickSort(arr, pivotNewIndex + 1, right);
        }

    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
