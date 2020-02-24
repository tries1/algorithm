package codility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ArrayRotation {
    public static void main(String[] args) {
        //int[] question = {3, 8, 9, 7, 6};
        int[] question = {};
        int times = 3;

        //9, 7, 6, 3, 8
        Arrays.stream(solution(question, times)).forEach(i -> System.out.print(i));
    }

    // 배열을 오른쪽으로 한칸씩 밀로
    // 마지막 위치의 배열은 처음으로 이동
    // 큐 이용해볼까?
    public static int[] solution(int[] A, int K) {
        if(A.length == 0){
            int[] empty = {};
            return empty;
        }

        LinkedList<Integer> tempQ = new LinkedList<>(Arrays.stream(A).boxed().collect(Collectors.toList()));
        for (int i = 0; i < K; i++) {
            tempQ.addFirst(tempQ.pollLast());
        }

        return tempQ.stream().mapToInt(Integer::intValue).toArray();
    }

    ;
}
