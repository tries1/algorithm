package codility;

import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) {
        int[] A = {2, 1};
        System.out.println(solution(A));
    }

    //정수로 이루어진 배열중, 중간에 빠진 숫자를 리턴
    //오름차순으로 정렬하고
    //for문을 돌면서 해당값이 다를때 그값을 리턴해보자
    public static int solution(int[] A) {
        if (A.length == 0) { return 1;}
        if (A.length == 1) { return (A[0] == 1) ? 2 : 1;}

        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if ((i + 1) != A[i]) {
                return A[i] - 1;
            }
        }

        return A[A.length-1] + 1;
    }
}
