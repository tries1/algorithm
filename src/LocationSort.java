import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제
 * 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
 * <p>
 * 출력
 * 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
 * <p>
 * 예제 입력 1
 * 5
 * 3 4
 * 1 1
 * 1 -1
 * 2 2
 * 3 3
 * <p>
 * 예제 출력 1
 * 1 -1
 * 1 1
 * 2 2
 * 3 3
 * 3 4
 */

public class LocationSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //int[][] location = {{3, 4}, {1, 1}, {1, -1}, {2, 2}, {3, 3}};
        int[][] location = new int[N][2];

        for (int i = 0; i < N; i++) {
            location[i][0] = sc.nextInt();
            location[i][1] = sc.nextInt();
        }

        Arrays.stream(location)
        .sorted((o1, o2) -> {
            //x좌표가 같으면 y좌표가 증가하는 순서
            if (o1[0] == o2[0]) {
                if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return Integer.compare(o1[0], o2[0]);

            }
        })
        .forEach(ints -> System.out.println(ints[0] + " " + ints[1]));
    }
}
