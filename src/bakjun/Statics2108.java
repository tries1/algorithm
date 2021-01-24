package bakjun;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Statics2108 {


    /**
     * 산술평균 : N개의 수들의 합을 N으로 나눈 값
     * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
     * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
     * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
     */
    public static void main(String[] args) {
        //2 2 1 10
        int[] A = {1, 3, 8, -2, 2};

        int a1 = 0, a2 = 0, a3 = 0, a4 = 0;
        for (int i = 0; i < A.length; i++) {
            a1 += A[i];
        }

        //산술평균 : N개의 수들의 합을 N으로 나눈 값
        System.out.print(Arrays.stream(A).sum() / A.length);

        //중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        int[] mid = Arrays.stream(A).sorted().toArray();
        System.out.print(mid[A.length / 2]);

        //최빈값 : N개의 수들 중 가장 많이 나타나는 값
        Map<Integer, Long> map = Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> (o1.getValue() > o2.getValue()) ? 1 : 0)
                .limit(2)
                .collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue()));

        
        /*System.out.print(Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
                .entrySet().stream()
                .sorted((o1, o2) -> (o1.getValue() > o2.getValue()) ? 1 : 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(1));*/

        //범위 : N개의 수들 중 최댓값과 최솟값의 차이
        System.out.print(Arrays.stream(A).max().orElse(0) - Arrays.stream(A).min().orElse(0));
    }


}
