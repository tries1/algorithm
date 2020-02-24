package codility;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2};

        // 5
        System.out.println(solution(A));

        //1, 2, 3 -> 4
        //-1, -3 -> 1
    }

    //비어있는 수중 가장 작은수를 구하자
    //비어 있지 않다면 가장큰값의 +1
    //해당값이 음수라면 1 return
    public static int solution(int[] A) {
        int answer = 0;
        int[] sort = Arrays.stream(A).distinct().sorted().toArray();

        for (int i = 0; i < sort.length; i++) {
            if(sort[i] != i+1){
                return i+1;
            }
        }


        return answer;
    }
}
