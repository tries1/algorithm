package chapter01;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {

        System.out.println("하노이의 탑");
        System.out.println("원반개수 : ");
        //Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();

        move(3, 1, 3);
    }

    static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }

        System.out.println(String.format("원반[%s]을 %s기둥에서 %s기둥으로 옮김", no, x, y));

        if (no > 1) {
            move(no - 1, 6 - x - y, y);
        }
    }
}
