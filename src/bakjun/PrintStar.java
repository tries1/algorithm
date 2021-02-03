package bakjun;

import java.util.Scanner;

public class PrintStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuffer sb;
        for (int i = 1; i <= N; i++) {
            sb = new StringBuffer();
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }

            System.out.println(sb.toString());
        }
    }
}
