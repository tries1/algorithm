package codility;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args) {

        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int answer = 0;

        Arrays.sort(A);

        int before = -1;
        for (int i = 0; i < A.length; i++) {
            if (before != A[i]) {
                before = A[i];
                answer++;
            }
        }

        return answer;
    }
}
