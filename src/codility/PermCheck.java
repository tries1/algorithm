package codility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermCheck {

    public static void main(String[] args) {

        //1
        int[] A = {4, 1, 3, 2};

        //0
        //int[] A = {4, 1, 3};

        // 0
        //int[] A = {1, 1};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        if (A.length == 0) { return 0; }

        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (integerSet.contains(A[i])) {
                return 0;
            }

            integerSet.add(A[i]);
        }

        int[] sort = integerSet.stream().mapToInt(Integer::intValue).sorted().toArray();
        for (int i = 0; i < sort.length; i++) {
            if (sort[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }
}
