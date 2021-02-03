package practice;

import java.util.LinkedList;

public class JavaLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> num = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            num.add((int) Math.round(Math.random() * 1000));
        }

        num.stream().forEach(System.out::println);
    }
}
