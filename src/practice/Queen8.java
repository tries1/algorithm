package practice;

/**
 * 1. 가지뻗기 -> 모든 경우의 수를 출력
 * 2. 분기한정법 -> 불필요한 경우의 수를 줄여나가기
 *
 * 위의 2가지 방법을 통하여 문제해결에 접근하도록 연습해야함
 */
public class Queen8 {
    static int[] pos = new int[8];
    static boolean[] flags_a = new boolean[8];
    static boolean[] flags_b = new boolean[15];
    static boolean[] flags_c = new boolean[15];

    public static void main(String[] args) {
        set(0);
    }

    public static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    public static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flags_a[j] == false &&
                flags_b[i + j] == false &&
                flags_c[i - j + 7] == false){
                pos[i] = j;
                if (i == 7) {
                    print();
                } else {
                    flags_a[j] = flags_b[i + j] = flags_c[i - j + 7] = true;
                    set(i + 1);
                    flags_a[j] = flags_b[i + j] = flags_c[i - j + 7] = false;
                }
            }

        }
    }
}
