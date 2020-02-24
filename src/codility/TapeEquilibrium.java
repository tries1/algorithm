package codility;

public class TapeEquilibrium {
    //TODO 효울성 실패함
    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        System.out.println(solution(A));
    }

    // 정수로 이루어진 배열A
    // P가 주어질때 A part, B part를 각각 구한후 그 차이가 가장 작은수를 구하라
    // P는 계속 증가시키지만, A.length - 1 보다는 작아야함
    public static int solution(int[] A) {
        //|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

        /*
            P = 1, difference = |3 − 10| = 7
            P = 2, difference = |4 − 9| = 5
            P = 3, difference = |6 − 7| = 1
            P = 4, difference = |10 − 3| = 7
        */

        int P = 1, less = Integer.MAX_VALUE, a, b;
        while (P < A.length) {
            a = 0;
            b = 0;

            for (int i = 0; i <= A.length - 1; i++) {

                //A part
                if (i <= P - 1) {
                    a += A[i];
                }

                //B part
                if (i < A.length - P) {
                    b += A[P + i];
                }
            }

            if (less > Math.abs(a - b)) {
                less = Math.abs(a - b);
            }

            if (less <= 1){
                break;
            }

            P++;
        }

        return less;
    }

    /*public static int solution(int[] A) {
        //|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

        *//*
            P = 1, difference = |3 − 10| = 7
            P = 2, difference = |4 − 9| = 5
            P = 3, difference = |6 − 7| = 1
            P = 4, difference = |10 − 3| = 7
        *//*

        int P = 1, less = Integer.MAX_VALUE, a, b;
        while (P < A.length) {
            a = 0;
            b = 0;

            //A part
            for (int i = 0; i <= P - 1; i++) {
                a += A[i];
            }

            //B part
            for (int i = P; i <= A.length - 1; i++) {
                b += A[i];
            }

            if (less > Math.abs(a - b)) {
                less = Math.abs(a - b);
            }

            P++;
        }

        return less;
    }*/
}
