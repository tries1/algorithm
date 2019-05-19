package chapter01;

import java.util.stream.IntStream;

public class Factorial {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(factorial(n));
        System.out.println(factorialWithout(n));
    }

    static int factorial(int n) {
        if (n > 0) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    static int factorialWithout(int n) {
        return IntStream.rangeClosed(1, n)
                .reduce((x, y) -> x * y)
                .orElse(0);
    }
}
