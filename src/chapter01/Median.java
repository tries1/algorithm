package chapter01;

import java.util.Scanner;

public class Median {
    public static void main(String[] args) {
        System.out.println("중간 값 구하기~");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println("중간값은 : " + mid(a, b, c));
    }

    public static int mid(int a, int b, int c) {

        //a가 중간일경우
        if (b > a && a > c || c > a && a > b) return a;

        //b가 중간일경우
        if (c > b && b > a || a > b && b > c) return b;

        //c가 중간일경우
        if (a > c && c > b || b > c && c > a) return c;

        return 0;
    }
}