package programmers.level1;

import java.util.Arrays;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        //최소공배수 : 각 N, M의 배수가 동일한 수

        //최대공약수 :

        int n = 2;
        int m = 5;
        int[] answer = {gcd(n, m), lcm(n, m)};
        Arrays.stream(answer).forEach(value -> System.out.print(value + ""));
    }

    public static int gcd(int a, int b) {
        int temp;
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
