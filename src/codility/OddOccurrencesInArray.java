package codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {

        //7
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        //배열내에 같은 짝이 없으면 그수를 리턴하면 된다
        Set<Integer> grp = new HashSet<>();
        for (int i = 0; i < A.length; i++) {

            if (!grp.contains(A[i])) {
                grp.add(A[i]);
            } else {
                grp.remove(A[i]);
            }
        }

        return grp.stream().findFirst().orElse(0);
    }
}
