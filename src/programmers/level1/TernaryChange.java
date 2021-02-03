package programmers.level1;

public class TernaryChange {
    public static void main(String[] args) {
        int n = 125;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return Integer.parseInt(cardConvRev(n, 3).reverse().toString(), 3);
    }

    public static StringBuffer cardConvRev(int value, int n) {
        StringBuffer sb = new StringBuffer();
        while (value >= 1) {
            sb.insert(0, value % n);
            value /= n;
        }
        return sb;
    }
}
