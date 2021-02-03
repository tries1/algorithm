package programmers.level1;

import java.util.Arrays;

public class MatrixPlus {
    public static void main(String[] args) {

        int[][] arr1 = {{1}, {2}};
        int[][] arr2 = {{3}, {4}};
        int[][] result = solution(arr1, arr2);

        Arrays.stream(result).forEach(ints -> {
            String print = "";
            for (int anInt : ints) {
                print += anInt + ", ";
            }
            System.out.println(print);
        });
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[1].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[1].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }
}
