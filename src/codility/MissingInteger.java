package codility;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {
        //int[] A = {1, 3, 6, 4, 1, 2};
        //int[] A = {1, 2, 3};
        int[] A = {-1, -3, 1, 3};

        // 5
        System.out.println(solution(A));

        //1, 2, 3 -> 4
        //-1, -3 -> 1
    }

    //비어있는 수중 가장 작은수를 구하자
    //비어 있지 않다면 가장큰값의 +1
    //해당값이 음수라면 1 return
    public static int solution(int[] A) {
        int[] sort = Arrays.stream(A).filter(i -> i > 0).distinct().sorted().toArray();

        //음수가 모두 없어졌을때
        if(sort.length == 0){
            return 1;
        }

        for (int i = 0; i < sort.length; i++) {
            if (sort[i] != i + 1) {
                return i + 1;
            }
        }

        return sort[sort.length-1] + 1;
    }
}
