package hackerrank;

public class JumpingOnTheClouds {
    public static void main(String[] args) {
        //1
        //int n = 8;
        //String s = "UDDDUDUU";

        //4
        //int[] c = {0, 0, 1, 0, 0, 1, 0};

        //
        int[] c = {0, 0, 0, 0, 1, 0};

        System.out.println(solution(c));
    }

    public static int solution(int[] c) {
        int answer = 0;
        for (int i = 0; i < c.length; i++) {
            if (i == c.length - 1) {
                break;
            }

            if (i + 2 < c.length && c[i + 2] == 0) {
                i++;
            }

            answer++;
        }
        return answer;
    }
}
