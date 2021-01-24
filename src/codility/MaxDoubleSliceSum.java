package codility;

public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solution(A));

    }

    //풀이 :

    /**
     * double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
     * double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
     * double slice (3, 4, 5), sum is 0.
     * <p>
     * A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1]
     * <p>
     * A[X + 1] + A[X + 2] + ... + A[Y − 1]
     * A[Y + 1] + A[Y + 2] + ... + A[Z − 1]
     * <p>
     * 0 ≤ X < Y < Z < N
     */
    public static int solution(int[] A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int X = 0; X < A.length; X++) {
            for (int Y = X + 1; Y < A.length; Y++) {
                for (int Z = Y + 1; Z < A.length; Z++) {
                    System.out.printf("%s%s%s", X, Y, Z);
                    System.out.println();
                    /*if(X < Y){
                        sum += A[X+1];
                    }

                    if(Y < Z){
                        sum += A[Y+1];
                    }*/
                }
            }

            if (max < sum) {
                max = sum;
            }
        }

        return max;
    }
}
