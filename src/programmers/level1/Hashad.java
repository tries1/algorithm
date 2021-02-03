package programmers.level1;

import java.util.Arrays;

/**
 * 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
 * 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
 * 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
 * <p>
 * 제한 조건
 * x는 1 이상, 10000 이하인 정수입니다.
 * 입출력 예
 * arr	return
 * 10	true
 * 12	true
 * 11	false
 * 13	false
 */
public class Hashad {
    public static void main(String[] args) {
        int x = 13;
        System.out.println(solution(x));
    }

    public static boolean solution(int x) {
        Integer sum = Arrays.stream(String.valueOf(x).split(""))
                .map(Integer::parseInt)
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);

        return (x % sum == 0);
    }
}
