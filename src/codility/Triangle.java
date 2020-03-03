package codility;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        //1
        //int[] A = {10, 2, 5, 1, 8, 20};
        //0
        int[] A = {10, 50, 5, 1};

        System.out.println(solution(A));
    }

    //A[P] + A[Q] > A[R],
    //A[Q] + A[R] > A[P],
    //A[R] + A[P] > A[Q].
    //배멸 A가 주어졌을때 위 조건에 만족하는 삼각형이 있으면1  아니면0(P, Q, R)
    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length-2; i++) {
            //if (A[i] + A[i + 1] > A[i + 2] && A[i + 1] + A[i + 2] > A[i] && A[i + 2] + A[i] > A[i + 1]) {
            //if (A[i] + A[i + 1] > A[i + 2]) {
            if (A[i + 1] > A[i + 2] - A[i]) {
                return 1;
            }
        }

        return 0;
    }
}
