package codility;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

    public static void main(String[] args) {

        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};

        //6
        System.out.println(solution(X, A));
    }

    //0부터 개구리는 출발
    //X+1 이 도착해야할 위치

    //모든위치에 나뭇잎이 떨어지는 가장 빠른 순간을 찾자
    public static int solution(int X, int[] A) {
        Set<Integer> leafMark = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            leafMark.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (leafMark.contains(A[i])) {
                leafMark.remove(A[i]);
            }

            if (leafMark.isEmpty()) {
                return i;
            }
        }

        return -1;
    }
}
