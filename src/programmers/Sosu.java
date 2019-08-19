package programmers;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * <p>
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * <p>
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 * (1은 소수가 아닙니다.)
 * <p>
 * 제한 조건
 * n은 2이상 1000000이하의 자연수입니다.
 * 입출력 예
 * n	result
 * 10	4
 * 5	3
 * 입출력 예 설명
 * 입출력 예 #1
 * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
 * <p>
 * 입출력 예 #2
 * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
 */
public class Sosu {

    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    public static int solution(int n) {
        Function<Integer, Boolean> check = (x) -> IntStream.range(2, x).filter(i -> (x % i) == 0).findFirst().isPresent();
        Long count = IntStream.rangeClosed(2, n)
                .filter(i -> !check.apply(i))
                .count();

        return count.intValue();
    }
}
