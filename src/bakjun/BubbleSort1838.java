package bakjun;

import java.util.Scanner;

public class BubbleSort1838 {
    public static void main(String[] args) {
        int temp;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int flag = 0;
            for (int j = 0; j < N - 1; j++) {
                if (A[j] > A[j + 1]) {
                    flag = 1;
                    temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
            if (flag == 0) {
                break;
            }

            count++;
        }

        System.out.println("count : " + count);
    }
}