package codility;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EquiLeader {
    public static void main(String[] args) {
        int[] A = {4, 3, 4, 4, 4, 2};
        System.out.println(solution(A));

    }

    //풀이 : 가장많이 차지하는 값을 찾고
    //배열을 둘로 나누면서 Leader이 각각 많이 차지하고 있는 경우의수를 리턴
    public static int solution(int[] A) {
        int answer = 0;
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
            int[] a = Arrays.copyOfRange(A, 0, i + 1);
            int[] b = Arrays.copyOfRange(A, i + 1, A.length);

            long aCnt = Arrays.stream(a).filter(it -> it == dominator).count();
            long bCnt = Arrays.stream(b).filter(it -> it == dominator).count();

            if (aCnt > a.length / 2 && bCnt > b.length / 2) {
                answer++;
            }
        }


        return answer;
    }
}
