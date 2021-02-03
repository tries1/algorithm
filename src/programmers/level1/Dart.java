package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Dart {
    public static class Score {
        Integer round;
        Integer score;
        String type;
        String option;

        public Score(Integer round, Integer score, String type, String option) {
            this.round = round;
            this.score = score;
            this.type = type;
            this.option = option;
        }

        public Integer calcurate() {
            Integer result = this.score;
            if ("D".equals(type)) {
                result = Integer.valueOf((int) Math.round(Math.pow(this.score, 2)));
            } else if ("T".equals(type)) {
                result = Integer.valueOf((int) Math.round(Math.pow(this.score, 3)));
            }

            if ("*".equals(option)) {
                //스타상(*) 2배
                result = result * 2;
            }

            if ("#".equals(option)) {
                //아차상(#) 점수는 마이너스된다.
                result = result * -1;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        //다트 게임은 총 3번의 기회로 구성된다.
        //각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
        //점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
        //옵션으로 스타상(은) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
        //스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
        //스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
        //스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
        //Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
        //스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.

        //String answer = "1S2D*3T";
        String answer = "1D2S#10S";
        solution(answer);
    }

    public static int solution(String dartResult) {
        Integer round = 1;
        List<Score> scoreList = new ArrayList<>();
        String temp = dartResult;

        while (!temp.isEmpty()) {
            String[] arr = temp.split("");

            for (int i = 0; i < arr.length; i++) {
                if ("S".equals(arr[i]) || "D".equals(arr[i]) || "T".equals(arr[i])) {
                    //처음으로 문자열을 만날경우.. 그 다음문자가 *, # 이라면 "그다음" 자리까지 컷
                    if (i + 1 != arr.length && (arr[i+1].equals("*") || arr[i+1].equals("#"))) {
                        scoreList.add(new Score(round++, Integer.parseInt(temp.substring(0, i)), arr[i], arr[i + 1]));
                        temp = temp.substring(i + 2);
                        break;
                    } else {
                        scoreList.add(new Score(round++, Integer.parseInt(temp.substring(0, i)), arr[i], ""));
                        temp = temp.substring(i+1);
                        break;
                    }
                }
            }
        }

        scoreList.stream().forEach(score -> System.out.println(score.round + " : " + score.score + " : " + score.type + " : " + score.option));

        scoreList.stream()
                .map(Score::calcurate)
                .forEach(score -> System.out.println(score));

        //3번째
        int total = 0;
        boolean star;
        Score score3 = scoreList.get(2);
        total += score3.calcurate();

        star = ("*".equals(score3.option)) ? true : false;

        //2번째
        Score score2 = scoreList.get(1);
        if (star) {
            total += score2.calcurate() * 2;
        } else {
            total += score2.calcurate();
        }

        star = ("*".equals(score2.option)) ? true : false;

        //1₩번째
        Score score1 = scoreList.get(0);
        if (star) {
            total += score1.calcurate() * 2;
        } else {
            total += score1.calcurate();
        }

        System.out.println("total : " + total);
        return total;
    }
}
