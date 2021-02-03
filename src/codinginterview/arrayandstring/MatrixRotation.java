package codinginterview.arrayandstring;

public class MatrixRotation {
    public static void main(String[] args) {
        /*
        0 , 1 , 2 , 3 , 4          21, 16, 10, 5, 0
        5 , 6 , 7 , 8 , 9          22, 17 ,11, 6, 1
        10, 11, 12, 13, 14   -->   23, 18, 12, 7, 2
        16, 17, 18, 19, 20         24, 19, 13, 8, 3
        21, 22, 23, 24, 25         25, 20, 14, 9, 4
         */

        //x,y -> x, y+1
        /*int[][] matrix = {
                 {0, 0},  {0, 1},  {0, 2},  {0, 3},  {0, 4}
                ,{0, 5},  {0, 6},  {0, 7},  {0, 8},  {0, 9}
                ,{0, 10}, {0, 11}, {0, 12}, {0, 13}, {0, 14}
                ,{0, 16}, {0, 17}, {0, 18}, {0, 19}, {0, 20}
                ,{0, 21}, {0, 22}, {0, 23}, {0, 24}, {0, 25}
        };*/

        int[][] matrix = new int[5][5];
        int[][] resultMatrix = new int[5][5];
        // 1칸씩 옆으로 이동하고 N개까
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.println(i + ", " + j);
                if(j == matrix[0].length-1) {
                    resultMatrix[i+1][j] = matrix[i+1][j];
                } else if(i == matrix[0].length-1) {
                    resultMatrix[i+1][j] = matrix[i+1][j];
                } else {
                    resultMatrix[i][j + 1] = matrix[i][j];
                }
            }
        }
    }
}
