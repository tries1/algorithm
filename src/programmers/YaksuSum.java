package programmers;

import java.util.stream.IntStream;

/**
 * 약수 : 어떤수로 나누었을때 0으로 떨어지는수
 * 10 : 1 2 5 10
 *
 * <p>
 * 자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
 * <p>
 * 제한 사항
 * n은 0 이상 3000이하인 자연수입니다.
 * 입출력 예
 * n	return
 * 12	28
 * 5	6
 * 입출력 예 설명
 * 입출력 예 #1
 * 12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
 * <p>
 * 입출력 예 #2
 * 5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
 */
public class YaksuSum {
    public static void main(String[] args) {
        System.out.println(solution(5));//28
    }

    public static int solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> (n % i) == 0)
                .sum();
    }
}
