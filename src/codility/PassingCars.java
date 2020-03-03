package codility;

public class PassingCars {

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1};
        System.out.println(solution(A));
    }

    // 2중 for문으로 하나하나 검사하면서 풀이하면 답은 정확하지만, 퍼포먼스틑 0점인된다.
    // 검색해보니 for문을 하나만 돌면서 0이 나올때만다 count증가값을 +1씩 해주도록 하면 반복을 한번만해도된다.
    public static int solution(int[] A) {
        int answer = 0;
        int acc = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                acc++;
            } else {
                answer += acc;

                if (1_000_000_000 < answer) {
                    return -1;
                }
            }
        }

        return answer;

        //가장 기본적인 풀이
        /*int answer = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                continue;
            }

            for (int j = i+1; j < A.length; j++) {
                if(A[j] == 1){
                    answer++;

                    if (1_000_000_000 < answer) {
                        return -1;
                    }
                }
            }
        }

        return answer;*/
    }
}
