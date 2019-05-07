package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 약수 : 어떤수로 나누었을때 0으로 떨어지는수
 * 10 : 1 2 5 10
 */
public class Yaksu {
    public static void main(String[] args) {

        Arrays.stream(solution(10)).forEach(System.out::println);
    }

    public static int[] solution(int num) {
        return IntStream.rangeClosed(1, num)
                .filter(i -> (num % i) == 0)
                .toArray();


        /*List<Integer> integers = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if((num % i) == 0){
                integers.add(i);
            }
        }

        return integers.stream().mapToInt(i->i).toArray();*/
    }
}
