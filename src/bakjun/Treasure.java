package bakjun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
5
1 1 1 6 0
2 7 8 3 1
 */
public class Treasure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            b[i] = scanner.nextInt();
        }

        int[] a1 = Arrays.stream(a).sorted().toArray();
        int[] b1 = Arrays.stream(b).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int sum = 0;
        for (int i = 0; i < a1.length; i++) {
            sum += a1[i] * b1[i];
        }

        System.out.println(sum);
    }
}
