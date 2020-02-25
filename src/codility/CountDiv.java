package codility;

public class CountDiv {

    public static void main(String[] args) {
        int A = 6;
        int B = 11;
        int K = 2;
        // 3
        long startTime = System.currentTimeMillis();
        System.out.println(solution(A, B, K));
        System.out.println((System.currentTimeMillis() - startTime) + " ms");
    }

    public static int solution(int A, int B, int K) {
        // 모범답안
        /*
        if (A == 0) {
            return B / K + 1;
        } else {
            return B / K - (A - 1) / K;
        }
        */

        int answer = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                answer++;
                i++;
            }
        }

        return answer;
    }
}
