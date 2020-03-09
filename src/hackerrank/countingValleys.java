package hackerrank;

public class countingValleys {
    public static void main(String[] args) {
        //1
        //int n = 8;
        //String s = "UDDDUDUU";

        //2
        int n = 12;
        String s = "DDUUDDUDUUUD";

        System.out.println(solution(n, s));
    }

    public static int solution(int n, String s) {
        int answer = 0;
        int level = 0;
        int prevLevel = level;

        String[] ar = s.split("");
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equals("U")) {
                level++;
            } else if (ar[i].equals("D")) {
                level--;
            }

            if (level == 0 && prevLevel < 0) {
                answer++;
            }

            prevLevel = level;
        }

        return answer;
    }
}
