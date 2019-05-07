package programmers;

/**
 * 소수 : 1과 자기자신으로만 나누어지는수
 * 1 ~ 100 : 25
 */
public class Sosu {
    public static void main(String[] args) {

        System.out.println(solution(100));
    }

    public static int solution(int num) {
        int result = 0, count = 0;
        for (int i = 2; i <= num; i++) {
            System.out.println("---------------- " + i + " -----------------");
            count = 0;
            for (int j = 2; j < i; j++) {//여기서 1과 자기자신 사이의 수만큼만 반복되도록 지정
                System.out.println(i + " % " + j + " = " + (i % j == 0));

                if ((i % j) == 0) {//1, 자신을 제외한 수중에 나누었을때 나머지가 0이되는 수가 있다면 소수가 아니다.
                    System.out.println(i + "는 소수가 아니다");
                    count++;
                    break;
                }

            }

            if (count == 0) {//나머지가 0인수가 하나라도 없다면 소수++
                result++;
            }
            System.out.println("---------------------------------");
        }


        return result;
        /*int count = 0, result = 0;

        for (int i = 2; i <= num; i++) // 1은 소수가 아니므로 2부터 시작
        {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }

            // 소수는 1과 자기자신으로만 나눠지므로 자기자신으로 한번만 나눠질때 소수
            if (count == 1) {
                result++;
            }
            count = 0;
        }

        return result;*/
    }
}
