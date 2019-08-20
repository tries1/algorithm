package bakjun;

/**
 * 최대 공약수
 * 1. b가 a로 나누어 떨어지면 두 수의 최대공약수는 b이다.
 * 2. a를 b로 나누었을때 나머지가 r이면, 두수의 최대공약수는 r과 b의 최대공약수와 같다.
 */
public class GreatCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(60, 48));
    }

    public static int gcd(int a, int b) {
        return a % b != 0 ? gcd(b, a % b) : b;
    }
}
