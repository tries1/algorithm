package test;

public class Test4 {
    public static void main(String[] args) {
        int n = 4;

        int[][] arr = new int[4][4];

        /*
        arr[0][0] = 1;      arr[0][0] = 1;
        arr[1][0] = 2;      arr[1][0] = 2; x++
        arr[1][1] = 9;      arr[2][0] = 3; x++

        arr[2][0] = 3;      arr[3][0] = 4; x == n-1 && y == 0
        arr[2][1] = 10;     arr[3][1] = 5; y++
        arr[2][2] = 8;      arr[3][2] = 6; y++

        arr[3][0] = 4;      arr[3][3] = 7; x == y
        arr[3][1] = 5;      arr[2][2] = 8; x-- y--
        arr[3][2] = 6;      arr[1][1] = 9; x-- y--
        arr[3][3] = 7;      arr[2][1] = 10;
        */

        int x = -1, y = 0;
        int num = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else if (i % 3 == 2) {
                    x--;
                    y--;
                }

                arr[x][y] = num++;
            }

        }

        System.out.println(arr[0][0]);
        System.out.println(arr[1][0]);
        System.out.println(arr[1][1]);
        /*
        arr[0][0] = 1;
        arr[1][0] = 2;
        arr[1][1] = 9;
        */

        /*int[][] arr = new int[4][4];

        arr[0][0] = 1;
        arr[1][0] = 2;
        arr[2][0] = 3;
        arr[3][0] = 4;

        // x가 모두 다다랐을때 y 증가
        arr[3][1] = 5;
        arr[3][2] = 6;
        arr[3][3] = 7;

        //y가 모두 다다랐을때 다시 x감소
        arr[2][3] = 8;
        arr[1][2] = 9;
        arr[1][3] = ;*/

        //idx 증가 순서
        //1,2,4,6,10,16
    }
}
