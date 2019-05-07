package chapter01;

import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        min3();
    }

    public static void max3(){
        System.out.println("3개의 숫자중 높은숫자는?");

        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        int max = a;
        if(b > max) max = b;
        if(c > max) max = c;


        System.out.println("가장큰값 : " + max);
    }

    public static void max4(){
        System.out.println("4개의 숫자중 높은숫자는?");

        int a, b, c, d;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        int max = a;
        if(b > max) max = b;
        if(c > max) max = c;
        if(d > max) max = d;


        System.out.println("가장큰값 : " + max);
    }

    public static void min3(){
        System.out.println("3개의 숫자중 낮은숫자는?");

        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        int min = a;
        if(b < min) min = b;
        if(c < min) min = c;


        System.out.println("가장 낮은값 : " + min);
    }
}
