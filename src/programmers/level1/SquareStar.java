package programmers.level1;

import java.util.Scanner;

public class SquareStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuffer sb;
        for (int i = 0; i < b; i++) {
            sb = new StringBuffer();
            for (int j = 0; j < a; j++) {
                sb.append("*");
            }

            System.out.println(sb.toString());
        }
    }
}
