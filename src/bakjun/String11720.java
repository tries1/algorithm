package bakjun;

import java.util.Scanner;

public class String11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String number = sc.next();

        Long sum = 0L;
        for (int i = 0; i < number.length(); i++) {
            sum += Long.parseLong(String.valueOf(number.charAt(i)));
        }

        System.out.println(sum);
    }
}
