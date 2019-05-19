package chapter01;

public class EuclidGCD {
    public static void main(String[] args) {
        int x = 22;
        int y = 8;
        System.out.println(gcd(x, y));
    }

    static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    static int gcdWithout(int x, int y) {
        int r = 0;

        while (r > 0) {

        }
        return r;
    }
}
