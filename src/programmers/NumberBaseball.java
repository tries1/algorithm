package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.function.Function;

/**
 * 문제 설명
 * 숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
 * <p>
 * 각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다.
 * 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
 * <p>
 * 숫자는 맞지만, 위치가 틀렸을 때는 볼
 * 숫자와 위치가 모두 맞을 때는 스트라이크
 * 숫자와 위치가 모두 틀렸을 때는 아웃
 * 예를 들어, 아래의 경우가 있으면
 * <p>
 * A : 123
 * B : 1스트라이크 1볼.
 * A : 356
 * B : 1스트라이크 0볼. <-- 1스트라이크이면, 첫번쨰 질문에서 같은 위치의 숫자가 동일한게 있는지 확인, 볼이면 같은 숫자가 있는지 확인
 * A : 327
 * B : 2스트라이크 0볼. <-- 2스트라이크면 숫자 2개와 위치가 맞다는거니, 이전 결과와 비교해서 첫번째에서 볼이있고,
 * A : 489
 * B : 0스트라이크 1볼.
 * 이때 가능한 답은 324와 328 두 가지입니다.
 * <p>
 * 질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한사항
 * 질문의 수는 1 이상 100 이하의 자연수입니다.
 * baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
 * 입출력 예
 * baseball	return
 * [[123, 1, 1]
 * ,[356, 1, 0]
 * ,[327, 2, 0]
 * ,[489, 0, 1]]	2
 * 입출력 예 설명
 * 문제에 나온 예와 같습니다.
 */
public class NumberBaseball {
    public static void main(String[] args) {
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(solution(baseball));
    }

    //완전탐색이니깐, 1 ~ 999까지 반복하면서 위조건에 동일한 갯수를 구해보자
    public static int solution(int[][] baseball) {
        String answerNum;
        Stack<String> cadinate = new Stack<>();
        for (int i = 1; i <= 999; i++) {
            answerNum = String.valueOf(i);
            if (Arrays.stream(answerNum.split("")).filter(s -> !"0".equalsIgnoreCase(s)).distinct().count() != 3) {
                continue;
            }

            for (int[] ints : baseball) {
                int[] answerNumbers = Arrays.stream(answerNum.split("")).map(Integer::parseInt).mapToInt(value -> value).toArray();
                int[] numbers = Arrays.stream(String.valueOf(ints[0]).split("")).map(Integer::parseInt).mapToInt(value -> value).toArray();
                int strikeCount = ints[1];
                int ballCount = ints[2];

                if (check(answerNumbers, numbers, strikeCount, ballCount)) {
                    cadinate.push(answerNum);
                }
            }

        }

        return cadinate.size();
    }

    public static boolean check(int[] answerNum, int[] guessNum, int strike, int ball) {
        int tmpStrike = 0, tmpBall = 0;
        boolean checkResult = false;

        for (int i = 0; i < 3; i++) {
            //strike check
            if (answerNum[i] == guessNum[i]) {
                tmpStrike++;
                continue;
            }

            for (int j = i; j < guessNum.length; j++) {
                if (answerNum[i] == guessNum[j]) {
                    tmpBall++;
                }
            }

            if (strike == tmpStrike && ball == (tmpBall)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
