package test;

import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {

        //int[] arr = {1, 2, 3};
        int[] arr = {3, 30, 34, 5, 9};
        int n = arr.length;
        int r = 5;
        int[] combArr = new int[n];

        doCombination(combArr, n, r, 0, 0, arr);
        Arrays.stream(combArr).forEach(System.out::print);
    }

    public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
        //System.out.println("=> " + n + " " + r + " " + index + " " + target);

        // r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
        if (r == 0) {
            System.out.println(Arrays.toString(combArr));
            for (int i = 0; i < index; i++) {
                System.out.print(arr[combArr[i]] + " ");
            }

            System.out.println();

            //끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
        } else if (target == n) {

            return;

        } else {
            combArr[index] = target;
            // (i) 뽑는 경우
            // 뽑으니까, r-1
            // 뽑았으니 다음 index + 1 해줘야 함
            doCombination(combArr, n, r - 1, index + 1, target + 1, arr);

            //(ii) 안 뽑는경우
            // 안뽑으니까 그대로 r
            // 안뽑았으니, index는 그대로!
            // index를 그대로하면, 예를 들어 현재 1번 구슬을 comArr에 넣엇어도 다음 재귀에 다시 엎어쳐서 결국 1구슬을 뽑지 않게 된다.
            doCombination(combArr, n, r, index, target + 1, arr);
        }
    }
}
