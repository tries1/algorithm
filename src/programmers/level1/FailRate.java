package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class FailRate {
    public static class Stage {
        public Integer level;
        public Integer succesCount;
        public Integer failCount;
        public Double failRate;

        public Stage(Integer level, Integer succesCount, Integer failCount) {
            this.level = level;
            this.succesCount = succesCount;
            this.failCount = failCount;
        }
    }

    public static void main(String[] args) {
        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        //전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때
        // , 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

        //pseudocode

        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] answer = solution(N, stages);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    public static int[] solution(int N, int[] stages) {
        //각스테이지별 현황, 성고유저수, 실패 유저수
        List<Stage> stageStatusList = new ArrayList<>();
        int successCount, failCount;
        for (int i = 1; i <= N; i++) {
            successCount = 0;
            failCount = 0;

            for (int stage : stages) {
                if (i < stage) {
                    successCount++;
                } else if (i == stage) {
                    failCount++;
                }
            }
            stageStatusList.add(new Stage(i, successCount, failCount));
        }

        //각 스테이지별 실패율 계산후 실패율 스테이지 저장
        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        return stageStatusList.stream()
                .map(stage -> {
                    stage.failRate = Double.valueOf((double) stage.failCount / (double) (stage.failCount + stage.succesCount)) * 100;
                    return stage;
                })
                .sorted((o1, o2) -> {
                    if (o1.failRate > o2.failRate) {
                        return -1;
                    } else if (o1.failRate < o2.failRate) {
                        return 1;
                    } else {
                        return 0;
                    }
                })
                .map(stage -> stage.level)
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
