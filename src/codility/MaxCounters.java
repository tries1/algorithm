package codility;

public class MaxCounters {
    public static void main(String[] args) {

        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;

        // 3, 2, 2, 4, 2
        int[] answer = solution(N, A);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    //N으로 입력받은값만큼 배열을 만든후 0으로 초기화

    //이후 A[K]의 값을 하나씩 조회하여
    //1 <= X <= N 이라면, 해당 위치 index increase
    //N보다 크면, all increase
    public static int[] solution(int N, int[] A) {
        int[] answers = new int[N];
        int maximum = 0;
        for (int i = 0; i < A.length; i++) {
            if (1 <= A[i] && A[i] <= N) {
                answers[A[i]-1] = answers[A[i]-1] + 1;

                if(maximum < answers[A[i]-1]){
                    maximum = answers[A[i]-1];
                }
            }

            if (N < A[i]) {
                for (int j = 0; j < answers.length; j++) {
                    answers[j] = maximum;
                }
            }
        }

        return answers;
    }
}
