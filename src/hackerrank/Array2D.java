package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Array2D {

    /*public static void main(String[] args) {
        int[][] arr = {
                {-9, -9, -9,  1, 1, 1},
                { 0, -9,  0,  4, 3, 2},
                {-9, -9, -9,  1, 2, 3},
                { 0,  0,  8,  6, 6, 0},
                { 0,  0,  0, -2, 0, 0},
                { 0,  0,  1,  2, 4, 0}
        };

    }

    public static Integer maxSubset(int i){

    }*/

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int answer = Integer.MIN_VALUE;

        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                System.out.println(hourglassIdxSum(x, y, arr));
                answer = Math.max(answer, hourglassIdxSum(x, y, arr));
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    static int hourglassIdxSum(int x, int y, int[][] arr) {
        return arr[x][y] + arr[x][y + 1] + arr[x][y + 2]
                + arr[x + 1][y + 1]
                + arr[x + 2][y] + arr[x + 2][y + 1] + arr[x + 2][y + 2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int[][] arr = new int[6][6];

        /*int[][] arr = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };*/

        int[][] arr = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };


        /*for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/

        int result = hourglassSum(arr);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
