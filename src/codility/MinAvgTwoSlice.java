package codility;

public class MinAvgTwoSlice {

    public static void main(String[] args) {

        int[] A = {4, 2, 2, 5, 1, 5, 8};

        //1
        System.out.println(solution(A));
    }

    /*
        A[0] = 4
        A[1] = 2
        A[2] = 2
        A[3] = 5
        A[4] = 1
        A[5] = 5
        A[6] = 8
        contains the following example slices:

        slice (1, 2), whose average is (2 + 2) / 2 = 2;
        slice (3, 4), whose average is (5 + 1) / 2 = 3;
        slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

        (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1)

        //(3, 4)
        (5 + 1) / 4-3 + 1

        //(1, 2)
        (2 + 2) / 2-1 + 1
     */

    //주어진 배열 A를 구간별로 잘랐을때 가장작은 최소값을 구하는 문제
    public static int solution(int[] A) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = 1; j < A.length; j++) {
                sum += A[j];
            }
        }

        return 0;
    }
}
