package codinginterview.arrayandstring;

public class ZeroMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[3][3];
        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = num++;
                System.out.println(matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix.length; k++) {
                        /*for (int l = 0; l < ; l++) {
                            matrix[i -][j] = 0;
                            matrix[i][j -] = 0;
                        }*/
                    }
                }
            }
        }
    }
}
