package codility;

public class MaxProductOfThree {
    public static void main(String[] args) {
        //int[] A = {-3, 1, 2, -2, 5, 6};
        int[] A = {-10, -2, -4};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        int tmp;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    tmp = A[i] * A[j] * A[k];

                    if (max < tmp) {
                        max = tmp;
                    }
                }
            }
        }

        return max;
    }
}
