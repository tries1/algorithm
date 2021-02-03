package programmers.level1;

import java.util.Arrays;

public class Budget {
    public static void main(String[] args) {
        int[] d = {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000};
        int budget = 1;

        System.out.println(solution(d, budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget = budget - d[i];
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}
