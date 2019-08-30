package practice;

/**
 * fibonacci
 * use memoization
 */
public class DynamicProgramming1 {
    public static void main(String[] args) {
        //1 1 2 3 5 8 13 21 34 55
        System.out.println(fibonacci(100));
    }

    public static long[] memo = new long[1000];
    public static long fibonacci(long n){
        if (n == 1) { return 1;}
        if (n == 2) { return 1;}

        if(memo[Long.valueOf(n).intValue()] == 0){
            memo[Long.valueOf(n).intValue()] = fibonacci(n - 2) + fibonacci(n - 1);
        }
        return memo[Long.valueOf(n).intValue()];
    }
}
