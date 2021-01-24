package codility;

public class FibFrog {

    public static void main(String[] args) {
        //3
        int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};

        //System.out.println(solution(A));
        System.out.println(fibo(0));
        System.out.println(fibo(1));
        System.out.println(fibo(2));
        System.out.println(fibo(3));
        System.out.println(fibo(4));
        System.out.println(fibo(5));
    }

    static long[] memo = new long[10000];
    public static long fibo(long n){
        if (n == 0) return 0;
        if (n == 1) return 1;

        int idx = Long.valueOf(n).intValue();
        if (memo[idx] == 0){
            memo[idx] = fibo(n - 1) + fibo(n - 2);
        }

        return memo[idx];
    }

    /*
     F(0) = 0
     F(1) = 1
     F(M) = F(M - 1) + F(M - 2) if M >= 2
     */
    public static int solution(int[] A) {
        int answer = 0;
        int canJumpNum;
        for (int i = 0; i < A.length; i++) {
            canJumpNum = Long.valueOf(fibo(i)).intValue();

            if(A[i + canJumpNum] == 1){
                i += canJumpNum;
                answer++;
            }
        }

        return answer;
    }
}
