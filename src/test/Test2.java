package test;

public class Test2 {

    //수자
    public static void main(String[] args) {

        //10,10 = 4
        //18,2 = 6
        //'7' 의 경기를 최소진행
        System.out.println(solution(18, 2));
    }

    //N = 카지노를 떠날때 가지고간 chip
    //K = 최대 올인한 횟수
    //칩 하나로 시작했다

    //존이 가장적게 플레이한 수를 리턴하라
    public static int solution(int N, int K) {
        if (K == 0) {
            return N - 1;
        }

        int answer = 0;
        int chip = N;
        while (chip > 1) {
            if (0 < K && (chip % 2) == 0) {
                chip = chip / 2;
                K--;
            } else {
                chip--;
            }

            answer++;
        }

        return answer;
    }
}
