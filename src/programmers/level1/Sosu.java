package programmers.level1;

import java.util.ArrayList;
import java.util.List;
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
        System.out.println(solution(1000000));
    }

    public static int solution(int n) {
        boolean check = false;
        int result = 0;
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            // 이미 체크된 수의 배수는 확인하지 않는다
            if (arr[i] == 0) {
                continue;
            }

            // i를 제외한 i의 배수들은 0으로 체크
            for (int j = i + i; j <= n; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                result++;
            }
        }


        /*for (int i = 2; i <= n; i++) {
            if (i % 1 != 0 && i % 2 == 0 && i % i != 0) {
                continue;
            }
            System.out.println(i);

            for (int j = 1; j <= i; j++) {
                if (j != 1 && i != j && i % j == 0) {
                    check = true;
                    break;
                }
            }

            if (check == false) {
                result++;
            }

            check = false;
        }*/

        return result;
    }
}
