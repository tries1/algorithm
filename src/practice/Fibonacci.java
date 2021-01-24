package practice;

public class Fibonacci {

    static long[] memo = new long[10000];
    public static long fibo(long n){
        if (n == 1) return 1;
        if (n == 2) return 1;

        int idx = Long.valueOf(n).intValue();
        if (memo[idx] == 0){
            memo[idx] = fibo(n - 1) + fibo(n - 2);
        }

        return memo[idx];
    }

    public static void main(String[] args) {
        System.out.println(fibo(100));
    }
}
