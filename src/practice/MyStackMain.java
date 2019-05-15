package practice;

import java.util.Stack;
import java.util.stream.IntStream;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack<Integer> integerMyStack = new MyStack<>();
        IntStream.rangeClosed(1, 10).forEach(i -> integerMyStack.push(i));
        System.out.println("before : " + integerMyStack.size());
        System.out.println("peek : " + integerMyStack.peek());
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println("pop : " + integerMyStack.pop()));
        System.out.println("after : " + integerMyStack.size());
        System.out.println("capacity : " + integerMyStack.capacity());

        System.out.println("===========================================================");
        System.out.println("===========Java Stack과 비교하여 동작이라도 같은지 확인============");
        System.out.println("===========================================================");

        Stack<Integer> integerStack = new Stack<>();
        IntStream.rangeClosed(1, 10).forEach(i -> integerStack.push(i));
        System.out.println("before : " + integerStack.size());
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println("pop : " + integerStack.pop()));
        System.out.println("after : " + integerStack.size());
        System.out.println("capacity : " + integerStack.capacity());
    }
}
