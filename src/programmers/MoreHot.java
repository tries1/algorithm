package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 문제 설명
 * 매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
 * <p>
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
 * Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 * <p>
 * 제한 사항
 * scoville의 길이는 1 이상 1,000,000 이하입니다.
 * K는 0 이상 1,000,000,000 이하입니다.
 * scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
 * 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
 * 입출력 예
 * scoville	K	return
 * [1, 2, 3, 9, 10, 12]	7	2
 * 입출력 예 설명
 * 스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
 * 새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
 * 가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
 * <p>
 * 스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
 * 새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
 * 가진 음식의 스코빌 지수 = [13, 9, 10, 12]
 * <p>
 * 모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
 */
public class MoreHot {
    public static void main(String[] args) {
        int[] answer = {1, 2, 3};
        int K = 11;
        System.out.println(solution(answer, K));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Food> fq = new LinkedList<>();
        for (int i = 0; i < scoville.length; i++) {
            fq.offer(new Food(scoville[i]));
        }
        PriorityQueue<Food> foodPQ = new PriorityQueue<>(fq);

        long littleHot = -1;
        while (littleHot != 0 && foodPQ.size() != 1) {
            littleHot = foodPQ.stream().filter(food -> food.scoville < K).count();

            while (littleHot != 0 && foodPQ.size() != 1) {
                if (foodPQ.peek().scoville < K) {
                    foodPQ.offer(new Food(foodPQ.poll().scoville + (foodPQ.poll().scoville * 2)));
                    answer++;
                    break;
                }
            }
        }

        return (foodPQ.size() == 1 && foodPQ.peek().scoville < K) ? -1 : answer;
    }


    public static class Food implements Comparable<Food> {
        public int scoville;

        public Food(int scoville) {
            this.scoville = scoville;
        }

        @Override
        public int compareTo(Food o) {
            return this.scoville > o.scoville ? 1 : -1;
        }
    }
}
