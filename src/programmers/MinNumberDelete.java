package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 * <p>
 * 제한 조건
 * arr은 길이 1 이상인 배열입니다.
 * 인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
 * 입출력 예
 * arr	return
 * [4,3,2,1]	[4,3,2]
 * [10]	[-1]
 */
public class MinNumberDelete {
    public static void main(String[] args) {
        //int[] question = {4,3,2,1};
        int[] question = {3213,2312323,23112312,31244124,14124,123123,141412,3131,1};

        Arrays.stream(solution(question)).forEach(System.out::println);
    }

    public static int[] solution(int[] arr) {
        if(arr.length <= 1){
            return new int[]{-1};
        }

        List<Integer> toList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int at = 0;
        int count = 0;
        int tmpMin = toList.get(0);

        for (Integer i : toList) {
            if(tmpMin > i){
                tmpMin = i;
                at = count;
            }
            count++;
        }

        toList.remove(at);
        return toList.stream().mapToInt(Integer::intValue).toArray();
    }
}
