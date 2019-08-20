package practice;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 선택정렬을 사용하여 내림차순으로 정렬하기
 * 1. 처음 idx부터 반복하기 시작
 * 2. 다음 값이 작거나, 크면 임시변수에 해당 idx저장
 * 3. 계속 반복하여 조건에 맞을때매자 임시변수에 저장
 * 4. 마지막으로 현재위치의 값과 임시변수의 idx값을 교
 */
public class SelectionSort {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String strNum = scanner.next();
        String strNum = "419898210";
        int[] nums = Arrays.stream(strNum.split("")).mapToInt(Integer::parseInt).toArray();
        int tempMaxIdx;

        for (int i = 0; i < nums.length - 1; i++) {
            tempMaxIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[tempMaxIdx] < nums[j]) {
                    tempMaxIdx = j;
                }
            }

            swap(nums, i, tempMaxIdx);
        }

        System.out.println(Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}