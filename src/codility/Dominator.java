package codility;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Dominator {
    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        System.out.println(solution(A));

    }

    //배열 절반이상을 차지하는 요소를 찾는 문
    //풀이 : 각요소를 map으로 집합을 만들고
    //배열 절반값보다 큰요소를 가지고 있는 값중 첫번째 값을 dominator로 지정
    //그후 배열A에서 해당값을 가지는 첫번째 index를 리턴
    public static int solution(int[] A) {
        Map<Integer, Long> map = Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        int dominator = map.entrySet().stream()
                .filter(entry -> entry.getValue() > A.length / 2)
                .sorted((o1, o2) -> (o1.getValue() > o2.getValue()) ? 1 : -1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);

        for (int i = 0; i < A.length; i++) {
            if(A[i] == dominator){
                return i;
            }
        }

        return -1;
    }
}
