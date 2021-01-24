package hackerrank;

import java.util.Arrays;

/**
 * 롤러코스터 대기열에 사람들이 줄서있다.
 * 사람들은 각각 고유한 번호를 순서대로 가지고있다.
 * <p>
 * 어떤 사람이든 앞사람에게 뇌물을 주어 순서를 바꿀수있다.
 * <p>
 * 1. 주어진 배열에 도달하기위한 최소 뇌물수를 출력
 * 2. 어떤 사람이 2번이상 뇌물을 받았다면 "Too chaotic" 출력
 *
 * 버블소트 이용해서, 정렬 카운트 생각을 못함
 */
public class NewYearChaos {
    public static void main(String[] args) {
        //int arr[] = {2, 1, 5, 3, 4};
        //int arr[] = {2, 5, 1, 3, 4};
        int arr[] = {1, 2, 5, 3, 7, 8, 6, 4};
        minimumBribes(arr);
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void minimumBribes(int[] q) {
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        int bribeCount = 0;
        for (int i = 0; i < q.length - 1; i++) {
            if (i + 1 != q[i]) {
                for (int j = q.length - 1; j > 0; j--) {
                    //System.out.println(arr[j]);
                    if (q[j - 1] > q[j]) {
                        swap(q, j, j - 1);
                        bribeCount++;
                    }
                }
            }
        }

        System.out.println(bribeCount);
    }
}
