package bakjun;

import java.util.Scanner;
import java.util.Arrays;

public class Sort2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }


        Arrays.stream(A).distinct().sorted().forEach(System.out::println);
    }
}